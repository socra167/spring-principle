package hello.core.order;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

class OrderServiceImplTest {

	@Test
	void createOrder() {
		MemberRepository memberRepository = new MemoryMemberRepository();
		memberRepository.save(new Member(1L, "name", Grade.VIP));

		OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
		Order order = orderService.createOrder(1L, "itemA", 10000);

		assertThat(order.getDiscountPrice()).isEqualTo(1000);
	}
}