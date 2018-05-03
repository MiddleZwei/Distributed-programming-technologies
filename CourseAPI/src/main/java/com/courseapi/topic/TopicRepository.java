package com.courseapi.topic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> {

    //getAllTopics
    //getTopic(String id)
    //updateTopic(Course t)
    //deleteTopic(String id)



}
