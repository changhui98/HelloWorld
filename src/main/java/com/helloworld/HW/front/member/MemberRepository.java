package com.helloworld.HW.front.member;

import com.helloworld.HW.front.member.entities.Member;
import com.helloworld.HW.front.member.entities.QMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long>,
        QuerydslPredicateExecutor<Member> {
    //NPE 방지를 위한 Optional
    Optional<Member> findByEmail(String email);

    /**
     * 이메일로 회원 존재여부 체크
     * @param email
     * @return
     */
    default boolean existsByEmail(String email) {
        QMember member = QMember.member;
        return exists(member.email.eq(email));
    }

    /**
     * 닉네임 존재여부 체크
     * @param nickname
     * @return
     */
    default boolean existsByNickname(String nickname) {
        QMember member = QMember.member;
        return exists(member.nickname.eq(nickname));
    }

}
