package com.nhnent.edu.dispatcher.controller;

import com.nhnent.edu.dispatcher.model.Member;
import com.nhnent.edu.dispatcher.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// @RestController = @Controller + @ResponseBody
@RestController
public class MemberListRestController {
    @Autowired
    MemberRepository memberRepository;


    // TODO: 2. produces로 json 응답 지정
    // TODO: 2. producesでjson応答指定
    @RequestMapping(value = "/member/list", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public List<Member> getMemberList() {
        return memberRepository.list();
    }

}
