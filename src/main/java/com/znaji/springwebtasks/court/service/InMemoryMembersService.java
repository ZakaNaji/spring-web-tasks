package com.znaji.springwebtasks.court.service;

import com.znaji.springwebtasks.court.demain.Member;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InMemoryMembersService implements MemberService{
    private final List<Member> members = new ArrayList<>();

    public InMemoryMembersService() {
        // Add some initial members for testing
        members.add(new Member("John Doe", "john@example.com", "123-456-7890"));
        members.add(new Member("Jane Smith", "jane@example.com", "098-765-4321"));
    }

    public Iterable<Member> findAll() {
        return members;
    }

    @Override
    public Optional<Member> findById(int id) {
        if (id > 0 && id <= members.size()) {
            return Optional.of(members.get(id - 1));
        } else {
            return Optional.empty();
        }
    }
}
