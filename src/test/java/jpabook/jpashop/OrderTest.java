package jpabook.jpashop;

import jpabook.jpashop.domain.*;
import jpabook.jpashop.repository.ItemRepository;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.repository.OrderRepository;
import jpabook.jpashop.service.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderTest {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    ItemRepository itemRepository;

    @Test
    public void orderProduct() throws Exception {
        // given
        Member member = createMember();
        Item item = createBook("시골JPA", 10000, 10);
        int orderCount =2;

        // when
        Long orderId = orderService.order(member.getId(), item.getId(), orderCount);
        System.out.println("orderId = " + orderId);
        // then
        Order getOrder = orderRepository.findById(orderId).get();
        System.out.println("getOrder = " + getOrder);
        Assertions.assertEquals(OrderStatus.ORDER, getOrder.getStatus());
        Assertions.assertEquals(8, item.getStockQuantity());

    }

    private Member createMember() {
        Member member = new Member();
        member.setUserName("회원1");
        member.setAddress(new Address("서울", "강가", "123-123"));
        memberRepository.save(member);
        return member;
    }
    private Book createBook(String name, int price, int stockQuantity) {
        Book book = new Book();
        book.setName(name);
        book.setStockQuantity(stockQuantity);
        book.setPrice(price);
        itemRepository.save(book);
        return book;
    }
}
