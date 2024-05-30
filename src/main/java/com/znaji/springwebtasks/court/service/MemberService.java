package com.znaji.springwebtasks.court.service;

import com.znaji.springwebtasks.court.demain.Member;
import org.springframework.stereotype.Service;

public interface MemberService {
    Iterable<Member> findAll();
}
