package com.jdbc.research;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String surname;
    private int groupka;

    public Student(){}
    public Student(String surname, int group, List<Lesson> lessons) {
        this.surname = surname;
        this.groupka = group;
        this.lessons = lessons;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "lesson_student", joinColumns = @JoinColumn(name = "student_id"),
    inverseJoinColumns = @JoinColumn(name = "lesson_id"))
    private List<Lesson> lessons;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getGroupka() {
        return groupka;
    }

    public void setGroupka(int groupka) {
        this.groupka = groupka;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

}
