package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {
    // Member Entity
    // 주소를 어떻게 넣을지 고민
    @Id @GeneratedValue
    @Column (name="member_id")
    Long id;

    String name;

    @Embedded
    private Address address;

//    @OneToMany(mappedBy="member")
//    private List<Order> orders = new ArrayList<>();


}
