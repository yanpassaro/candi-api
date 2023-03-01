package com.example.candi.repository;

import com.example.candi.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    boolean existsByToken(String email);

    Account findByToken(String token);
}
