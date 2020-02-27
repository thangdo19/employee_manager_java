package com.logic;

import com.domain.Date;
import com.domain.Employee;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManager {
    private ArrayList<Employee> list;

    public EmployeeManager() {
    }

    public void add(Employee employee) {
        if (list == null)
            list = new ArrayList<Employee>();
        if (!list.contains(employee))
            list.add(employee);
    }

    public boolean remove(String id) {
        if (this.list.contains(new Employee(id))) {
            list.remove(new Employee(id));
            return true;
        }
        else
            return false;
    }

    public void readFromFile(String filePath) {
        var file = new File(filePath);
        try {
            var reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] parts = line.split("\t");
                int[] date = getArrayDate(parts[2].split(" "));

                this.add(new Employee(parts[0], parts[1], parts[4], parts[5],
                        new Date(date[0], date[1], date[2]), Boolean.parseBoolean(parts[3])));
            }
        } catch (FileNotFoundException e) {
            System.out.println("cannot open the file");
        }
    }
    public static int[] getArrayDate(String[] dateParts) {
        int[] date = new int[3];
        for (int i=0; i<3; i++) {
            date[i] = Integer.parseInt(dateParts[i]);
        }
        return date;
    }

    public void writeToFile(String filePath) {
        try (var writer = new FileWriter(filePath)) {
            if (list == null) return;
            for (Employee employee : list) {
                String info = employee.getEmployeeID() + "\t" +
                        employee.getName() + "\t" +
                        employee.getDateOfBirth().toString() + "\t" +
                        employee.isGender() + "\t" +
                        employee.getCompany() + "\t" +
                        employee.getPosition() + "\n";

                writer.write(info);
            }
        } catch (IOException e) {
            System.out.println("cannot find the path");
        }
    }

    public void printList() {
        for (var e : list) {
            System.out.println(e);
        }
    }

    @Override
    public String toString() {
        return "EmployeeManager{" +
                "list=" + list +
                '}';
    }
}
