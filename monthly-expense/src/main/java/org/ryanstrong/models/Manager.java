package org.ryanstrong.models;

import javax.persistence.*;
import java.util.List;
//managers have names, monthly pay, employees, monthly expense
@Entity
public class Manager {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Integer pay = 1000;

    private Integer allocation; // sum of employee pay

    private Integer expense;// allocation + pay

    @OneToMany
    @JoinColumn(name ="employeeType_id")
    private List<Employee> employees;

    public Manager(){}


    //    public Manager(String name, Integer pay, List<Employee> employees) use List<Employees> when employees are mutable
    public Manager(String name, Integer pay, List<Employee> employees, Integer expense, Integer allocation){
        this.name = name;
        this.pay=pay;
        this.employees=employees;
        this.expense=expense;
        this.allocation=allocation;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPay() {
        return pay;
    }

    public void setPay(Integer pay) {
        this.pay = pay;
    }

    public List getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Integer getExpense() {
        return expense;
    }

    public void setExpense(Integer expense) {
        this.expense = expense;
    }

    public Integer getAllocation() {
        return allocation;
    }

    public void setAllocation(Integer allocation) {
        this.allocation = allocation;
    }


}
