package com.example.candi.repository;

import com.example.candi.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Account, Long> {
}
