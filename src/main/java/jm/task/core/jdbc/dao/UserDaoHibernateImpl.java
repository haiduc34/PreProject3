package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private Session session;

    public UserDaoHibernateImpl() {
        this.session = Util.getSessionFactory().openSession();
    }


    @Override
    public void createUsersTable() {
        SQLQuery query = session.createSQLQuery("create table if not exists users (id bigint auto_increment, name varchar(256), lastName varchar(256), age tinyint, primary key (id))");
        Transaction trx = session.beginTransaction();
        query.executeUpdate();
        trx.commit();
        session.close();
    }

    @Override
    public void dropUsersTable() {
        SQLQuery query = session.createSQLQuery("DROP TABLE IF EXISTS users");
        Transaction trx = session.beginTransaction();
        query.executeUpdate();
        trx.commit();
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction trx = session.beginTransaction();
        session.save(new User(name, lastName, age));
        trx.commit();
        session.close();
    }

    @Override
    public void removeUserById(long id) {
        Query query = session.createQuery("Delete User u where u.id=:id");
        query.setLong("id", id);
        Transaction trx = session.beginTransaction();
        query.executeUpdate();
        trx.commit();
        session.close();
    }

    @Override
    public List<User> getAllUsers() {
        Query query = session.createQuery("from User");
        List<User> users = query.list();
        session.close();
        return users;
    }

    @Override
    public void cleanUsersTable() {
        Query query = session.createQuery("DELETE User");
        Transaction trx = session.beginTransaction();
        query.executeUpdate();
        trx.commit();
        session.close();
    }
}
