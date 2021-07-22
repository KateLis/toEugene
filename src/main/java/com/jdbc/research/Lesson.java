package com.jdbc.research;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "lesson")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String topic;

    private int duration;
    @ManyToMany
    private Set<Student> student = new HashSet<>();

    public Lesson(){}

    public Lesson(String topic, int duration) {
        this.topic = topic;
        this.duration = duration;
    }


    public Set<Student> getStudentSet() {
        return student;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.student = studentSet;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

}
