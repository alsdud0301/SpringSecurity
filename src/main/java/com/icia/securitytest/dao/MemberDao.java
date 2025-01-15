package com.icia.securitytest.dao;

import com.icia.securitytest.dto.MemberDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDao {
    @Insert("insert into mem(username,password,role,email) values(#{username},#{password},#{role},#{email})")
    void join(MemberDto member);
}
