package com.aiman.FirstJobApp.job.impl;

import com.aiman.FirstJobApp.job.Job;
import com.aiman.FirstJobApp.job.JobRepository;
import com.aiman.FirstJobApp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
    //private List<Job> jobs =new ArrayList<>();
    JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    private Long nextId=1L;
    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createAJob(Job job) {
       job.setId(nextId++);
      jobRepository.save(job);

    }
    public Job getJobByid(Long id){
        return jobRepository.findById(id).orElse(null);
    }
    public boolean deleteById(Long id){
        try {
            jobRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public boolean updateJobByid(Long id, Job job){
        Optional<Job>  jobOptional =jobRepository.findById(id);
            if(jobOptional.isPresent()){
                Job job1=jobOptional.get();
                job1.setId(job.getId());
                job1.setTitle(job.getTitle());
                job1.setLocation(job.getLocation());
                job1.setLocation(job.getLocation());
                job1.setMinSalary(job.getMinSalary());
                job1.setMaxSalary(job.getMaxSalary());
                job1.setDescription(job.getDescription());
                jobRepository.save(job1);
                return true;
            }

        return false;
    }
}
