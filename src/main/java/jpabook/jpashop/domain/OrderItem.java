package jpabook.jpashop.domain;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name="ORDER_ITEM_TBL")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    @Id @GeneratedValue
    @Column(name="order_item_id")
    private Long id;
    private int orderPrice;
    private int count;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id")
    private Order order;


    /** 비즈니스 로직 **/
    /*** 주문 취소 ***/
    public void cancel() {
        // stock 에 하나씩 쌓이는 느낌.
        getItem().addStock(count);
    }

    //==조회 로직==//
    /** 주문상품 전체 가격 조회 */
    public int getTotalPrice() {
        return getOrderPrice() * getCount();
    }
}
