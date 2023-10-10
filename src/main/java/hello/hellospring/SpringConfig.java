package hello.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.hellospring.domain.Campaign;
import hello.hellospring.repository.BaseRepository;
import hello.hellospring.repository.JpaCampaignRepository;
import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import jakarta.persistence.EntityManager;

@Configuration
public class SpringConfig {
	private EntityManager em;
	
	public SpringConfig(EntityManager em) {
		this.em = em;
	}

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}

	@Bean
      public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
        return new JpaMemberRepository(em);
      }
	
	@Bean
	public BaseRepository<Campaign> campaignRepository() {
		return new JpaCampaignRepository(em);
	}
	
}