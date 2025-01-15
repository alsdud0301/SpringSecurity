package com.icia.securitytest.service;

import com.icia.securitytest.dao.MemberDao;
import com.icia.securitytest.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberDao mDao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void join(MemberDto member) {
        //시큐리티는 비번을 암호화해야한다
        passwordEncoder.encode(member.getPassword());
        mDao.join(member);
    }
}
