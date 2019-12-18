package lk.ijse.gymsystem.business.custom;

import lk.ijse.gymsystem.business.SuperBO;
import lk.ijse.gymsystem.dto.MemberDTO;

import java.util.ArrayList;

public interface MemberBO extends SuperBO {

    boolean addMember (MemberDTO memberDTO)throws Exception;

    boolean updateMember(MemberDTO memberDTO)throws Exception;

    boolean deleteMember (String id)throws Exception;

    MemberDTO searchMember (String id)throws Exception;

    ArrayList<MemberDTO> getMember()throws Exception;

    ArrayList<MemberDTO> getSearchMember(String id)throws Exception;

}
