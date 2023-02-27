package com.example.candi.repository;

import com.example.candi.domain.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
