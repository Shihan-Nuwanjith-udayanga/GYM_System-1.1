package lk.ijse.gymsystem.dao.custom.impl;

import lk.ijse.gymsystem.dao.CrudUtil;
import lk.ijse.gymsystem.dao.custom.ScheduleDAO;
import lk.ijse.gymsystem.entity.Schedule;

import java.awt.geom.CubicCurve2D;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ScheduleDAOImpl implements ScheduleDAO {
    @Override
    public boolean save(Schedule schedule) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Schedule VALUES (?,?,?);",
                schedule.getSchedule_id(),
                schedule.getInstructor_id(),
                schedule.getInstructor_name())>0;

    }

    @Override
    public boolean update(Schedule schedule) throws Exception {
        return CrudUtil.executeUpdate("UPDATE Schedule SET Instructor_id=? , Instructor_name=?  WHERE Schedule_id=?",
                schedule.getInstructor_id(),
                schedule.getInstructor_name(),
                schedule.getSchedule_id()) >0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM Schedule WHERE Shedule_id=?", id)>0;
    }

    @Override
    public Schedule search(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Schedule WHERE Schedule_id=?",id);
        if (rst.next()){
            return new Schedule(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3));
        }else {
            return null;
        }
    }

    @Override
    public ArrayList<Schedule> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Schedule");
        ArrayList<Schedule> s = new ArrayList<>();
        while (rst.next()){
            s.add(new Schedule(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)));
        }
        return s;
    }

    @Override
    public ArrayList<Schedule> getSearch(String t) throws Exception {
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
