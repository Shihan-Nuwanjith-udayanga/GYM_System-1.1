package lk.ijse.gymsystem.dao.custom.impl;

import lk.ijse.gymsystem.dao.CrudUtil;
import lk.ijse.gymsystem.dao.custom.PaymentDAO;
import lk.ijse.gymsystem.entity.Package;
import lk.ijse.gymsystem.entity.Payment;

import java.sql.ResultSet;
import java.util.ArrayList;

public class PaymentDAOImpl implements PaymentDAO {
    @Override
    public boolean save(Payment payment) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Payment VALUES (?,?,?,?,?,?,?,?,?,?,?,?);",
                payment.getPayment_id(),
                payment.getMember_id(),
                payment.getMember_name(),
                payment.getPackage_id(),
                payment.getPackage_name(),
                payment.getDuration(),
                payment.getDate(),
                payment.getPayment_method(),
                payment.getAmount(),
                payment.getCash(),
                payment.getBalance(),
                payment.getDescription())>0;
    }

    @Override
    public boolean update(Payment payment) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String t) throws Exception {
        return false;
    }

    @Override
    public Payment search(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * from Payment where member_id=? ",id);
        if (rst.next()){
            return new Payment(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getDouble(9),
                    rst.getDouble(10),
                    rst.getDouble(11),
                    rst.getString(12)
                    );
        }else {
            return null;
        }
    }

    @Override
    public ArrayList<Payment> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from payment");
        ArrayList<Payment> s = new ArrayList<>();
        while (rst.next()){
            s.add(new Payment(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getDouble(9),
                    rst.getDouble(10),
                    rst.getDouble(11),
                    rst.getString(12)));
        }
        return s;
    }

    @Override
    public ArrayList<Payment> getSearch(String t) throws Exception {
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
