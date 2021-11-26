package com.sparta.timeattack.repository;

import com.sparta.timeattack.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
