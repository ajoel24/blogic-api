package com.andrewjoel.blogic.repository;

import com.andrewjoel.blogic.models.jpa.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
