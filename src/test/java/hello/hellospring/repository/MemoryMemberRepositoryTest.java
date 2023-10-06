package hello.hellospring.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Member;

class MemoryMemberRepositoryTest {

	MemoryMemberRepository repository = new MemoryMemberRepository();

	@AfterEach
	public void afterEach() {
		repository.clearStore();
	}

	@Test
	public void save() {
		Member member = new Member();
		member.setName("spring");

		repository.save(member);

		Member result = repository.findById(member.getId()).get();
		// Assertions.assertEquals(result, member);
		assertThat(result).isEqualTo(member);

	}

	@Test
	public void findByName() {
		Member member1 = new Member();
		String name1 = "spring2";
		member1.setName(name1);

		Member member2 = new Member();
		String name2 = "spring3";
		member2.setName(name2);

		repository.save(member1);
		repository.save(member2);

		Member result = repository.findByName("spring3").get();
		assertThat(result).isEqualTo(member1);
	}

	@Test
	public void findById() {
		Member member = new Member();
		String name = "spring4";
		member.setName(name);
		Long id = repository.save(member).getId();

		Member result = repository.findById(id).get();
		assertThat(result).isEqualTo(member);
	}

}
