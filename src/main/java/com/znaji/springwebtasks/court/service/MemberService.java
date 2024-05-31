package com.znaji.springwebtasks.court.service;

import com.znaji.springwebtasks.court.demain.Member;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface MemberService {
    Iterable<Member> findAll();

    Optional<Member> findById(int id);

    Member save(Member member);
}
