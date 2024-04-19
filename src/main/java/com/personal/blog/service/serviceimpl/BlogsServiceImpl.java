package com.personal.blog.service.serviceimpl;

import com.personal.blog.config.exception.CustomException;
import com.personal.blog.config.security.JwtProvider;
import com.personal.blog.dto.BlogsDto;
import com.personal.blog.entity.Blogs;
import com.personal.blog.repository.BlogsRepository;
import com.personal.blog.service.BlogsService;
import com.personal.blog.vo.BlogsVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class BlogsServiceImpl implements BlogsService {

    private final BlogsRepository blogsRepository;

    Map<Object, String> map = new HashMap<>();
    private BlogsDto toDto(Blogs original) {
        var bean = new BlogsDto();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    @Override
    public Map<Object, String> create(BlogsVo vo) {
        try {
            Blogs blog = new Blogs();
            blog.setTitle(vo.getTitle());
            blog.setBody(vo.getBody());
            blog.setAuthor(JwtProvider.getUsername());

            blogsRepository.save(blog);

            map.put("message", "Success Add Data");

            return map;
        } catch (Exception e) {
            throw new CustomException("ERR-SV-DATA", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Page<BlogsDto> page(Pageable pageable) {
        return blogsRepository.findAll(pageable).map(this::toDto);
    }

    @Override
    public BlogsDto getById(Long id) {
        return toDto(blogsRepository.findById(id)
                .orElseThrow(() -> new CustomException("Data not found" , HttpStatus.NOT_FOUND)));
    }

    @Override
    public Map<Object, String> update(Long id, BlogsVo vo) {
        try {
            var blog = blogsRepository.findById(id)
                    .orElseThrow(() -> new CustomException("Data not found" , HttpStatus.NOT_FOUND));

            blog.setTitle(vo.getTitle());
            blog.setBody(vo.getBody());
            blog.setAuthor(JwtProvider.getUsername());

            blogsRepository.save(blog);

            map.put("message", "Success Update Data");

            return map;
        } catch (Exception e) {
            throw new CustomException("ERR-UPD-DATA", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Map<Object, String> delete(Long id) {
        try {
            var blog = blogsRepository.findById(id)
                    .orElseThrow(() -> new CustomException("Data not found" , HttpStatus.NOT_FOUND));

            blogsRepository.delete(blog);

            map.put("message", "Success Delete Data");

            return map;
        } catch (Exception e) {
            throw new CustomException("ERR-DEL-DATA", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
