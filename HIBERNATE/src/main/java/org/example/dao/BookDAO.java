package org.example.dao;

import org.example.model.Book;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BookDAO {

    public Long save(Book book) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Long id = (Long) session.save(book);
            tx.commit();
            return id;
        } catch (Exception ex) {
            if (tx != null) tx.rollback();
            throw ex;
        }
    }

    public List<Book> list() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Book", Book.class).list();
        }
    }

    public void update(Book book) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(book);
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) tx.rollback();
            throw ex;
        }
    }

    public void delete(Long id) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Book book = session.get(Book.class, id);
            if (book != null) {
                session.delete(book);
            }
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) tx.rollback();
            throw ex;
        }
    }

    public Book findById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Book.class, id);
        }
    }
}
