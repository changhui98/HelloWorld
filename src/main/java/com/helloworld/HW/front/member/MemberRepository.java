package com.helloworld.HW.front.member;

import com.helloworld.HW.front.member.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long>,
        QuerydslPredicateExecutor<Member> {
    //NPE 방지를 위한 Optional
    Optional<Member> findByEmail(String email);
}
