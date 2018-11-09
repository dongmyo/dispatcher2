package com.nhnent.edu.dispatcher.controller;

import com.nhnent.edu.dispatcher.model.Member;
import com.nhnent.edu.dispatcher.model.MemberType;
import com.nhnent.edu.dispatcher.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// @RestController = @Controller + @ResponseBody
@RestController
public class MemberListRestController {
    @Autowired
    MemberRepository memberRepository;


    @RequestMapping(
            value = "/member/list", method = RequestMethod.GET,
            produces = "application/json; charset=UTF-8"
    )
    public List<Member> getMemberList() {
        return memberRepository.list();
    }

    // TODO: 5. type별 멤버 목록 가져오는 controller 메서드 작성
    // TODO: 5. type別のメンバーのリストを取得controllerメソッドの作成
    @RequestMapping(
            value = "/member/list", method = RequestMethod.GET,
            produces = "application/json; charset=UTF-8",
            params = { "type" }
    )
    public List<Member> getMember(@RequestParam MemberType type) {
        return memberRepository.list(type);
    }

}
