package bussiness.design;

import bussiness.entity.Product;

import java.util.List;

public interface IProduct<T, E> extends ICrud<T, E> {

    List<Product> findByName(String name);

    List<T> findByPrice(Float price1, Float price2);
    T updateDetail (T t);
    T updateStatus (T t);
    T returnProduct( T t);

    void listDele();

    void displayByName();
}
