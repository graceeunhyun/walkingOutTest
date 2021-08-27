package jpabook.jpashop.domain;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
public class Order {
    @GeneratedValue
    @Id
    String orderId;
    String orderNm;
    Date orderDt;

    @ManyToOne (fetch = FetchType.LAZY)
    Member memberID;

}
