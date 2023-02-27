package com.example.candi.service;

import com.example.candi.domain.Job;
import com.example.candi.domain.dto.JobDTO;
import com.example.candi.repository.JobRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class JobService {
    final JobRepository jobRepository;

    public void createJob(JobDTO jobDTO) {
        log.info("Creating job: {}", jobDTO);
        jobRepository.save(Job.builder()
                        .title(jobDTO.title())
                        .company(jobDTO.company())
                        .description(jobDTO.description())
                        .salary(jobDTO.salary())
                .build());
    }

    public List<Job> getAllJobs() {
        log.info("Getting all jobs");
        return jobRepository.findAll();
    }
}
