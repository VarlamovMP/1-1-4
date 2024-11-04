package jm.task.core.jdbc;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
//        Util.getConnection();
//        UserServiceImpl userService = new UserServiceImpl();
//        userService.createUsersTable();
//        userService.saveUser("Анна", "Варламова", (byte) 6);
//        userService.saveUser("Григорий", "Варламов", (byte) 14);
//        userService.saveUser("Татьяна", "Варламова", (byte) 43);
//        userService.saveUser("Михаил", "Варламов", (byte) 42);
//
//        userService.removeUserById(4);
//        userService.getAllUsers();
//        userService.cleanUsersTable();
//        userService.dropUsersTable();

        SessionFactory sessionFactory = Util.getSessionFactory();
        UserServiceImpl userService = new UserServiceImpl();

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                System.out.println("Hibernate Session успешно!");
                userService.createUsersTable();
                userService.saveUser("Анна", "Варламова", (byte) 6);
                userService.saveUser("Григорий", "Варламов", (byte) 14);
                userService.saveUser("Татьяна", "Варламова", (byte) 43);
                userService.saveUser("Михаил", "Варламов", (byte) 42);

                userService.getAllUsers();
                userService.removeUserById(2);
//                userService.getAllUsers();
                userService.cleanUsersTable();
                userService.dropUsersTable();

                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                System.out.println("Ошибка Hibernate session.");
                e.printStackTrace();

            } finally {
                if (sessionFactory != null) {
                    sessionFactory.close();
                    System.out.println("SessionFactory закрыта.");
                }
            }
        }
    }
}
