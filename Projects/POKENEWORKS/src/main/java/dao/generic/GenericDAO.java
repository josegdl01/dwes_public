package dao.generic;

import java.util.List;

public interface GenericDAO<T> {
    public void updateItem(T t);
    public void insertItem(T t);
    public void deleteItem(T t);
    public T selectItem(long id);
    public List<T> selectAllItems();
}
