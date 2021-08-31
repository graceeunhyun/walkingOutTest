package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="categroy_id")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name="item_tbl")
    private List<Item> itemList = new ArrayList<>();

    // 약간 상위 개념을 담으려고 이런식으로 테이블 구조를 한거 같다.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="parent_id")
    private Category parent;

}
