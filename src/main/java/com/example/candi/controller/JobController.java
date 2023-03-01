package com.example.candi.controller;

import com.example.candi.domain.Job;
import com.example.candi.domain.dto.JobDTO;
import com.example.candi.exception.InvalidTokenException;
import com.example.candi.exception.JobNotExistException;
import com.example.candi.service.AccountService;
import com.example.candi.service.JobService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/job")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class JobController {
    final JobService jobService;
    final AccountService accountService;

    @GetMapping("/get")
    public ResponseEntity<List<Job>> getAll(@RequestParam(defaultValue = "0") Integer page) {
        return ResponseEntity.ok(jobService.getAll(page));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Job>> search(@RequestParam(defaultValue = "0") Integer page,
                                            @RequestParam String title) {
        return ResponseEntity.ok(jobService.search(title, page));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Job> get(@PathVariable Long id) {
        return ResponseEntity.ok(jobService.get(id));
    }

    @GetMapping("/get/my")
    public ResponseEntity<List<Job>> getMyJobs(@RequestHeader("Authorization") String token,
                                               @RequestParam(defaultValue = "0") Integer page) {
        return ResponseEntity.ok(jobService.getMyJobs(token, page));
    }

    @PostMapping("/save")
    public void save(@RequestBody @Valid JobDTO jobDTO,
                     @RequestHeader("Authorization") String token) throws InvalidTokenException {
        jobService.save(jobDTO, token);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid JobDTO jobDTO,
                       @RequestHeader("Authorization") String token) throws InvalidTokenException {
        jobService.save(jobDTO, token);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id,
                       @RequestHeader("Authorization") String token)
            throws InvalidTokenException, JobNotExistException {
        jobService.delete(id, token);
    }
}
