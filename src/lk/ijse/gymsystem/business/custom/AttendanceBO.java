package lk.ijse.gymsystem.business.custom;

import lk.ijse.gymsystem.business.SuperBO;
import lk.ijse.gymsystem.dto.AttendanceDTO;
import lk.ijse.gymsystem.dto.MemberDTO;

import java.util.ArrayList;


public interface AttendanceBO extends SuperBO {

    MemberDTO searchMember (String id)throws Exception;


    boolean addAttendance (AttendanceDTO attendanceDTO)throws Exception;

    boolean updateAttendance(AttendanceDTO attendanceDTO)throws Exception;

    boolean deleteAttendance (String id)throws Exception;

    ArrayList<AttendanceDTO>getAttendance()throws Exception;

    ArrayList<AttendanceDTO> getSearchAttendance(String id)throws Exception;
}
