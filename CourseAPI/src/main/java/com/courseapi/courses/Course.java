package com.courseapi.courses;

import com.courseapi.topic.Topic;

import javax.persistence.*;

/**
 * Simple JavaBean object that represents topics.
 *
 * @author Illia Halych
 * @version 1.0
 */

@Entity
@Table(name = "topics")
public class Course {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

//    @Column(name = "name")
    private String name;

//    @Column(name = "description")
    private String description;

    @ManyToOne
    private Topic topic; // tied a course to a particular topic


    public Course() {
    }

    public Course(String id, String name, String description, String topicId) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.topic = new Topic(topicId, "", "");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "com.courseapi.topic.Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + description + '\'' +
                '}';
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
