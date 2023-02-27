package com.example.candi.controller;

import com.example.candi.domain.Job;
import com.example.candi.domain.dto.JobDTO;
import com.example.candi.service.JobService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job")
@AllArgsConstructor
public class JobController {
    final JobService jobService;

    @PostMapping("/create")
    public void createJob(@RequestBody JobDTO jobDTO) {
        jobService.createJob(jobDTO);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Job>> getJob() {
        return ResponseEntity.ok(jobService.getAllJobs());
    }
}
