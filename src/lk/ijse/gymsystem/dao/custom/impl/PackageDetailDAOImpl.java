package lk.ijse.gymsystem.dao.custom.impl;

import lk.ijse.gymsystem.dao.CrudUtil;
import lk.ijse.gymsystem.dao.custom.PackageDetailDAO;
import lk.ijse.gymsystem.entity.Member;
import lk.ijse.gymsystem.entity.Payment;

import java.sql.ResultSet;
import java.util.ArrayList;

public class PackageDetailDAOImpl implements PackageDetailDAO {
    @Override
    public boolean save(Member member) throws Exception {
        return false;
    }

    @Override
    public boolean update(Member member) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String t) throws Exception {
        return false;
    }

    @Override
    public Member search(String id) throws Exception {
        return null;
    }

    @Override
    public ArrayList<Member> getAll() throws Exception {
        return null;
    }

    @Override
    public ArrayList<Member> getSearch(String t) throws Exception {
            ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Member where package_id=?",t);
            ArrayList<Member> s = new ArrayList<>();
            while (rst.next()) {
                s.add(new Member(
                        rst.getString(1),
                        rst.getString(2),
                        rst.getString(3),
                        rst.getInt(4),
                        rst.getString(5),
                        rst.getString(6),
                        rst.getString(7),
                        rst.getInt(8),
                        rst.getString(9),
                        rst.getString(10),
                        rst.getString(11),
                        rst.getString(12),
                        rst.getString(13)
                ));
            }
            return s;
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
