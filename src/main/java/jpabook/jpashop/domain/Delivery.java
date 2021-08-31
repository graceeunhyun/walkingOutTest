package jpabook.jpashop.domain;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Delivery {

    @Id @GeneratedValue @Column(name="delivery_id")
    Long deliverId;

    @Embedded
    private Address address;

    @Enumerated
    private DeliveryStatus status;

}
