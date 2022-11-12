package bussiness.design;

import java.util.List;

public interface ICatalog<T, E> extends ICrud<T, E> {
    void displayByPriority();

    List<T> findByCatalogName(String str);

    T updateDetail(T t);
}
