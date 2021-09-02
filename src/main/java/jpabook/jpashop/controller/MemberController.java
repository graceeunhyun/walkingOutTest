package jpabook.jpashop.controller;


import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
//public class MemberController {
//    private final MemberRepository repository;
//    MemberController(MemberRepository repository) {
//        this.repository = repository;
//    }
//
//    @GetMapping("/members")
//    List<Member> all() {
//        return repository.findAll();
//    }
//
//    @PostMapping("/members")
//    Member newMember(@RequestBody Member newMember) {
//        return repository.save(newMember);
//    }
//
//}
