package com.example.controller;

import com.example.domain.Member;
import com.example.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("memberList", memberRepository.findAll());
        return "member";
    }

    @RequestMapping("/execute")
    public String execute(){

        // 1) INSERT してみる
        Member member = new Member();
        member.setName("kaneko");
        member.setAge(12);
        member.setDepartmentId(8);
        memberRepository.save(member);

        // 2) PK で検索してみる
        Member member1 = memberRepository.findById(3);
        System.out.println(member1);

        // 3) 全件表示してみる
        memberRepository.findAll().forEach(System.out::println);

        return "finished";
    }

}
