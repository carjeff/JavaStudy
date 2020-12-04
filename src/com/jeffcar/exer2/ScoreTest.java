package com.jeffcar.exer2;

import java.util.Scanner;
import java.util.Vector;

/**
 * @author JeffCar
 * @date 11/22/2020 - 1:38 PM
 */
public class ScoreTest {
    public static void main(String[] agrs){
        Scanner scanner = new Scanner(System.in);
        Vector vector =  new Vector();

        while (true){
            System.out.println("请输入学生成绩");
            int score = scanner.nextInt();
            vector.addElement(score);
        }
    }


}
