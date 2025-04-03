package com.example.cms.repositories;

import com.example.cms.models.Headline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HeadlineRepository extends JpaRepository<Headline, Long> {
    Optional<Headline> findTopByOrderByIdDesc();
}
