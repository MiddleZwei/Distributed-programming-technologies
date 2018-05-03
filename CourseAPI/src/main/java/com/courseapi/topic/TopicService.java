package com.courseapi.topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics(){
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll()
        .forEach(topics::add); // method reference in lambda; populates the topics list
        return topics;
    }

    public Optional<Topic> getTopic(String id){
        return topicRepository.findById(id);
    }


    public void addTopic(Topic topic){
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic) {
        topicRepository.save(topic); // save() can do both. if doesn't exist it'll create one
    }

    public void deleteTopic(String id) {
        topicRepository.deleteById(id);
    }
}
