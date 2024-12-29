package hello.core.member;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    @DisplayName("회원가입을 할 수 있다")
    void join() {
        // GIVEN
        Member member = new Member(1L, "memberA", Grade.VIP);

        // WHEN
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // THEN
        assertThat(member).isEqualTo(findMember);
    }
}