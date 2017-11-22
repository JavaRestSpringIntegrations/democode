package com.example.test.democode.topic;
//javabrains
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//Creates a new instance and attach it
@RestController
public class TopicController {
	
	/*
	 * In topic controller if you want instance of Service , you declare as private variable and tell Spring to inject it and declare the
	 * dependency using Autowire annotation
	 */

	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topicsstart")
	public String getTopics() {
		return "All Topics";
	}
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/topics")
	//tells spring that your request will have a json payload and convert it into Topic instances POJO when this URL is mapped
	public boolean addTopic(@RequestBody Topic topic) {
		return topicService.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}",consumes=MediaType.APPLICATION_JSON_VALUE)
	//tells spring that your request will have a json payload and convert it into Topic instances POJO when this URL is mapped
	public void addTopic(@RequestBody Topic topic,@PathVariable String id) {
		topicService.updateTopic(id,topic);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}
	
	@RequestMapping("/topicspk/{id}")
	public List<Topic> getAllWithOneId(@PathVariable String id) {
		return topicService.getAllWithOneId(id);
	}

}
