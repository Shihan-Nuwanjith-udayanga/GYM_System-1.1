package lk.ijse.gymsystem.dao.custom.impl;


import lk.ijse.gymsystem.dao.CrudUtil;
import lk.ijse.gymsystem.dao.custom.MemberDAO;
import lk.ijse.gymsystem.entity.Member;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDAOImpl implements MemberDAO {


    @Override
    public boolean save(Member member) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Member VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)", member.getMember_id(),
                member.getMember_name(),
                member.getAddress(),
                member.getContact_no(),
                member.getE_mail(),
                member.getGender(),
                member.getDate_of_birth(),
                member.getAge(),
                member.getPackage_id(),
                member.getDate_of_join(),
                member.getDate_of_end(),
                member.getHeight(),
                member.getWeight()
        ) > 0;

    }

    @Override
    public boolean update(Member member) throws Exception {
        return CrudUtil.executeUpdate("UPDATE Member SET Member_name=?, Address=? ,Contact_no=?, E_mail=?, Gender=?, Date_of_birth=?, Age=?, Package_id=? , Date_of_join=? , Date_of_end=? , Height=?, Weight=? WHERE Member_id=? ",
                member.getMember_name(),
                member.getAddress(),
                member.getContact_no(),
                member.getE_mail(),
                member.getGender(),
                member.getDate_of_birth(),
                member.getAge(),
                member.getPackage_id(),
                member.getDate_of_join(),
                member.getDate_of_end(),
                member.getHeight(),
                member.getWeight(),
                member.getMember_id()
        )>0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM Member WHERE Member_id=?", id) > 0;
    }

    @Override
    public Member search(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Member WHERE Member_id=?", id);
        if (rst.next()) {
            return new Member(
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
            );
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Member> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Member");
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
    public ArrayList<Member> getSearch(String t) throws Exception {
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
