package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

@Slf4j
public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        try (final Session session = Util.getSessionFactory().openSession()) {
            final Transaction transaction = session.beginTransaction();
            try {
                final String CREATE_TABLE = """
                        CREATE TABLE IF NOT EXISTS user (
                        id INT AUTO_INCREMENT PRIMARY KEY, 
                        name VARCHAR(45) NOT NULL, 
                        lastname VARCHAR(45) NOT NULL, 
                        age INT)
                        """;
                session.createSQLQuery(CREATE_TABLE).executeUpdate();
                transaction.commit();
            } catch (final Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                log.error("Error with creating table - 'user'", e);
            }
        }
    }

    @Override
    public void dropUsersTable() {
        try (final Session session = Util.getSessionFactory().openSession()) {
            final Transaction transaction = session.beginTransaction();
            try {
                final String DROP_TABLE = "DROP TABLE IF EXISTS users";
                session.createSQLQuery(DROP_TABLE).executeUpdate();
                transaction.commit();
            } catch (final Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                log.error("Error with dropping the table - 'user'", e);
            }
        }
    }

    @Override
    public void saveUser(final String name, final String lastName, final byte age) {

    }

    @Override
    public void removeUserById(final long id) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void cleanUsersTable() {

    }
}
