package org.walkmanx21.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.walkmanx21.models.Person;


public final class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration().addAnnotatedClasses(Person.class);
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }

}
