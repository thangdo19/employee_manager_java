package com.domain;

//Thông tin nhân viên cần quản lý gồm: mã nhân viên,
//        họ, tên, ngày sinh (ngày, tháng, năm), giới tính, đơn vị,
//        chức vụ, hệ số lương, lương, phụ cấp, thực lĩnh. Bổ sung các
//        chức năng sau:
//        ●	Xóa các nhân viên có độ tuổi >50
//        ●	Tính lương, phụ cấp (PC), thực lĩnh (T
//        L) cho các nhân viên theo qui ước:
//        Lương = hệ số lương * lương cơ bản (LCB =850)
//        TL = lương + PC
//        ●	In ra bảng thống kê theo đơn vị gồm các cột: đơn vị,
//        số nhân viên nam, số nhân viên nữ, tổng thực lĩnh


import java.util.Objects;

public class Employee {
    private String employeeID;
    private String name;
    private String company;
    private String position;
    private Date dateOfBirth;
    private byte coefficient;
    private boolean gender;
    private static final double basicSalary = 850;

    public Employee(String employeeID, String name, String company, String position, Date dateOfBirth, boolean gender) {
        this.employeeID = employeeID;
        this.name = name;
        this.company = company;
        this.position = position;
        this.dateOfBirth = dateOfBirth;
        this.coefficient = settingCoefficient(position);
        this.gender = gender;
    }
    public Employee(Employee other) {
        this.employeeID = other.employeeID;
        this.name = other.name;
        this.company = other.company;
        this.position = other.position;
        this.dateOfBirth = other.dateOfBirth;
        this.coefficient = other.coefficient;
        this.gender = other.gender;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getPosition() {
        return position;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public byte getCoefficient() {
        return coefficient;
    }

    public boolean isGender() {
        return gender;
    }

    public Employee(String id) {
        this(id, "", "", "", new Date(1, 1, 1), false);
    }

    private static byte settingCoefficient(String position) {
        if (position.equals("NHAN VIEN"))
            return 5;
        else if (position.equals("TRUONG PHONG"))
            return 10;
        else if (position.equals("GIAM DOC"))
            return 15;
        return 1; // others
    }

    public double salary() {
        return coefficient * basicSalary;
    }

    public double allowance() {
        if (coefficient == 5)
            return 0;
        else if (coefficient == 10)
            return 0.25 * salary();
        else // coefficient == 15
            return 0.4 * salary();
    }

    public double totalSalary() {
        return salary() + allowance();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID='" + employeeID + '\'' +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", position='" + position + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", coefficient=" + coefficient +
                ", gender=" + (gender?"NAM":"NU") +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeID, employee.employeeID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeID);
    }
}
