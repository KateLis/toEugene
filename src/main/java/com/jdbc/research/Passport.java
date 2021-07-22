package com.jdbc.research;

import javax.persistence.*;

@Entity
@Table(name = "passport")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int seria;
    private int number;

    @OneToOne //это название колонки?
    private Person person;

    public Passport(){}
    public Passport(int seria){
        this.seria = seria;
    }
    public Passport(int seria, int number){
        this.seria = seria;
        this.number = number;
      //  this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSeria() {
        return seria;
    }
    public void setSeria(int seria){
        this.seria = seria;
    }
}
