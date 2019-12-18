package lk.ijse.gymsystem.dao;

import java.util.ArrayList;
import java.util.List;

public interface CrudDAO<T,ID>extends SuperDAO {
    boolean save(T t)throws Exception;

    boolean update(T t)throws Exception;

    boolean delete(ID t)throws Exception;

    T search(ID t)throws Exception;

    ArrayList<T> getAll()throws Exception;

    ArrayList<T> getSearch(ID t)throws Exception;

    Integer lastIndex()throws Exception;

    Integer getIncrementIndex()throws Exception;

}
