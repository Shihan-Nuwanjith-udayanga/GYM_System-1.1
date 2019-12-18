package lk.ijse.gymsystem.dao.custom.impl;

import lk.ijse.gymsystem.dao.CrudUtil;
import lk.ijse.gymsystem.dao.custom.AttendanceDAO;
import lk.ijse.gymsystem.entity.Attendance;
import lk.ijse.gymsystem.entity.Member;

import java.sql.ResultSet;
import java.util.ArrayList;

public class AttendanceDAOImpl implements AttendanceDAO {
    @Override
    public boolean save(Attendance attendance) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Attendance VALUE (?,?,?,?,?);",
                attendance.getMember_id(),
                attendance.getMember_name(),
                attendance.getDate(),
                attendance.getArrival_time(),
                attendance.getDeparture_time())>0;
    }
    @Override
    public boolean update(Attendance attendance) throws Exception {
        return CrudUtil.executeUpdate("UPDATE Attendance SET Member_name=?, Date=?, Arrival_time=?,Departure_time=? WHERE Member_id=?",
                attendance.getMember_name(),
                attendance.getDate(),
                attendance.getArrival_time(),
                attendance.getDeparture_time(),
                attendance.getMember_id())>0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM Attendance WHERE Member_id=?", id)>0;
    }

    @Override
    public Attendance search(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Attendance WHERE Member_id=?" ,id);
        if (rst.next()){
            return new Attendance(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5)
            );
        }else {
            return null;
        }
    }

    @Override
    public ArrayList<Attendance> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Attendance");
        ArrayList<Attendance> s = new ArrayList<>();
        while (rst.next()){
            s.add(new Attendance(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5)
            ));
        }
        return s;
    }

    @Override
    public ArrayList<Attendance> getSearch(String t) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Attendance where member_Id=?",t);
        ArrayList<Attendance> s = new ArrayList<>();
        while (rst.next()) {
            s.add(new Attendance(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5)
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
