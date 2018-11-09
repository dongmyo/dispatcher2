package com.nhnent.edu.dispatcher.controller;

import com.nhnent.edu.dispatcher.model.Member;
import com.nhnent.edu.dispatcher.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

// TODO: 1. @Controller로 변경
// TODO: 1. @Controllerに変更
@Controller
public class MemberListController {
    @Autowired
    MemberRepository memberRepository;


    @RequestMapping(value = "/member/list", method = RequestMethod.GET)
    public String handleRequest(Model model) throws Exception {
        List<Member> members = memberRepository.list();

        model.addAttribute("members", members);

        return "memberList";
    }

}
