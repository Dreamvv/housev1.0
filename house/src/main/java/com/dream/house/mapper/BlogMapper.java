package com.dream.house.mapper;

import com.dream.house.model.Blog;
import com.dream.house.page.PageParams;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BlogMapper {

    public List<Blog> selectBlog(@Param("blog") Blog query, @Param("pageParams") PageParams params);

    public Long selectBlogCount(Blog query);

}
