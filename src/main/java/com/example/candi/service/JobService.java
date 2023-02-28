package com.example.candi.service;

import com.example.candi.domain.Job;
import com.example.candi.domain.dto.JobDTO;
import com.example.candi.repository.JobRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class JobService {
    final JobRepository jobRepository;

    @Transactional
    public void save(JobDTO jobDTO) {
        log.info("Save job: {}", jobDTO);
        jobRepository.save(Job.builder()
                .id(jobDTO.id())
                .title(jobDTO.title())
                .company(jobDTO.company())
                .description(jobDTO.description())
                .salary(jobDTO.salary())
                .build());
    }

    public List<Job> getAll(Integer page) {
        log.info("Getting all jobs");
        Pageable pageable = PageRequest.of(page, 20);
        return jobRepository.findAll(pageable).getContent();
    }

    public Job get(Long id) {
        log.info("Getting job with id: {}", id);
        return jobRepository.findById(id).orElseThrow();
    }

    @Transactional
    public void delete(Long id) {
        log.info("Deleting job with id: {}", id);
        jobRepository.deleteById(id);
    }
}
