package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    public void createUsersTable() {
        try {
            getUserDaoHibernateImpl().createUsersTable();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try {
            getUserDaoHibernateImpl().dropUsersTable();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            getUserDaoHibernateImpl().saveUser(name, lastName, age);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) throws SQLException, ClassNotFoundException {
        getUserDaoHibernateImpl().removeUserById(id);
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            users = getUserDaoHibernateImpl().getAllUsers();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void cleanUsersTable() {
        try {
            getUserDaoHibernateImpl().cleanUsersTable();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static UserDaoJDBCImpl getUserDaoJDBCImpl() throws SQLException, ClassNotFoundException {
        return new UserDaoJDBCImpl();
    }

    private static UserDaoHibernateImpl getUserDaoHibernateImpl() throws SQLException, ClassNotFoundException {
        return new UserDaoHibernateImpl();
    }
}
