package com.nhnent.edu.dispatcher.controller;

import com.nhnent.edu.dispatcher.model.Member;
import com.nhnent.edu.dispatcher.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// TODO: 1. "/member/list.json" RestController 만들어서 실행
// TODO: 1. "/member/list.json" RestController作っ実行
// @RestController = @Controller + @ResponseBody
@RestController
public class MemberListRestController {
    @Autowired
    MemberRepository memberRepository;


    @RequestMapping(value = "/member/list.json", method = RequestMethod.GET)
    public List<Member> getMemberList() {
        return memberRepository.list();
    }

}
