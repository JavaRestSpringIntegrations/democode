package com.example.test.democode.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("1", "Terraform", "Cookbook on Terraform"),
			new Topic("2", "Spring MVC", "Cookbook on Spring MVC"),
			new Topic("3", "CHEF", "CHEF cookbook"),
			new Topic("4", "Kotlin", "Overview of Kotlin"),
			new Topic("4","Kotlin-2","Kotlin Latest")));
	
	
	public List<Topic> getAllWithOneId(String id) {
		List<Topic> tlist = new ArrayList<>();
		for(int i=0;i<topics.size();i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				tlist.add(t);
			}
		}
		return tlist;
	}
	
	public List<Topic> getAllTopics() {
		return topics;
	}
	
	public Topic getTopic(String id) {
	//	return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
		for (Topic topic : topics) {
			if(topic.getId().equals(id)) {
				return topic;
			}
		}
		return null;
	}
	
	public boolean addTopic(Topic topic) {
		int set = 1;
		System.out.println("->" +topic.toString());
		for(int i=0;i<topics.size();i++) {
			//Topic t = topics.get(i);
			//if(t.getId().equals(topic.getId()))
			//System.out.println(t.toString());
			//if(topics.get(i).toString().equals(topic.toString()))	
			if(topics.get(i).equals(topic))
			{
				System.out.println("Already Existing");
				//System.out.println(t.toString());
				set =0;
				return false;
			}
			
		}
		
	
		if(set!=0) {
			
			topics.add(topic);
		}
		return true;
		
	}

	public void updateTopic(String id, Topic topic) {
		// TODO Auto-generated method stub
		for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
		
	}

	public void deleteTopic(String id) {
		topics.removeIf(t->t.getId().equals(id));
		
	}

}
