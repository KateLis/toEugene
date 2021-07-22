package com.jdbc.research;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;
    private HibernateSessionFactoryUtil(){
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null)
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Person.class);
                configuration.addAnnotatedClass(Passport.class);
                configuration.addAnnotatedClass(Car.class);
                configuration.addAnnotatedClass(Children.class);
                configuration.addAnnotatedClass(Purchase.class);
                configuration.addAnnotatedClass(Student.class);
                configuration.addAnnotatedClass(Lesson.class);
                StandardServiceRegistryBuilder builder =
                        new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        return sessionFactory;
    }
}
