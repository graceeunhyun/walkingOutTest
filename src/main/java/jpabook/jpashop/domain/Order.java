package jpabook.jpashop.domain;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="orders")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @GeneratedValue
    @Id @Column(name="order_id")
    Long orderId;
    String orderNm;
    Date orderDt;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    Member memberID;

    //1:1 관계도 하나만 해도 된다.
    @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate; // 주문시간

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    /** 비즈니스 로직 **/
    public void cancel() {
        if(delivery.getStatus() == DeliveryStatus.COMP) {
            throw new IllegalStateException("이미 배송완료된 상품은 취소가 불가능합니다.");
        }

        this.setStatus(OrderStatus.CANCEL);
    }

}
