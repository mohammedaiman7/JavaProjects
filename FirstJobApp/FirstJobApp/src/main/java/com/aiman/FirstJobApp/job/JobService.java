package com.aiman.FirstJobApp.job;

import com.aiman.FirstJobApp.company.Company;

import java.util.List;
import java.util.Optional;

public interface JobService {
    List<Job> findAll();
    void createAJob(Job job);

    Job getJobByid(Long id);

    boolean deleteById(Long id);

    boolean updateJobByid(Long id, Job job);
}
