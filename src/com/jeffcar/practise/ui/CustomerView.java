package com.jeffcar.practise.ui;

import com.jeffcar.practise.bean.Customer;
import com.jeffcar.practise.service.CustomerList;
import com.jeffcar.practise.util.CMUtility;

/**
 * @author JeffCar
 * @date 11/21/2020 - 11:56 AM
 */
public class CustomerView {
    private CustomerList customerList = new CustomerList(10);

    public CustomerView(){
        Customer customer = new Customer("车子杰",'男',22,"1231241124","chezijie@qq.com");
        customerList.addCustomer(customer);
    }
    public void enterMainMenu(){

        boolean isFlag = true;
        while (isFlag){
            System.out.println("*******************客户信息管理软件******************");
            System.out.println();
            System.out.println("                     1.添加客户");
            System.out.println("                     2.修改客户");
            System.out.println("                     3.删除客户");
            System.out.println("                     4.客户列表");
            System.out.println("                     5.退  出\n");
            System.out.println("                    请选择（1-5）：");

            char menu = CMUtility.readMenuSelection();
            switch (menu){
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomer();
                    break;
                case '5':
                    System.out.println("确认是否退出(Y/N):");
                    char isExit = CMUtility.readConfirmSelection();
                    if(isExit == 'Y'){
                        break;
                    }

            }

        }

    }

    private void addNewCustomer(){
        System.out.println("----------------------添加客户-----------------\n");
        System.out.print("姓名： ");
        String name = CMUtility.readString(10);
        System.out.print("性别： ");
        char gender = CMUtility.readChar();
        System.out.print("年龄： ");
        int age = CMUtility.readInt();
        System.out.print("电话： ");
        String phone = CMUtility.readString(13);
        System.out.print("邮箱： ");
        String email = CMUtility.readString(30);

        Customer customer = new Customer(name,gender,age,phone,email);
        boolean isSuccess = customerList.addCustomer(customer);
        if(isSuccess){
            System.out.println("----------------------添加成功-----------------\n");
        }else {
            System.out.println("----------------------添加失败-----------------\n");
        }
    }

    private void modifyCustomer(){

    }

    private void deleteCustomer(){

    }

    private void listAllCustomer(){
        System.out.println("----------------------客户列表-----------------\n");

        if(customerList.getTotal() == 0){
            System.out.println("没有客户记录");
        }else {
            System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t邮件");
            Customer[] custs = customerList.getAllCustomers();
            for (int i=0; i<custs.length; i++){
                Customer customer = custs[i];
                System.out.println((i+1)+"\t\t"+customer.getName()+"\t"+customer.getGender()+"\t\t"+customer.getAge()+"\t\t"+customer.getPhone()+"\t"+customer.getEmail());
            }
        }

    }

    public static void main(String[] args){
        CustomerView view = new CustomerView();
        view.enterMainMenu();
    }
}
