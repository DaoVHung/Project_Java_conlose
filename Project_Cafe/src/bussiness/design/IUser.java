package bussiness.design;

import bussiness.entity.User;

import java.util.List;

public interface IUser<T, E> extends ICrud<T,E>{
    T checkLogin(String userName, String password);

    void displayByDate();
    T findByUserName(T t);


    List<T> findByName(String name);

    T updateStatus(T t);
}
