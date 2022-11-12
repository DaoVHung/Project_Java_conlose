package bussiness.design;

public interface ITable<T, E>  extends ICrud<T,E> {
    void displayByStatus();
     T updateDetail(T t);
    T updateStatus (T t);
}
