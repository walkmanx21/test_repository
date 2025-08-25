package org.walkmanx21.dao;

import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.walkmanx21.models.Person;
import org.walkmanx21.util.HibernateUtil;

public class PersonDao {

    @Getter
    private static final PersonDao INSTANCE = new PersonDao();

    private PersonDao() {}

    public void insertPerson (Person person) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session currentSession = sessionFactory.getCurrentSession()) {
            currentSession.beginTransaction();
            currentSession.persist(person);
            currentSession.getTransaction().commit();
        }
    }
}
