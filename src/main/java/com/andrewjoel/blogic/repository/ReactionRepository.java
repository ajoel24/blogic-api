package com.andrewjoel.blogic.repository;

import com.andrewjoel.blogic.models.jpa.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactionRepository extends JpaRepository<Reaction, Long> {
}