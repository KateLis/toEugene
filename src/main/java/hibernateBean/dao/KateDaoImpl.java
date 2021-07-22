package hibernateBean.dao;

import hibernateBean.entity.Buyer;
import hibernateBean.entity.Course;
import hibernateBean.entity.Manager;
import hibernateBean.entity.Supervisor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.List;

@Repository
public class KateDaoImpl implements KateDao{
    private final SessionFactory sessionFactory;

    public KateDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void setCourse(Course course) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(course);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void changeCourse(Course course, String anotherName) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        course.setCourseName(anotherName);
        session.update(course);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteBuyer(Buyer buyer) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(buyer);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List showAllCourses() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List courses = session.createQuery("FROM Course").list(); //как-то так себе показал
        session.getTransaction().commit();
        session.close();
        return courses;
        //session.get(Course.class, ); //че не так??
    }

    public Supervisor getSupById(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Supervisor supervisor = session.load(Supervisor.class, id);
//        session.getTransaction().commit();
//        session.close();
        return supervisor;

        //session.get(Course.class, ); //че не так??
    }




    @Override
    public void saveBuyer(Buyer buyer) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(buyer);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void saveSupervisor(Supervisor supervisor) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(supervisor);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void saveManager(Manager manager) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(manager);
        session.getTransaction().commit();
        session.close();
    }


}
