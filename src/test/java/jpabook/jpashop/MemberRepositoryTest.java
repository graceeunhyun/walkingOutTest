package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberService memberService;

    @Test
    public void testClass() {
        Member member = new Member();
        member.setUserName("memberA");
        memberRepository.save(member);

    }

    @Test
    public void join() throws Exception {
        //Given
        Member member = new Member();
        member.setUserName("kim");

        Member member2 = new Member();
        member2.setUserName("kim");

        //when
        memberService.join(member);
        memberService.join(member2); // 예외발생

        //then


    }

}
