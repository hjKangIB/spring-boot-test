package hello.hellospring.repository;

import java.util.List;
import java.util.Optional;

import hello.hellospring.domain.Campaign;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Transactional
public class JpaCampaignRepository implements BaseRepository<Campaign> {

	private final EntityManager em;

	public JpaCampaignRepository(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Campaign save(Campaign entity) {
		// TODO Auto-generated method stub
		em.persist(entity);
		return null;
	}

	@Override
	public Optional<Campaign> findById(Long id) {
		// TODO Auto-generated method stub
		Campaign campaign = em.find(Campaign.class, id);
		return Optional.ofNullable(campaign);
	}

	@Override
	public List<Campaign> findAll() {
		// TODO Auto-generated method stub
		List<Campaign> campaigns = em.createQuery("select c from Campaign c", Campaign.class).getResultList();
		return campaigns;
	}

}
