package com.example.employeeactivity.dao;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "activity")
public class Activity {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer empCode;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String description;
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmpCode() {
        return empCode;
    }

    public void setEmpCode(Integer emp_code) {
        this.empCode = emp_code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void copyFromPojo(com.example.employeeactivity.pojo.Activity activity) {
        this.setEmpCode(activity.getEmpCode());
        if (activity.getDate() != null)
            this.setDate(activity.getDate());
        if (activity.getDescription() != null)
            this.setDescription(activity.getDescription());
        if (activity.getStatus() != null)
            this.setStatus(activity.getStatus());
    }

    public com.example.employeeactivity.pojo.Activity getPojo() {
        com.example.employeeactivity.pojo.Activity activity = new com.example.employeeactivity.pojo.Activity();
        activity.setEmpCode(this.getEmpCode());
        activity.setDate(this.getDate());
        activity.setDescription(this.getDescription());
        activity.setStatus(this.getStatus());
        return activity;
    }
}
