package jpabook.jpashop.domain;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name="ORDER_ITEM_TBL")
public class OrderItem {
    @Id @GeneratedValue
    @Column(name="order_item_id")
    private Long id;
    private Long orderPrice;
    private int count;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id")
    private Order order;

}
