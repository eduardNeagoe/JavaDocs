package ro.teamnet.zth.appl.controller;

import ro.teamnet.zth.appl.annotations.MyController;
import ro.teamnet.zth.appl.annotations.MyRequestMethod;
import ro.teamnet.zth.appl.annotations.MyRequestObject;
import ro.teamnet.zth.appl.annotations.MyRequestParam;
import ro.teamnet.zth.appl.domain.Job;
import ro.teamnet.zth.service.JobService;
import ro.teamnet.zth.service.JobServiceImpl;

import java.util.List;

/**
 * Created by Eduard on 15.07.2016.
 */

@MyController(urlPath =  "/jobs")
public class JobController {
    private final JobService jobService = new JobServiceImpl();

    @MyRequestMethod(urlPath = "/all", methodType = "GET")
    public List<Job> getAllJobs(){
        return jobService.getAllJobs();
    }

    @MyRequestMethod(urlPath = "/one", methodType = "GET")
    public Job getOneJob(@MyRequestParam(name = "id") String id){
        return jobService.findOneJob(id);
    }

    @MyRequestMethod(urlPath = "/one", methodType = "DELETE")
    public void deleteJob(@MyRequestParam(name = "id") String id){
        jobService.deleteJob(id);
    }

    @MyRequestMethod(urlPath = "/create", methodType = "POST")
    public void addJob(@MyRequestObject Job job){
        jobService.addOneJob(job);
    }

}