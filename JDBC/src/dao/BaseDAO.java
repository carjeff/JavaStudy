package dao;

import Utils.JDBCUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author JeffCar
 * @date 12/21/2020 - 4:47 PM
 */
public abstract class BaseDAO<T> {
    private Class<T> c = null;
    {
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Type[] types = parameterizedType.getActualTypeArguments();
        c = (Class<T>) types[0]; //泛型的第一个参数
    }

    //通用的增删改操作
    public int update(Connection connection, String sql, Object ... args) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            for (int i=0; i<args.length; i++){
                ps.setObject(i+1, args[i]);
            }
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null, ps);
        }
        return 0;
    }
    //通用的查询操作，返回一个对象

    public T getInstance(Connection connection, String sql, Object ... args) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = connection.prepareStatement(sql);
            for (int i =0 ; i<args.length; i++){
                ps.setObject(i+1, args[i]);
            }
            resultSet = ps.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            if (resultSet.next()){
                T t = c.newInstance();
                for (int i =0; i<columnCount; i++){
                    Object value = resultSet.getObject(i + 1);
                    String columnLabel = metaData.getColumnLabel(i + 1);

                    Field declaredField = c.getDeclaredField(columnLabel);
                    declaredField.setAccessible(true);
                    declaredField.set(t, value);
                }
                return t;
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null, ps, resultSet);
        }

        return null;
    }
    //通用的查询操作，返回多个对象的
    public List<T> getListInstance(Connection connection, String sql, Object ... args) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = connection.prepareStatement(sql);
            for (int i = 0; i<args.length; i++){
                ps.setObject(i+1, args[i]);
            }
            resultSet = ps.executeQuery();

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            ArrayList<T> arrayList = new ArrayList<>();
            while (resultSet.next()){
                T t = c.newInstance();
                for (int i = 0; i<columnCount; i++){
                    Object value = resultSet.getObject(i + 1);

                    String columnLabel = metaData.getColumnLabel(i + 1);
                    Field declaredField = c.getDeclaredField(columnLabel);
                    declaredField.setAccessible(true);
                    declaredField.set(t, value);
                }
                arrayList.add(t);
            }
            return arrayList;
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null, ps, resultSet);
        }
        return null;
    }


    //通用查询特殊值的方法
    public <T> T getValue(Connection connection, String sql, Object... args) throws SQLException {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = connection.prepareStatement(sql);
            for (int i=0; i<args.length; i++){
                ps.setObject(i+1, args[i]);
            }

            resultSet = ps.executeQuery();
            if (resultSet.next()){
                return (T) resultSet.getObject(1);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null, ps, resultSet);
        }
        return null;
    }
}
