package com.example.employeeactivity.pojo;

public class Employee {
    private Integer code;
    private String name;
    private String job_title;
    private String emailId;
    private Integer experience;
    private Long phoneNumber;
    private String location;
    private String project_status;

    public Employee() {

    }

    public Employee(Integer code, String name, String job_title, String emailId, Integer experience, Long phoneNumber, String location, String project_status) {
        this.code = code;
        this.name = name;
        this.job_title = job_title;
        this.emailId = emailId;
        this.experience = experience;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.project_status = project_status;
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
}
