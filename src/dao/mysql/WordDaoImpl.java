package dao.mysql;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.criterion.Expression;

import util.HibernateUtil;
import logic.Word;
import dao.DaoException;
import dao.WordDao;

@SuppressWarnings("deprecation")
public class WordDaoImpl implements WordDao {

    @Override
    public void create(Word word) throws DaoException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(word);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Word getById(Integer id) throws DaoException {
        Session session = null;
        Word word = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            word = (Word) session.load(Word.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return word;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Word> getAll() throws DaoException {
        Session session = null;
        List<Word> list = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            list = session.createCriteria(Word.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "getAll error", "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return list;
    }

    @Override
    public void update(Word object) throws DaoException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(object);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void delete(Word word) throws DaoException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(word);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Word getByEng(String eng) throws DaoException {
        Session session = null;
        Word word = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            word = (Word) session.createCriteria(Word.class).add(Expression.like("eng", eng)).list().get(0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "getByEng error", "Ошибка I/O", JOptionPane.OK_OPTION);
        }
        return word;
    }

}
