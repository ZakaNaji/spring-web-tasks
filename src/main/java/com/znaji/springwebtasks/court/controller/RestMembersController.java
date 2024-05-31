package com.znaji.springwebtasks.court.controller;

import com.znaji.springwebtasks.court.demain.Member;
import com.znaji.springwebtasks.court.demain.Members;
import com.znaji.springwebtasks.court.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.of(memberService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Member> addMember(@RequestBody Member member) {
        return ResponseEntity.ok(memberService.save(member));
    }
}
