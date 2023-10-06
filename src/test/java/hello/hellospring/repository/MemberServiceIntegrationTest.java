package hello.hellospring.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;



import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;


@SpringBootTest
public class MemberServiceIntegrationTest {
	@Autowired
	MemberService memberService;
	@Autowired
	MemberRepository memberRepository;

	@Test
	public void 회원가입() throws Exception {

		// given
		Member member = new Member();
		member.setName("spring1");

		// when
		Long saveId = memberService.join(member);

		// then
		Member findMember = memberService.findOne(saveId);
		assertThat(member.getName()).isEqualTo(findMember.getName());
	}

	@Test
	public void 중복_회원_예외() throws Exception {
		// Given
		Member member1 = new Member();
		member1.setName("spring");
		Member member2 = new Member();
		member2.setName("spring");
		// When
		memberService.join(member1);
		
		IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));// 예외가  발생해야 한다.																			// 회원입니다.");
	}

	@Test
	void 회원리스트조회() throws Exception {
		// given
		Member member1 = new Member();
		Member member2 = new Member();
		member1.setName("spring2");
		member2.setName("spring3");

		memberService.join(member1);
		memberService.join(member2);

		// when
		List<Member> members = memberService.findMembers();

		// then
		assertThat(members.get(0).getName()).isEqualTo(member1.getName());
		assertThat(members.get(1).getName()).isEqualTo(member2.getName());
	}
}
