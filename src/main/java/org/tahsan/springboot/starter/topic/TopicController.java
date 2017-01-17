package org.tahsan.springboot.starter.topic;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	TopicService topicService;
	final Logger logger = LoggerFactory.getLogger(TopicController.class);

	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		logger.debug("I am in getAllTopics");
		return topicService.getAllTopics();
	}
	
	/*@RequestMapping("/topics/{foo}")
	public Topic getTopics(@PathVariable("foo") String id) {
		
		return topicService.getTopic(id);
	}*/
	
	@RequestMapping("/topics/{id}")
	public Topic getTopics(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value ="/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value ="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		logger.debug("I am in updateTopic");
		topicService.updateTopic(id, topic);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value ="/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}

}
