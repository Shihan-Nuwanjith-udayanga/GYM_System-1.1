package lk.ijse.gymsystem.dao.custom.impl;

import lk.ijse.gymsystem.dao.CrudUtil;
import lk.ijse.gymsystem.dao.custom.PackageDAO;
import lk.ijse.gymsystem.entity.Package;

import java.sql.ResultSet;
import java.util.ArrayList;

public class PackageDAOImpl implements PackageDAO {

    @Override
    public boolean save(Package aPackage) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Package VALUES(?,?,?,?,?,?,?);",
                aPackage.getPackage_id(),
                aPackage.getPackage_name(),
                aPackage.getDuration(),
                aPackage.getAmount(),
                aPackage.getDiscount(),
                aPackage.getDiscount_amount(),
                aPackage.getNew_amount()) >0;
    }

    @Override
    public boolean update(Package aPackage) throws Exception {
        return CrudUtil.executeUpdate("UPDATE Package SET Package_name=? , Duration=? , Amount=? , Discount=? ,Discount_amount=?, New_amount=? WHERE Package_id=? ",
            aPackage.getPackage_name(),
            aPackage.getDuration(),
            aPackage.getAmount(),
            aPackage.getDiscount(),
            aPackage.getDiscount_amount(),
            aPackage.getNew_amount(),
            aPackage.getPackage_id())>0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("delete  from Package where Package_id=?" ,id)>0;
    }

    @Override
    public Package search(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * from Package where Package_id=?",id);
        if (rst.next()){
            return new Package(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getDouble(4),
                    rst.getDouble(5),
                    rst.getDouble(6),
                    rst.getDouble(7));
        }else {
            return null;
        }
    }

    @Override
    public ArrayList<Package> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from Package");
        ArrayList<Package> s = new ArrayList<>();
        while (rst.next()){
            s.add(new Package(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getDouble(4),
                    rst.getDouble(5),
                    rst.getDouble(6),
                    rst.getDouble(7)));
        }
        return s;
    }

    @Override
    public ArrayList<Package> getSearch(String t) throws Exception {
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
