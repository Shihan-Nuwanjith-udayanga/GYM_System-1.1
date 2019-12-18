package lk.ijse.gymsystem.dao.custom.impl;

import lk.ijse.gymsystem.dao.CrudUtil;
import lk.ijse.gymsystem.dao.custom.ItemDAO;
import lk.ijse.gymsystem.entity.Item;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public boolean save(Item item) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Item VALUES(?,?,?,?,?,?);",
                item.getItem_id(),
                item.getItem_name(),
                item.getBrand(),
                item.getBought_price(),
                item.getBought_date(),
                item.getDescription())>0;
    }

    @Override
    public boolean update(Item item) throws Exception {
        return CrudUtil.executeUpdate("UPDATE Item SET Item_name=?, Brand=?, Bought_price=?, Bought_date=?,Description=? WHERE Item_id=?",
                item.getItem_name(),
                item.getBrand(),
                item.getBought_price(),
                item.getBought_date(),
                item.getDescription(),
                item.getItem_id())>0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM Item WHERE Item_id=?",id)>0;
    }

    @Override
    public Item search(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Item WHERE Item_id=?", id);
        if (rst.next()){
            return new Item(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getDouble(4),
                    rst.getString(5),
                    rst.getString(6));
        }else {
            return null;
        }
    }

    @Override
    public ArrayList<Item> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Item");
        ArrayList<Item> s = new ArrayList<>();
        while (rst.next()){
            s.add(new Item(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getDouble(4),
                    rst.getString(5),
                    rst.getString(6)
            ));
        }
        return s;
    }

    @Override
    public ArrayList<Item> getSearch(String t) throws Exception {
        return null;
    }

    @Override
    public Integer lastIndex() throws Exception {
        return null;
    }

    @Override
    public Integer getIncrementIndex() throws Exception {
        return null;
    }
}
