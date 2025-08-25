package org.walkmanx21;

import jakarta.persistence.Persistence;
import org.walkmanx21.dao.PersonDao;
import org.walkmanx21.models.Person;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final PersonDao personDao = PersonDao.getINSTANCE();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("People: ");
        var people = personDao.findAll();
        people.forEach(System.out::println);

    }
}