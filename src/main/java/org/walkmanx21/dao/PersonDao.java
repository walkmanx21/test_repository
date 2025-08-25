package org.walkmanx21.dao;

import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.SelectionQuery;
import org.walkmanx21.models.Person;
import org.walkmanx21.util.HibernateUtil;

import java.util.List;

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

    public List<Person> findAll () {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        List<Person> people;

        try (Session currentSession = sessionFactory.getCurrentSession()) {
            currentSession.beginTransaction();
            String hql = "SELECT p FROM Person p";
            var selectionQuery = currentSession.createSelectionQuery(hql, Person.class);
            people = selectionQuery.getResultList();
            currentSession.getTransaction().commit();
        }

        return people;
    }
}
