package lk.ijse.gymsystem.dao.custom.impl;

import lk.ijse.gymsystem.dao.CrudUtil;
import lk.ijse.gymsystem.dao.custom.ScheduleDetailsDAO;
import lk.ijse.gymsystem.entity.ScheduleDetails;

import java.util.ArrayList;

public class ScheduleDetailsDAOImpl implements ScheduleDetailsDAO {
    @Override
    public boolean save(ScheduleDetails scheduleDetails) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Schedule_details VALUES (?,?,?,?,?,?,?);",
                scheduleDetails.getSchedule_id(),
                scheduleDetails.getMember_id(),
                scheduleDetails.getMember_name(),
                scheduleDetails.getDate(),
                scheduleDetails.getNo(),
                scheduleDetails.getExercise(),
                scheduleDetails.getFrequency())>0;

    }

    @Override
    public boolean update(ScheduleDetails scheduleDetails) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String t) throws Exception {
        return false;
    }

    @Override
    public ScheduleDetails search(String t) throws Exception {
        return null;
    }

    @Override
    public ArrayList<ScheduleDetails> getAll() throws Exception {
        return null;
    }

    @Override
    public ArrayList<ScheduleDetails> getSearch(String t) throws Exception {
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
