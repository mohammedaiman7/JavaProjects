package com.aiman.FirstJobApp.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/jobs")
public class JobController {
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    private JobService jobService;
    @GetMapping()
    public ResponseEntity<List<Job>>  findALL(){
        return new ResponseEntity<>(jobService.findAll(),HttpStatus.OK);
    }
    @PostMapping ("")
    public ResponseEntity<String>  createJob(@RequestBody Job job){
        jobService.createAJob(job);
        return new ResponseEntity<>( "Job Added Successfully",HttpStatus.OK);
    }
    @GetMapping ("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job=jobService.getJobByid(id);
        if (job!=null){
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        boolean deleted =jobService.deleteById(id);
        if (deleted){
            return new ResponseEntity<>("Job deleted",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Job not Found",HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping ("/{id}")
    public ResponseEntity<String> updateById(@PathVariable Long id ,@RequestBody Job job){
        job.setId(id);
        boolean k=jobService.updateJobByid(id,job);
        if (k){
            return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Job not found",HttpStatus.NOT_FOUND);
    }
}
