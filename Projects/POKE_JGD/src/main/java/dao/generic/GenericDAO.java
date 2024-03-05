package dao.generic;

import java.util.List;

public interface GenericDAO<T>{
    public void insert(T t);
    public void delete(T t);
    public void update(T t);
    public T select(Long id);
    public List<T> selectAll();
}
