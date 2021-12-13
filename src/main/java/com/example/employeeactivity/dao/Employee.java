package com.example.employeeactivity.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue
    private Integer emp_id;
    private Integer code;
    private String name;
    private String job_title;
    private String emailId;
    private Integer experience;
    private Long phoneNumber;
    private String location;
    private String project_status;

    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProject_status() {
        return project_status;
    }

    public void setProject_status(String project_status) {
        this.project_status = project_status;
    }

    public void createDAOFromPojo(com.example.employeeactivity.pojo.Employee emp) {
        this.setCode(emp.getCode());
        this.setName(emp.getName());
        this.setJob_title(emp.getJob_title());
        this.setEmailId(emp.getEmailId());
        this.setExperience(emp.getExperience());
        this.setPhoneNumber(emp.getPhoneNumber());
        this.setLocation(emp.getLocation());
        this.setProject_status(emp.getProject_status());
    }

    public com.example.employeeactivity.pojo.Employee getPojo() {
        com.example.employeeactivity.pojo.Employee emp = new com.example.employeeactivity.pojo.Employee();
        emp.setName(this.getName());
        emp.setCode(this.getCode());
        emp.setJob_title(this.getJob_title());
        emp.setEmailId(this.getEmailId());
        emp.setExperience(this.getExperience());
        emp.setPhoneNumber(this.getPhoneNumber());
        emp.setLocation(this.getLocation());
        emp.setProject_status(this.getProject_status());
        return emp;
    }
}

