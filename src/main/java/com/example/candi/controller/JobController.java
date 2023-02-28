package com.example.candi.controller;

import com.example.candi.domain.Job;
import com.example.candi.domain.dto.JobDTO;
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
public class JobController {
    final JobService jobService;

    @PostMapping("/create")
    public void create(@RequestBody @Valid JobDTO jobDTO) {
        jobService.save(jobDTO);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Job>> getAll(@RequestParam(defaultValue = "0") Integer page) {
        return ResponseEntity.ok(jobService.getAll(page));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Job> get(@PathVariable Long id) {
        return ResponseEntity.ok(jobService.get(id));
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid JobDTO jobDTO) {
        jobService.save(jobDTO);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id) {
        jobService.delete(id);
    }
}
