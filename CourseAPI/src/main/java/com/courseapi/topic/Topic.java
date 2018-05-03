package com.courseapi.topic;

import javax.persistence.*;

/**
 * Simple JavaBean object that represents topics.
 *
 * @author Illia Halych
 * @version 1.0
 */

@Entity
@Table(name = "topics")
public class Topic {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

//    @Column(name = "name")
    private String name;

//    @Column(name = "description")
    private String description;


    public Topic() {
    }

    public Topic(String id, String name, String description) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
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
}
