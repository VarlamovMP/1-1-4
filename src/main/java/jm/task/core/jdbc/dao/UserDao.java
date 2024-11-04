package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.util.List;

public interface UserDao {
    //createUsersTable(): Этот метод отвечает за создание таблицы пользователей в базе данных.
    void createUsersTable();

    //dropUsersTable(): Этот метод удаляет существующую таблицу пользователей из базы данных.
    void dropUsersTable();

    //saveUser(String name, String lastName, byte age): Этот метод сохраняет информацию о пользователе
    // (имя, фамилию и возраст) в таблице пользователей.
    void saveUser(String name, String lastName, byte age);

    //removeUserById(long id): Этот метод удаляет пользователя из таблицы по уникальному идентификатору (ID).
    void removeUserById(long id);

    //Этот метод возвращает список всех пользователей, хранящихся в таблице пользователей.
    List<User> getAllUsers();

    //cleanUsersTable(): Этот метод очищает таблицу пользователей,
    // удаляя всех пользователей, но оставляя саму таблицу.
    void cleanUsersTable();
}
