package com.pluralsight;

import java.time.LocalDateTime;

public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private double startTime;   // 0 means "not punched in"

    public Employee(int employeeId, String name, String department, double payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = 0;
        this.startTime = 0;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getPayRate() {
        return payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    // Track when the shift started
    public void punchIn(double time) {
        startTime = time;
    }

    public void punchIn(){
        startTime = LocalDateTime.now().getHour();
    }

    // Shift over: add its length to the total and clear the start time
    public void punchOut(double time) {
        double duration = time - startTime;
        hoursWorked += duration;
        startTime = 0;
    }

    public void punchOut(){
        double duration = LocalDateTime.now().getHour() - startTime;
        hoursWorked += duration;
        startTime = 0;
    }

    // BONUS: one method for both. No start time stored -> this is a punch in;
    // a start time stored -> this is a punch out
    public void punchTimeCard(double time) {
        if (startTime == 0) {
            startTime = time;
        } else {
            double duration = time - startTime;
            hoursWorked += duration;
            startTime = 0;
        }
    }

    // Derived getters, unchanged from Section 2-1
        public double getTotalPay() {
        return (getRegularHours() * payRate) + (getOvertimeHours() * payRate * 1.5);
    }

    public double getRegularHours() {
        if (hoursWorked <= 40) {
            return hoursWorked;
        } else {
            return 40;
        }
    }

    public double getOvertimeHours() {
        if (hoursWorked > 40) {
            return hoursWorked - 40;
        } else {
            return 0;
        }
    }
}
