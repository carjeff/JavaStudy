package com.jeffcar.project3.service;

import com.jeffcar.project3.bean.Architect;
import com.jeffcar.project3.bean.Designer;
import com.jeffcar.project3.bean.Employee;
import com.jeffcar.project3.bean.Programmer;

/**
 * @author JeffCar
 * @date 11/24/2020 - 8:08 PM
 */
public class TeamService {

    private static int counter = 1;
    private final int MAX_MEMBER = 5;
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total;


    public Programmer[] getTeam(){
        Programmer[] programmers = new Programmer[total];
        for (int i=0; i<programmers.length;i++){
            programmers[i] = team[i];
        }
        return programmers;

    }

    public void addMember(Employee employee) throws TeamException{
        if(total>=MAX_MEMBER){
            throw new TeamException("成员已满，无法添加");
        }
        if(!(employee instanceof Programmer)){
            throw new TeamException("该成员不是开发人员，无法添加");
        }
        if(isExist(employee)){
            throw new TeamException("成员已满，无法添加");
        }

        Programmer programmer = (Programmer) employee;

        if("BUSY".equals(((Programmer) employee).getStatus().getNAME())){
            throw new TeamException("该成员已经是某团队成员，无法添加");
        }else if ("VOCATION".equals(((Programmer) employee).getStatus().getNAME())){
            throw new TeamException("该成员在休假，无法添加");
        }

        int numOfArch =0, numOfDes=0, numOfPro = 0;
        for (int i=0; i<total; i++){
            if(team[i] instanceof Architect){
                numOfArch++;
            }else if (team[i] instanceof Designer){
                numOfDes++;
            }else if (team[i] instanceof Programmer){
                numOfPro++;
            }
        }

        if (programmer instanceof Architect){
            if(numOfArch>=1){
                throw new TeamException("团队中至多有一名架构师，无法添加");
            }

        }else if (programmer instanceof Designer){
            if (numOfDes >=2){
                throw new TeamException("团队中至多有两名设计师师，无法添加");
            }
        }else if (programmer instanceof Programmer){
            if (numOfPro >= 3){
                throw new TeamException("团队中至多有三名程序员，无法添加");
            }
        }


        team[total++] = programmer;
        programmer.setStatus(Status.BUSY);
        programmer.setMemberId(counter++);


    }

    private boolean isExist(Employee e){
        for (int i =0; i<total; i++){
            if(team[i].getId() == e.getId()){
                return true;
            }
        }
        return false;
    }



    public void removeMember(int memberId) throws TeamException{
        int i;
        for (i=0; i<total;i++){
            if (team[i].getMemberId() == memberId){
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        if(i==total){
            throw new TeamException("找不到该成员，无法删除");
        }
        for (int j =i+1; j<total; j++ ){
            team[j-1] = team[j];
        }
        team[--total] =null;

    }
}
