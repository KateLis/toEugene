package com.jdbc.research;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;

    public Person(){ //обязательно для того, чтобы класс был entity
    }
    public Person(String name,Integer age, Passport passport, Set<Car> cars, Set<Purchase> purchases, Children children){
        this.name = name;
        this.age = age;
        this.passport = passport;
        this.cars = cars;
        this.purchases = purchases;
        this.children = children;
    }

    @OneToOne(cascade = CascadeType.ALL)
    private Passport passport;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person", fetch = FetchType.EAGER)
    private Set<Car> cars;

    @OneToOne(cascade = CascadeType.ALL)
    private Children children;

    public Children getChildren() {
        return children;
    }

    public void setChildren(Children children) {
        this.children = children;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person", fetch = FetchType.EAGER)
    private Set<Purchase> purchases;
//////////////////////////////////////////////////
    //getters and setters for Person fields
    public long getId(){
        return id;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "name: " + name + " age: " + age + " cars: " + cars;
    }
}
