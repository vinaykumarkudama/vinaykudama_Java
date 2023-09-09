package com.gl.emp;

import java.io.Serializable;

public class Employee implements Serializable {
    private String employeeId;
    private String employeeName;
    private String employeePhone;
    private String employeeAddress;
    private int employeeSalary;

    public Employee(String employeeId, String employeeName, String employeePhone, String employeeAddress, int employeeSalary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeePhone = employeePhone;
        this.employeeAddress = employeeAddress;
        this.employeeSalary = employeeSalary;
    }

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeePhone=" + employeePhone + ", employeeAddress=" + employeeAddress + ", employeeSalary=" + employeeSalary + "]";
    }
}
