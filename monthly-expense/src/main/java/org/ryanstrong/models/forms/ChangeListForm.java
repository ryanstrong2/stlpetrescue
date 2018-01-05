package org.ryanstrong.models.forms;

import org.ryanstrong.models.Employee;
import org.ryanstrong.models.Manager;

import java.util.List;

public class ChangeListForm {
    private Integer managerId;
    private Integer employeeId;
    private Manager manager;
    private List<Employee> employees;
    private Integer employeePay;

    public ChangeListForm(List employees, Iterable<Employee> all, Manager manager){}

    public ChangeListForm(
            Integer employeeId,
            List<Employee> employees,
            Integer employeePay,
            Manager manager
    ) {
        this.employeeId = employeeId;
        this.employees = employees;
        this.employeePay=employeePay;
        this.manager = manager;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Integer getEmployeePay() {
        return employeePay;
    }

    public void setEmployeePay(Integer employeePay) {
        this.employeePay = employeePay;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
