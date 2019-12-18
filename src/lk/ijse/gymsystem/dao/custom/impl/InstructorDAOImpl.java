package lk.ijse.gymsystem.dao.custom.impl;

import lk.ijse.gymsystem.dao.CrudUtil;
import lk.ijse.gymsystem.dao.custom.InstructorDAO;
import lk.ijse.gymsystem.entity.Instructor;

import java.sql.ResultSet;
import java.util.ArrayList;

public class InstructorDAOImpl implements InstructorDAO {
    @Override
    public boolean save(Instructor instructor) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Instructor VALUES(?,?,?,?,?,?,?,?,?,?,?,?);",
                instructor.getInstructor_id(),
                instructor.getInstructor_name(),
                instructor.getAddress(),
                instructor.getContact_no(),
                instructor.getE_mail(),
                instructor.getGender(),
                instructor.getDate_of_birth(),
                instructor.getAge(),
                instructor.getDate_of_join(),
                instructor.getSalary(),
                instructor.getHeight(),
                instructor.getWeight())>0;
    }

    @Override
    public boolean update(Instructor instructor) throws Exception {
        return CrudUtil.executeUpdate("UPDATE Instructor SET Instructor_name=?,Address=?,Contact_no=?,E_mail=?,Gender=?,Date_of_birth=?,Age=?,Date_of_join=?,Salary=?,Height=?,Weight=? WHERE Instructor_id=?",
                instructor.getInstructor_name(),
                instructor.getAddress(),
                instructor.getContact_no(),
                instructor.getE_mail(),
                instructor.getGender(),
                instructor.getDate_of_birth(),
                instructor.getAge(),
                instructor.getDate_of_join(),
                instructor.getSalary(),
                instructor.getHeight(),
                instructor.getWeight(),
                instructor.getInstructor_id()
        )>0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM Instructor  WHERE Instructor_id=?",id)>0;
    }

    @Override
    public Instructor search(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Instructor WHERE Instructor_id=?", id);
        if (rst.next()){
            return new Instructor(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getInt(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getInt(8),
                    rst.getString(9),
                    rst.getDouble(10),
                    rst.getString(11),
                    rst.getString(12));
        }else {
            return null;
        }
    }

    @Override
    public ArrayList<Instructor> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Instructor");
        ArrayList<Instructor> s = new ArrayList<>();
        while (rst.next()){
            s.add(new Instructor(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getInt(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getInt(8),
                    rst.getString(9),
                    rst.getDouble(10),
                    rst.getString(11),
                    rst.getString(12)
                    ));
        }
        return s;
    }

    @Override
    public ArrayList<Instructor> getSearch(String t) throws Exception {
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
