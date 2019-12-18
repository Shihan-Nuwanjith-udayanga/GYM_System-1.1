package lk.ijse.gymsystem.dao.custom.impl;

import lk.ijse.gymsystem.dao.CrudUtil;
import lk.ijse.gymsystem.dao.custom.ProductDAO;
import lk.ijse.gymsystem.entity.Product;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductDAOImpl implements ProductDAO {
    @Override
    public boolean save(Product product) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Product VALUES (?,?,?,?,?,?,?,?)",
                product.getProduct_id(),
                product.getProduct_name(),
                product.getCategory(),
                product.getFeatures(),
                product.getPrice(),
                product.getDiscount(),
                product.getDiscount_price(),
                product.getNew_price())>0;
    }

    @Override
    public boolean update(Product product) throws Exception {
        return CrudUtil.executeUpdate("UPDATE Product SET Product_name=? ,Category=? ,Features=? ,Price=? ,Discount=? , Discount_price=? , New_price=? WHERE Product_id=?",
                product.getProduct_name(),
                product.getCategory(),
                product.getFeatures(),
                product.getPrice(),
                product.getDiscount(),
                product.getDiscount_price(),
                product.getNew_price(),
                product.getProduct_id()
        )>0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM Product WHERE Product_id=?", id)>0;
    }

    @Override
    public Product search(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Product WHERE Product_id=?",id);
        if (rst.next()){
            return new Product(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getDouble(5),
                    rst.getDouble(6),
                    rst.getDouble(7),
                    rst.getDouble(8));
        }else {
            return null;
        }
    }

    @Override
    public ArrayList<Product> getAll() throws Exception {
        ResultSet rst= CrudUtil.executeQuery("SELECT * FROM Product");
        ArrayList<Product> s = new ArrayList<>();
        while (rst.next()){
            s.add(new Product(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getDouble(5),
                    rst.getDouble(6),
                    rst.getDouble(7),
                    rst.getDouble(8)
            ));
        }
        return s;
    }

    @Override
    public ArrayList<Product> getSearch(String t) throws Exception {
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
