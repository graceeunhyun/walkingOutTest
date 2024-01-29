package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    // return type, input type 만 맞춰주면 naming tool
    List<Member> findByUserName(String name);

   @Query
   ("select m from Member m where m.userName = :name")
    List<Member> findUser(@org.springframework.data.repository.query.Param("name") String name);

}
