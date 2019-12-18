package lk.ijse.gymsystem.business.custom.impl;

import lk.ijse.gymsystem.business.custom.ScheduleBO;
import lk.ijse.gymsystem.dao.DAOFactory;
import lk.ijse.gymsystem.dao.custom.MemberDAO;
import lk.ijse.gymsystem.dao.custom.ScheduleDAO;
import lk.ijse.gymsystem.dao.custom.ScheduleDetailsDAO;
import lk.ijse.gymsystem.dao.custom.impl.MemberDAOImpl;
import lk.ijse.gymsystem.dao.custom.impl.ScheduleDAOImpl;
import lk.ijse.gymsystem.dao.custom.impl.ScheduleDetailsDAOImpl;
import lk.ijse.gymsystem.db.DBConnection;
import lk.ijse.gymsystem.dto.MemberDTO;
import lk.ijse.gymsystem.dto.ScheduleDTO;
import lk.ijse.gymsystem.entity.Member;
import lk.ijse.gymsystem.entity.Schedule;
import lk.ijse.gymsystem.entity.ScheduleDetails;

import java.sql.Connection;
import java.util.ArrayList;

public class ScheduleBOImpl implements ScheduleBO {

    private ScheduleDAO scheduleDAO=new ScheduleDAOImpl();
    private MemberDAO memberDAO=new MemberDAOImpl();
    private ScheduleDetailsDAO scheduleDetailsDAO = new ScheduleDetailsDAOImpl();


    public ScheduleBOImpl(){
        this.scheduleDAO= DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SCHEDULE);
    }


    @Override
    public boolean addSchedule(ScheduleDTO scheduleDTO, ArrayList<ScheduleDetails> list) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        boolean add = scheduleDAO.save(new Schedule(scheduleDTO.getSchedule_id(), scheduleDTO.getInstructor_id(), scheduleDTO.getInstructor_name()));
        if (add){
            for (ScheduleDetails scheduleDetails: list){
                boolean sdAdd= scheduleDetailsDAO.save(scheduleDetails);
                if (!sdAdd){
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
            }
            connection.commit();
            connection.setAutoCommit(true);
            return true;
        }else {
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }
    }

    @Override
    public boolean updateSchedule(ScheduleDTO scheduleDTO) throws Exception {
        return scheduleDAO.update(new Schedule(
                scheduleDTO.getSchedule_id(),
                scheduleDTO.getInstructor_id(),
                scheduleDTO.getInstructor_name()
        ));
    }

    @Override
    public boolean deleteSchedule(String id) throws Exception {
        return scheduleDAO.delete(id);
    }

    @Override
    public ScheduleDTO searchSchedule(String id) throws Exception {
        Schedule schedule = scheduleDAO.search(id);
        if (schedule == null){
            return null;
        }else {
            return new ScheduleDTO(
                    schedule.getSchedule_id(),
                    schedule.getInstructor_id(),
                    schedule.getInstructor_name());
        }
    }

    @Override
    public MemberDTO searchMember(String id) throws Exception {
        Member member = memberDAO.search(id);
        MemberDTO memberDTO=new MemberDTO(
                member.getMember_id(),
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
                member.getWeight());
        return memberDTO;
    }

    @Override
    public ArrayList<ScheduleDTO> gelAll() throws Exception {
        ArrayList<Schedule>allpack = scheduleDAO.getAll();
        ArrayList<ScheduleDTO>pack=new ArrayList<>();
        for (Schedule schedule:allpack){
            pack.add(new ScheduleDTO(
                    schedule.getSchedule_id(),
                    schedule.getInstructor_id(),
                    schedule.getInstructor_name()
            ));
        }
        return pack;
    }


}
