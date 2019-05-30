package com.dream.house.controller;

import com.dream.house.constants.CommonConstants;
import com.dream.house.model.Blog;
import com.dream.house.model.Comment;
import com.dream.house.model.House;
import com.dream.house.page.PageData;
import com.dream.house.page.PageParams;
import com.dream.house.service.BlogService;
import com.dream.house.service.CommentService;
import com.dream.house.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private RecommendService recommendService;

    @RequestMapping(value="blog/list",method={RequestMethod.POST,RequestMethod.GET})
    public String list(Integer pageSize, Integer pageNum, Blog query, ModelMap modelMap){
        PageData<Blog> ps = blogService.queryBlog(query, PageParams.build(pageSize, pageNum));
        List<House> houses =  recommendService.getHotHouse(CommonConstants.RECOM_SIZE);
        modelMap.put("recomHouses", houses);
        modelMap.put("ps", ps);
        return "/blog/listing";
    }

    @RequestMapping(value="blog/detail",method={RequestMethod.POST,RequestMethod.GET})
    public String blogDetail(int id,ModelMap modelMap){
        Blog blog = blogService.queryOneBlog(id);
        List<Comment> comments = commentService.getBlogComments(id,8);
        List<House> houses =  recommendService.getHotHouse(CommonConstants.RECOM_SIZE);
        modelMap.put("recomHouses", houses);
        modelMap.put("blog", blog);
        modelMap.put("commentList", comments);
        return "/blog/detail";
    }
}
