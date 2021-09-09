package jpabook.jpashop.service;

import jpabook.jpashop.domain.*;
import jpabook.jpashop.repository.ItemRepository;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;

    // 주문 서비스
    public Long order(Long memberId, Long itemId, int count) {
        Optional<Member> member = memberRepository.findById(memberId);
        Optional<Item> item = itemRepository.findById(itemId);

        // 배송정보 생성
        Delivery delivery = new Delivery();
        delivery.setAddress(member.get().getAddress());
        delivery.setStatus(DeliveryStatus.READY);

        // 주문 정보 생성
        Order order = Order.builder().memberID(member.get()).delivery(delivery).status(OrderStatus.ORDER).build();

        // 재고 제거
        item.get().removeStock(count);
        itemRepository.save(item.get());
        System.out.println("재고확인 = " + item.get().getStockQuantity());

        OrderItem orderItem = OrderItem.builder().item(item.get()).orderPrice(item.get().getPrice()).count(count).order(order).build();


        orderRepository.save(order);
        return order.getOrderId();

    }
    // 주문 취소 서비스
    public void cancel(Long orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        if(order.isPresent())
            order.get().cancel();

    }
    // 주문 검색 서비스

}
