package jpabook.jpashop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public interface MemberRepository extends JpaRepository<Member, Long> {
}
