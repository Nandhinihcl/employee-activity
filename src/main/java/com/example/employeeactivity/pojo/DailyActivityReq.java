package com.example.employeeactivity.pojo;

public class DailyActivityReq {
    private String fromDate;
    private String toDate;


    public DailyActivityReq(String fromDate, String toDate) {
        this.fromDate = fromDate;
        this.toDate = toDate;
    }


    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }
}
