package com.jdbc.research;

import javax.persistence.*;

@Entity
public class Children {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int age;
    private int detsadnumber;

    @OneToOne
    private Person person;

    public Children(){}
    public Children(String name, int age, int detsadnumber){
        this.name = name;
        this.age = age;
        this.detsadnumber = detsadnumber;
        this.person = person;
    }

    public String getName(){
        return name;
    }

    public void setName(){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDetsadnumber() {
        return detsadnumber;
    }

    public void setDetsadnumber(int detsadnumber) {
        this.detsadnumber = detsadnumber;
    }
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
