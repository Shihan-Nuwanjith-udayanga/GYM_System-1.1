package lk.ijse.gymsystem.business.custom.impl;

import lk.ijse.gymsystem.business.custom.AttendanceBO;
import lk.ijse.gymsystem.dao.DAOFactory;
import lk.ijse.gymsystem.dao.custom.AttendanceDAO;
import lk.ijse.gymsystem.dao.custom.MemberDAO;
import lk.ijse.gymsystem.dao.custom.impl.AttendanceDAOImpl;
import lk.ijse.gymsystem.dao.custom.impl.MemberDAOImpl;
import lk.ijse.gymsystem.dto.AttendanceDTO;
import lk.ijse.gymsystem.dto.MemberDTO;
import lk.ijse.gymsystem.dto.PackageDTO;
import lk.ijse.gymsystem.entity.Attendance;
import lk.ijse.gymsystem.entity.Member;

import java.util.ArrayList;

public class AttendanceBOImpl implements AttendanceBO {

    private MemberDAO memberDAO = new MemberDAOImpl();
    private AttendanceDAO attendanceDAO= new AttendanceDAOImpl();

    public AttendanceBOImpl(){
        this.attendanceDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ATTENDANCE);
    }

    @Override
    public MemberDTO searchMember(String id) throws Exception {
        Member member = memberDAO.search(id);
        MemberDTO memberDTO=new MemberDTO(member.getMember_id(),
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
    public boolean addAttendance(AttendanceDTO attendanceDTO) throws Exception {
        return attendanceDAO.save(new Attendance(
                attendanceDTO.getMember_id(),
                attendanceDTO.getMember_name(),
                attendanceDTO.getDate(),
                attendanceDTO.getArrival_time(),
                attendanceDTO.getDeparture_time()
        ));
    }

    @Override
    public boolean updateAttendance(AttendanceDTO attendanceDTO) throws Exception {
        return attendanceDAO.update(new Attendance(
                attendanceDTO.getMember_id(),
                attendanceDTO.getMember_name(),
                attendanceDTO.getDate(),
                attendanceDTO.getArrival_time(),
                attendanceDTO.getDeparture_time()
        ));
    }


    @Override
    public boolean deleteAttendance(String id) throws Exception {
        return attendanceDAO.delete(id);
    }

    @Override
    public ArrayList<AttendanceDTO> getAttendance() throws Exception {
        ArrayList<Attendance> allAttendance = attendanceDAO.getAll();
        ArrayList<AttendanceDTO> attendances = new ArrayList<>();
        for (Attendance attendance : allAttendance){
            attendances.add(new AttendanceDTO(
                    attendance.getMember_id(),
                    attendance.getMember_name(),
                    attendance.getDate(),
                    attendance.getArrival_time(),
                    attendance.getDeparture_time()
            ));
        }
        return attendances;
    }

    @Override
    public ArrayList<AttendanceDTO> getSearchAttendance(String id) throws Exception {
        ArrayList<Attendance> serachAtt = attendanceDAO.getSearch(id);

        ArrayList<AttendanceDTO>members = new ArrayList<>();
        for (Attendance member : serachAtt){
            members.add(new AttendanceDTO(
                    member.getMember_id(),
                    member.getMember_name(),
                    member.getDate(),
                    member.getArrival_time(),
                    member.getDeparture_time()
            ));
        }

        return members;
    }
    }

