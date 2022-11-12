package bussiness.design;

import java.util.List;
import java.util.Scanner;

public interface ICrud<T,E> {

    T inputData (Scanner sc);

    List<T> readFromFile();

    boolean writeFromFile(List<T> list);

    boolean creat(T t);

    boolean update(T t);

    List<T> findAll();

    T findByID(E id);

}
