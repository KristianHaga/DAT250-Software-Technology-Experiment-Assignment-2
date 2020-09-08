package BankingExample.main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import BankingExample.model.Person;
import BankingExample.model.CreditCard;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("banking");
        EntityManager em = factory.createEntityManager();
        // read the existing entries and write to console
        Query q = em.createQuery("select p from Person p");
        List<Person> todoList = q.getResultList();
        for (Person person : todoList) {
            String id = person.getId();
            String name = person.getName();

            List<CreditCard> creditCards = person.getCreditCards();
            int ckNumber = creditCards.get(0).getNumber();

            System.out.println("ID:" + id);
            System.out.println("Name: " + name);
            System.out.println("Credit Card: " + ckNumber);
        }

        em.getTransaction().begin();

        /**
        I loaded in some data here on the first run

        // CreditCard
        CreditCard creditCard = new CreditCard();
        creditCard.setNumber(12345678);
        em.persist(creditCard);

        // Person
        Person person = new Person();
        person.setName("Ola Nordmann");
        person.setCreditCards(new ArrayList<>().add(creditCard));
        em.persist(person);
        */

        em.close();
    }
}