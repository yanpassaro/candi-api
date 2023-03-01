package com.example.candi.repository;

import com.example.candi.domain.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JobRepository extends JpaRepository<Job, Long> {
    boolean existsByAccountToken(String token);

    Page<Job> findAllByTitleContaining(String title, Pageable pageable);

    Page<Job> findAllByAccountToken(String token, Pageable pageable);

}