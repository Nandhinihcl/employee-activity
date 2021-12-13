package com.example.employeeactivity.dao;

import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface ActivityCRUD extends CrudRepository<Activity, Integer> {
    Activity findByEmpCode(Integer code);

    Iterable<Activity> findByDateBetween(Date fromDate, Date toDate);

    Iterable<Activity> findByDate(Date date);
}
