package com.example.candi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
public class Candidate {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
}
