package org.blogic.core.repository;

import org.blogic.core.models.jpa.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>, PagingAndSortingRepository<Comment, Long> {
}
