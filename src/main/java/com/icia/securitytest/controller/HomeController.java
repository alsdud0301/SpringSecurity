package com.icia.securitytest.controller;

import com.icia.securitytest.dto.MemberDto;
import com.icia.securitytest.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
    @Autowired
    MemberService mSer;
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/member/join")
    public String join(){
        return "member/join";
    }

    @PostMapping("/member/join")
    public String joinPost(MemberDto member, RedirectAttributes rttr){

        mSer.join(member);
        rttr.addFlashAttribute("msg","회원가입 성공");
        return "redirect:/";
    }


}
