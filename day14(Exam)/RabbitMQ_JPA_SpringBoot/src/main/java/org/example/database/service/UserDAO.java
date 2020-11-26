package org.example.database.service;
import com.google.gson.Gson;
import org.example.database.model.User;
import sun.rmi.runtime.Log;


import javax.persistence.*;
import java.util.List;


public class UserDAO {
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;
    public UserDAO() {
    }
    public UserDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.entityTransaction = this.entityManager.getTransaction();
    }
    public void addUserDAO(String userString) {
        //beginTransaction();
        User usernew = new Gson().fromJson(userString, User.class);
        usernew.setBalance(Long.valueOf(1250000));
        entityManager.persist(usernew);
        //commitTransaction();
    }


    public User find(String userString) {
        User usernew = new Gson().fromJson(userString, User.class);
        User  user;
        try {
            user = entityManager.createQuery("SELECT a FROM User a where account_number ="+usernew.getAccount_number(), User.class).getSingleResult();
        } catch (NoResultException e){
            return null;
        }
        System.out.println("debug"+user);
        return user;
    }

    public List<User> findAll() {
        List<User> listUser = entityManager.createQuery("SELECT a FROM User a ", User.class).getResultList();
        return listUser;
    }

    public User findId(String idString) {
        User  mhs;
        try {
            mhs = entityManager.createQuery("SELECT a FROM User a where id ="+Long.valueOf(idString), User.class).getSingleResult();
        } catch (NoResultException e){
            return null;
        }
        System.out.println("debug"+mhs);
        return mhs;
    }

    public boolean checkAccNumPin(String userString){
        List<User> listAllUser = findAll();
        User user = new Gson().fromJson(userString, User.class);
        boolean canLogin = false;
        for (User obj : listAllUser){
            if(obj.getAccount_number().equals(user.getAccount_number())){
                if(obj.getPin()==user.getPin()){
                    canLogin = true;
                }
            }
        }
        return canLogin;
    }


    public boolean isRegistered(String userString) {
        List<User> listAllUser = findAll();
        User user = new Gson().fromJson(userString, User.class);
        boolean registered = false;
        for (User obj : listAllUser){
            if(obj.getAccount_number().equals(user.getAccount_number())){
                registered = true;
            }
        }
        return registered;
    }


}
