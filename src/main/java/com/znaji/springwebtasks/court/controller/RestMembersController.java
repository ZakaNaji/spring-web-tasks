package com.znaji.springwebtasks.court.controller;

import com.znaji.springwebtasks.court.demain.Member;
import com.znaji.springwebtasks.court.demain.Members;
import com.znaji.springwebtasks.court.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class RestMembersController {

    private final MemberService memberService;

    @GetMapping
    @ResponseBody
    public Members getRestMembers(Model model) {
        var members = new Members();
        members.addMembers(memberService.findAll());
        return members;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMember(@PathVariable("id") int id, Model model) {
        return memberService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
