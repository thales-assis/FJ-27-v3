package br.com.alura.forum.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.alura.forum.model.OpenTopicByCategory;
import br.com.alura.forum.model.topic.domain.Topic;
import br.com.alura.forum.repository.setup.TopicRepositoryTestSetup;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class TopicRepositoryTest {
	
	@Autowired
	private TopicRepository topicRepository;
	
	@Autowired
	private TestEntityManager testEntityManager;
	
	@Test
	public void shouldSaveATopic() {
		
		Topic topic = new Topic("Descrição do tópico", "Conteúdo do tópico", null, null);
		
		Topic persistedTopic = this.topicRepository.save(topic);
		
		Topic topicFound = this.testEntityManager.find(Topic.class, persistedTopic.getId());
		
		assertThat(topicFound).isNotNull();
		
		assertThat(topicFound.getShortDescription()).isEqualTo(persistedTopic.getShortDescription());
		assertThat(topicFound.getContent()).isEqualTo(persistedTopic.getContent());
		assertThat(topicFound.getOwner()).isNull();
		assertThat(topicFound.getCourse()).isNull();
	}
	
	@Test
	public void shouldReturnOpenTopicsByCategory() {
		
		TopicRepositoryTestSetup setup = new TopicRepositoryTestSetup(this.testEntityManager);
		
		setup.openTopicsByCategorySetup();
		
		List<OpenTopicByCategory> openTopics = this.topicRepository.findOpenTopicsByCategory();
		
		assertThat(openTopics).isNotEmpty();
		assertThat(openTopics).hasSize(2);
		
		assertThat(openTopics.get(0).getCategoryName()).isEqualTo("Programação");
		assertThat(openTopics.get(0).getTopicCount()).isEqualTo(2);
		
		assertThat(openTopics.get(1).getCategoryName()).isEqualTo("Front-end");
		assertThat(openTopics.get(1).getTopicCount()).isEqualTo(1);
	}
	
}
