package com.dream.house.mapper;

import com.dream.house.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    public List<User> selectUsers();

    public int insert(User account);

    public int delete(String email);

    public int update(User updateUser);

    public List<User> selectUsersByQuery(User user);
}
