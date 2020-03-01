package com.logic;

import com.domain.Date;
import com.domain.Employee;

import java.util.Scanner;

public class EmployeeInfoGetter {
    public static Employee getInput() {
        Scanner reader = new Scanner(System.in);

        System.out.print("id: "); String id = reader.nextLine();
        System.out.print("name: "); String name = reader.nextLine();

        String[] date;
        Date dateOfBirth = null;

        while (true) {
            try {
                System.out.print("date of birth: ");
                date = reader.nextLine().split(" ");
                if (date.length != 3) {
                    System.out.println("\twrong input");
                    continue;
                }
                else {
                    var year = Integer.parseInt(date[0]);
                    var month = Integer.parseInt(date[1]);
                    var day = Integer.parseInt(date[2]);

                    dateOfBirth = new Date(year, month, day);
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong input");
            }
        }

        System.out.print("gender: "); boolean gender = Boolean.parseBoolean(reader.nextLine().trim());
        System.out.print("company: "); String company = reader.nextLine();
        System.out.print("position: "); String position = reader.nextLine().trim().toUpperCase();

        reader.close();
        return new Employee(id, name, company, position, dateOfBirth, gender);
    }
}
