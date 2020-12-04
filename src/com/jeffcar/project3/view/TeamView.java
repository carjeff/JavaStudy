package com.jeffcar.project3.view;

import com.jeffcar.project3.service.NameService;
import com.jeffcar.project3.service.TeamService;
import com.jeffcar.project3.util.TSUtility;

/**
 * @author JeffCar
 * @date 11/24/2020 - 8:07 PM
 */
public class TeamView {


    private NameService service = new NameService();
    private TeamService teamService = new TeamService();

    public void enterMainMenu(){
        boolean flag = true;
        while (flag){
            listAllEmployee();

            System.out.println("1-团队列表 2-添加 3-删除 4-退出");
            char menu = TSUtility.readMenuSelection();
            switch (menu){
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    flag = false;
                    break;
            }
        }
    }

    private void listAllEmployee(){

    }
    private void getTeam(){
        System.out.println("获取");
    }

    private void addMember(){
        System.out.println("添加");
    }
    private void deleteMember(){
        System.out.println("删除");
    }

    public static void main(String[] args){
        TeamView view = new TeamView();
        view.enterMainMenu();
    }
}
