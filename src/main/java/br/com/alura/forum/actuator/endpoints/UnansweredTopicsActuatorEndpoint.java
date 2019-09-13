package br.com.alura.forum.actuator.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.stereotype.Component;

import br.com.alura.forum.model.OpenTopicByCategory;
import br.com.alura.forum.repository.TopicRepository;

@Endpoint(id="open-topics-by-category")
@Component
public class UnansweredTopicsActuatorEndpoint {
	
	@Autowired
	private TopicRepository topicRepository;
	
	public List<OpenTopicByCategory> execute() {
		return topicRepository.findOpenTopicsByCategory();
	}

}
