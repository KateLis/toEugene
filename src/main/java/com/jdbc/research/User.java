package com.jdbc.research;

public class User {
    String name;
    int age;

    User(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    static User user1 = new User("Klara", 34);

    @Override
    public String toString() {
        return "User is: " +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
