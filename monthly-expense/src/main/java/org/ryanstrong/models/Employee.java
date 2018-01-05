package org.ryanstrong.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {
    // employee types have titles and pay
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String title;

    private Integer pay;

    public Employee(){}

    public Employee(
            String name, String title, Integer pay
    ){
        this.name=name;
        this.title=title;
        this.pay=pay;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPay() {
        return pay;
    }

    public void setPay(Integer pay) {
        this.pay = pay;
    }
}
