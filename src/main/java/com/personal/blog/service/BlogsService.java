package com.personal.blog.service;

import com.personal.blog.dto.BlogsDto;
import com.personal.blog.vo.BlogsVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface BlogsService {
    Map<Object, String> create(BlogsVo vo);
    Page<BlogsDto> page(Pageable pageable);
    BlogsDto getById(Long id);
    Map<Object, String> update(Long id, BlogsVo vo);
    Map<Object, String> delete(Long id);
}
