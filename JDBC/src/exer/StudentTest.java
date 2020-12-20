package exer;

import Utils.JDBCUtils;
import bean.Student;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

/**
 * @author JeffCar
 * @date 12/20/2020 - 4:42 PM
 */
public class StudentTest {


    @Test
    public void test()  {

        Scanner scanner = new Scanner(System.in);
        System.out.println("四级/六级：");
        int type = scanner.nextInt();
        System.out.println("身份证号：");
        String IDCard = scanner.next();
        System.out.println("准考证号：");
        String examCard = scanner.next();
        System.out.println("学生姓名：");
        String studentName = scanner.next();
        System.out.println("所在城市：");
        String location = scanner.next();
        System.out.println("考试成绩：");
        int grade = scanner.nextInt();

        String sql = "insert into examstudent(type,IDCard,examCard,studentName,location,grade)values(?,?,?,?,?,?)";
        int update = 0;
        try {
            update = update1(sql, type, IDCard, examCard, studentName, location, grade);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (update>0){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }


    }

    //实现更新操作
    private int update1(String sql , Object ... args) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = JDBCUtils.getConnection();
            ps = connection.prepareStatement(sql);
            for (int i = 0; i< args.length; i++){
                ps.setObject(i+1, args[i]);
            }
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection, ps);
        }

        return 0;
    }
    public <T> T getInstance(Class<T> c ,String sql, Object ... args){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            ps = connection.prepareStatement(sql);
            for (int i=0; i<args.length; i++){
                ps.setObject(i+1, args[i]);
            }

            resultSet = ps.executeQuery();

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            if (resultSet.next()){
                T t = c.newInstance();
                for (int i=0; i<columnCount; i++){
                    Object value = resultSet.getObject(i + 1);

                    String columnLabel = metaData.getColumnLabel(i + 1);

                    Field declaredField = c.getDeclaredField(columnLabel);
                    declaredField.setAccessible(true);
                    declaredField.set(t, value);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection, ps, resultSet);
        }

        return null;
    }

    @Test
    public void test2(){
        System.out.println("请选择输入的类型");
        System.out.println("a. 准考证号");
        System.out.println("b. 身份证号");
        Scanner scanner = new Scanner(System.in);
        String selection = scanner.next();
        if ("a".equals(selection)){
            System.out.println("请输入准考证号：");
            String examCard = scanner.next();
            String sql = "select FlowID flowID, Type type, IDCard, ExamCard examCard, StudentName studentName, Location location, Grade grade from examstudent where examCard = ?";
            Student instance = getInstance(Student.class, sql, examCard);
            System.out.println(instance);
        }else if ("b".equals(selection)){
            System.out.println("请输入身份证号：");
            String IDCard = scanner.next();
            String sql = "select FlowID flowID, Type type, IDCard, ExamCard examCard, StudentName studentName, Location location, Grade grade from examstudent where IDCard = ?";
            Student instance = getInstance(Student.class, sql, IDCard);
            System.out.println(instance);
        }else{
            System.out.println("输入有误.");
        }
    }
}
