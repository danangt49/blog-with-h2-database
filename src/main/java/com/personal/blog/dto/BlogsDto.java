package com.personal.blog.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.personal.blog.entity.Blogs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * DTO for {@link Blogs}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BlogsDto implements Serializable {
    private long id;
    private String title;
    private String body;
    private String author;
}