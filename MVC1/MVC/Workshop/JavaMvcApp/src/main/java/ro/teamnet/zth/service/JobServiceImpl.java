package ro.teamnet.zth.service;

import ro.teamnet.zth.appl.dao.JobDao;
import ro.teamnet.zth.appl.domain.Job;

import java.util.List;

/**
 * Created by Eduard on 18.07.2016.
 */
public class JobServiceImpl implements JobService{
    public JobDao jobDao = new JobDao();
    @Override
    public List<Job> getAllJobs() {
        List<Job> listJobs = jobDao.getAllJobs();
        return listJobs;
    }

    @Override
    public Job findOneJob(String id) {
        return jobDao.getJobById(id);
    }

    @Override
    public void deleteJob(String id) {

        jobDao.deleteJob(jobDao.getJobById(id));
    }

    @Override
    public void addOneJob(Job job) {
        jobDao.insertJob(job);
    }
}
