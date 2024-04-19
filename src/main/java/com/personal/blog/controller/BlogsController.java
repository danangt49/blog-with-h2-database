package com.personal.blog.controller;

import com.personal.blog.config.GlobalApiResponse;
import com.personal.blog.service.BlogsService;
import com.personal.blog.vo.BlogsVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/blogs", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Blogs")
public class BlogsController {
    private final BlogsService blogsService;

    @Operation(summary = "Create new blog")
    @PostMapping
    public GlobalApiResponse<?> create(@RequestBody @Valid BlogsVo vo) {
        return new GlobalApiResponse<>(blogsService.create(vo), HttpStatus.CREATED);
    }

    @Operation(summary = "Get blog with pagination")
    @GetMapping
    public GlobalApiResponse<?> page(Pageable pageable) {
        return new GlobalApiResponse<>(blogsService.page(pageable), HttpStatus.OK);
    }

    @Operation(summary = "Get blog by id")
    @GetMapping("{id}")
    public GlobalApiResponse<?> getById(@PathVariable Long id) {
        return new GlobalApiResponse<>(blogsService.getById(id), HttpStatus.OK);
    }

    @Operation(summary = "Update blog by id")
    @PutMapping("{id}")
    public GlobalApiResponse<?> update(@PathVariable Long id, @RequestBody @Valid BlogsVo vo) {
        return new GlobalApiResponse<>(blogsService.update(id, vo), HttpStatus.OK);
    }

    @Operation(summary = "Delete blog by id")
    @DeleteMapping("{id}")
    public GlobalApiResponse<?> delete(@PathVariable Long id) {
        return new GlobalApiResponse<>(blogsService.delete(id), HttpStatus.OK);
    }
}
