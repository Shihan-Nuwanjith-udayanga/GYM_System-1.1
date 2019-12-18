package lk.ijse.gymsystem.business.custom;

import lk.ijse.gymsystem.business.SuperBO;
import lk.ijse.gymsystem.dto.MemberDTO;
import lk.ijse.gymsystem.dto.ScheduleDTO;
import lk.ijse.gymsystem.entity.ScheduleDetails;

import java.util.ArrayList;

public interface ScheduleBO extends SuperBO {

    boolean addSchedule(ScheduleDTO scheduleDTO, ArrayList<ScheduleDetails>list)throws Exception;

    boolean updateSchedule(ScheduleDTO scheduleDTO)throws Exception;

    boolean deleteSchedule (String id)throws Exception;

    ScheduleDTO searchSchedule (String id)throws Exception;

    MemberDTO searchMember (String id)throws Exception;

    ArrayList<ScheduleDTO>gelAll()throws Exception;
}
