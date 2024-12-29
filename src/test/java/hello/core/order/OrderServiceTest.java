package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    @DisplayName("주문을 생성할 수 있다")
    void createOrder() {
        // GIVEN
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        // WHEN
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        // THEN
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}