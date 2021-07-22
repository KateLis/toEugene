package com.jdbc.research;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {
    private String name;
    private int cost;
    @ManyToOne
    private Person person;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public Car() {
    }

    public Car(String name, int cost, Person person) {
        this.name = name;
        this.cost = cost;
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", person=" + person.getId() +
                ", id of the car =" + id +
                '}';
    }
}
