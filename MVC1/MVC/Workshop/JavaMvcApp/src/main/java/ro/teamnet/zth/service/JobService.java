package ro.teamnet.zth.service;

import ro.teamnet.zth.appl.domain.Job;

import java.util.List;

/**
 * Created by Eduard on 18.07.2016.
 */
public interface JobService {
    List<Job> getAllJobs();

    Job findOneJob(String id);

    void deleteJob(String id);

    void addOneJob(Job job);
}
