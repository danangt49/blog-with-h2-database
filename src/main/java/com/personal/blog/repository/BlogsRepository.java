package com.personal.blog.repository;

import com.personal.blog.entity.Blogs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogsRepository extends JpaRepository<Blogs, Long> {
}