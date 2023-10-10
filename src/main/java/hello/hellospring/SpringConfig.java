package hello.hellospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;

@Configuration
public class SpringConfig {
	private final MemberRepository memberRepository;
	
	@Autowired /// 생성자가 하나인경우 Autowired 어노테이션 생략 가능 
	public SpringConfig(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
//	private EntityManager em;
//	
//	public SpringConfig(EntityManager em) {
//		this.em = em;
//	}

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository);
	}
	
//	@Bean
//	public MemberService memberService() {
//		return new MemberService(memberRepository());
//	}
//
//	@Bean
//      public MemberRepository memberRepository() {
////        return new MemoryMemberRepository();
//        return new JpaMemberRepository(em);
//      }
}