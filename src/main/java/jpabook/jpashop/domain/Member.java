package jpabook.jpashop.domain;

import jpabook.jpashop.domain.Address;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="member_tbl")
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
@ToString
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;

    @Embedded
    private Address address;

}
