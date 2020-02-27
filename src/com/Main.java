package com;

import com.domain.*;
import com.logic.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        var manager = new EmployeeManager();
        manager.readFromFile("src/textfile.txt");
        manager.printList();
//        manager.writeToFile("src/textfile");

        System.out.print("id: "); String id = reader.nextLine();
        System.out.print("name: "); String name = reader.nextLine();

        System.out.print("date of birth: ");
        String[] date = reader.nextLine().split(" ");
        var day = Integer.parseInt(date[2]);
        var month = Integer.parseInt(date[1]);
        var year = Integer.parseInt(date[0]);
        var dateOfBirth = new Date(year, month, day);

        System.out.print("gender: "); boolean gender = Boolean.parseBoolean(reader.nextLine());
        System.out.print("company: "); String company = reader.nextLine();
        System.out.print("position: "); String position = reader.nextLine().trim().toUpperCase();

        var employee1 = new Employee(id, name, company, position, dateOfBirth, gender);

        manager.add(employee1);

        manager.writeToFile("src/textfile.txt");
    }
}
