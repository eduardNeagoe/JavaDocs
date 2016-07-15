package ro.teamnet.zth.appl.controller;

import ro.teamnet.zth.appl.annotations.MyController;
import ro.teamnet.zth.appl.annotations.MyRequestMethod;

/**
 * Created by Eduard on 15.07.2016.
 */

@MyController(urlPath =  "/jobs")
public class JobController {

    @MyRequestMethod(urlPath = "/all", methodType = "GET")
    public String getAllJobs(){
        return "allJobs";
    }

    @MyRequestMethod(urlPath = "/one", methodType = "GET")
    public String getOneJob(){
        return "oneRandomJob";
    }
}