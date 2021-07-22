package com.jdbc.research;

import org.hibernate.Session;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AsDao {
    public static void main(String[] args){
        //Person p1 = new Person("Marfa", 21);
        //Person p2 = new Person("Ivanushka", 29);
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
////        session.persist(p1); //в чем разница save(HIBERNATE) и persist (JPA)
////        session.save(p2);
////        Person ptodelete = session.get(Person.class, 2L); //id - long, поэтому L
////        session.delete(ptodelete);
//        Person pupdate = session.get(Person.class, 1L);
//        pupdate.setAge(30);
//        session.update(pupdate);
//      //  System.out.println(asDao.read());
//        session.getTransaction().commit(); //почему если закомментитть сроки save, то read ничего не выводит?
//        AsDao asDao = new AsDao();
//        System.out.println(asDao.read());
        Set<Car> hs = new HashSet<>();
        Set<Purchase> purs = new HashSet<>();

        Children child1 = new Children("Ivan", 12, 190); //ВЕЗДЕ нужна эта связка чайлда с персоном?
        Passport pass3 = new Passport(1290, 789076);
        Person p4 = new Person("Helen", 23, pass3, hs, purs, child1);
        child1.setPerson(p4);
        Car c1 = new Car("porsch",1000000, p4);
        Car c2 = new Car("9",1000, p4);
        hs.add(c1);
        hs.add(c2);
        Purchase pur1 = new Purchase("hats", 2499, true, p4);
        purs.add(pur1);
        //      Person p5 = session.get(Person.class,1L);
//      session.save(c1);
//      //  session.save(p4);
////        session.save(c1);
////        session.save(c2);
//      // System.out.println(p5);
//        session.getTransaction().commit();
//        session.close();
//        System.out.println(p5);
//        Children child1 = new Children("Vera", 12, 190);
//        session.save(child1);
//        session.getTransaction().commit();
//        session.close();
       // session.save(pass3);
        //Set<Student> studentSet = new HashSet<>();
        List<Lesson> ls = new ArrayList<>();
        Lesson ls1 = new Lesson("English", 1234);
        Lesson ls2 = new Lesson("Math", 127734);
        ls.add(ls1);
        ls.add(ls2);
        session.save(ls1);
        session.save(ls2);
        Student st1 = new Student("Petrov", 12, ls);
      //  studentSet.add(st1);
        session.save(st1);

        session.getTransaction().commit();
        session.close();

    }

    public List<Person> read(){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Person> cq = builder.createQuery(Person.class);
        Root<Person> rootEntry = cq.from(Person.class);
        CriteriaQuery<Person> all = cq.select(rootEntry);

        TypedQuery<Person> allQuery = session.createQuery(all);
        return allQuery.getResultList();

        }


}

