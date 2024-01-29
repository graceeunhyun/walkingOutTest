package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    // 생성자 주입의 방식
//    private final MemberRepository memberRepository;
//    public MemberService(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    @Autowired
    private MemberRepository memberRepository;


    /** 회원가입 **/
    public Long join(Member member) {
        validateDuplicateMember(member);//중복회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByUserName(member.getUserName());

        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }


    /**전체 회원 조회 **/
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /** 회원 조회 **/
    public List<Member> findMember(String name){
        return memberRepository.findByUserName(name);
    }

    public List<Member> findUser(String name){
        return memberRepository.findUser(name);
    }

    public Optional<Member> findOne(Long memberID) {
        return memberRepository.findById(memberID);
    }

    /** 회원 수정 **/
    /** 변경감지로 인하여 수정이 이해 */
    @Transactional
    public void update(Long id, String name) {
        Member member = memberRepository.findById(id).get();
        member.setUserName(name);
    }

}
