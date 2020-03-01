package com;

import com.domain.*;
import com.logic.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        var employee = EmployeeInfoGetter.getInput();

        var manager = new EmployeeManager();
        manager.readFromFile("src/textfile.txt");

//        manager.add(employee);
//
        manager.printList();
//
//        manager.remove(employee.getEmployeeID());

//        manager.printList();
//        manager.sortAgainstAge();
//        manager.printList();

//        var employee = EmployeeInfoGetter.getInput();
    }
}
