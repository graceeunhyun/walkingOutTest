package jpabook.jpashop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jpabook.jpashop.domain.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
}
