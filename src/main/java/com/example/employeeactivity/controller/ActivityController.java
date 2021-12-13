package com.example.employeeactivity.controller;

import com.example.employeeactivity.dao.ActivityCRUD;
import com.example.employeeactivity.pojo.Activity;
import com.example.employeeactivity.pojo.DailyActivityReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/dailyactivity")
public class ActivityController {

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD");
    @Autowired
    private ActivityCRUD activityCRUD;

    @PostMapping(path = "/add")
    public @ResponseBody
    String addDailyActivity(@RequestBody Activity activity) throws Exception {
        System.out.println("Request received to add Activity " + activity.getEmpCode());
        com.example.employeeactivity.dao.Activity activityDAO = new com.example.employeeactivity.dao.Activity();
        activityDAO.copyFromPojo(activity);
        try {
            activityCRUD.save(activityDAO);
        } catch (Exception exception) {
            System.out.println("Failed to save activity");
            throw new Exception("Failed to Save activity");
        }
        return "DailyActivity Added successfully";
    }

    @GetMapping(path = "/empcode/{code}")
    public @ResponseBody
    Activity viewDailyActivityWithName(@PathVariable Integer code) {
        System.out.println("Request received to fetch Activity " + code);
        try {
            com.example.employeeactivity.dao.Activity activityDAO = activityCRUD.findByEmpCode(code);
            if (activityDAO == null) {
                System.out.println("No activity found with given code " + code);
                return null;
            } else {
                return activityDAO.getPojo();
            }
        } catch (Exception exception) {
            System.out.println("Failed: " + exception.getMessage());
        }
        return null;
    }

    @PatchMapping(path = "/edit")
    public @ResponseBody
    String editDailyActivity(@RequestBody Activity activity) {
        System.out.println("Request received to edit Activity " + activity.getEmpCode());
        try {
            com.example.employeeactivity.dao.Activity activityDAO = activityCRUD.findByEmpCode(activity.getEmpCode());
            if (activityDAO == null) {
                System.out.println("No activity found with given code " + activity.getEmpCode());
                return "No activity found with given code " + activity.getEmpCode();
            } else {
                activityDAO.copyFromPojo(activity);
                activityCRUD.save(activityDAO);
            }
        } catch (Exception exception) {
            System.out.println("Failed: " + exception.getMessage());
        }
        return "Daily Activity is edited using valid inputs";
    }

    @PostMapping(path = "")
    public @ResponseBody
    Iterable<Activity> viewDailyActivities(@RequestBody DailyActivityReq dailyActivityReq) {
        System.out.println("Request received to get all Activities");
        List<Activity> activities = new ArrayList<>();
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD");
            Iterable<com.example.employeeactivity.dao.Activity> activityDAOs = activityCRUD.findByDateBetween(simpleDateFormat.parse(dailyActivityReq.getFromDate()), simpleDateFormat.parse(dailyActivityReq.getToDate()));
            if (activities == null) {
                System.out.println("No activity found with given code ");

            } else {
                for (com.example.employeeactivity.dao.Activity a : activityDAOs) {
                    activities.add(a.getPojo());
                }
            }
        } catch (Exception exception) {
            System.out.println("Failed: " + exception.getMessage());
        }
        return activities;
    }

    @GetMapping(path = "/{date}")
    public @ResponseBody
    Iterable<Activity> viewDailyActivity(@PathVariable String date) {
        System.out.println("Request received to get all Activities");
        List<Activity> activities = new ArrayList<>();
        try {
            Iterable<com.example.employeeactivity.dao.Activity> activityDAOs = activityCRUD.findByDate(simpleDateFormat.parse(date));
            if (activities == null) {
                System.out.println("No activity found with given code ");

            } else {
                for (com.example.employeeactivity.dao.Activity a : activityDAOs) {
                    activities.add(a.getPojo());
                }
            }
        } catch (Exception exception) {
            System.out.println("Failed: " + exception.getMessage());
        }
        return activities;
    }

}
