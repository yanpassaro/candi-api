package com.example.candi.service;

import com.example.candi.domain.Job;
import com.example.candi.domain.dto.JobDTO;
import com.example.candi.exception.InvalidTokenException;
import com.example.candi.exception.JobNotExistException;
import com.example.candi.repository.AccountRepository;
import com.example.candi.repository.JobRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class JobService {
    final JobRepository jobRepository;
    final AccountRepository accountRepository;

    @Transactional
    public void save(JobDTO jobDTO, String token) throws InvalidTokenException {
        if (!accountRepository.existsByToken(token))
            throw new InvalidTokenException("Invalid token");
        log.info("Save job: {}", jobDTO);
        jobRepository.save(Job.builder()
                .id(jobDTO.id())
                .title(jobDTO.title())
                .company(jobDTO.company())
                .description(jobDTO.description())
                .salary(jobDTO.salary())
                .account(accountRepository.findByToken(token))
                .build());
    }

    public List<Job> search(String title, Integer page) {
        log.info("Searching for jobs with title: {}", title);
        return jobRepository.findAllByTitleContaining(title, PageRequest.of(page, 20))
                .getContent();
    }

    public Job get(Long id) {
        log.info("Getting job with id: {}", id);
        return jobRepository.findById(id).orElseThrow();
    }

    public List<Job> getAll(Integer page) {
        log.info("Getting all jobs");
        return jobRepository.findAll(PageRequest.of(page, 20)).getContent();
    }

    public List<Job> getMyJobs(String token, Integer page) {
        log.info("Getting all jobs");
        return jobRepository.findAllByAccountToken(token, PageRequest.of(page, 20))
                .getContent();
    }

    @Transactional
    public void delete(Long id, String token) throws InvalidTokenException, JobNotExistException {
        if (!accountRepository.existsByToken(token))
            throw new InvalidTokenException("Invalid token");
        if (!jobRepository.existsById(id))
            throw new JobNotExistException("Job not found");
        if (!jobRepository.existsByAccountToken(token))
            throw new JobNotExistException("You don't have permission to delete this job");
        log.info("Deleting job with id: {}", id);
        jobRepository.deleteById(id);
    }
}
