package com.dream.house.mapper;

import com.dream.house.model.Comment;
import com.dream.house.model.Community;
import com.dream.house.model.House;
import com.dream.house.model.UserMsg;
import com.dream.house.page.PageParams;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {

    List<House> selectHouse(@Param("house") House query, @Param("pageParams") PageParams pageParams);

    Long selectHouseCount(@Param("house")House query);

    List<Community> selectCommunity(Community community);

    int insertUserMsg(UserMsg userMsg);

    int updateHouse(House house);

    int insert(Comment comment);

    List<Comment> selectComments(@Param("houseId")long houseId, @Param("size")int size);

    List<Comment> selectBlogComments(@Param("blogId")long blogId, @Param("size")int size);
}
