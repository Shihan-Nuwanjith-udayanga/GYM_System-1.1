package lk.ijse.gymsystem.business.custom;

import lk.ijse.gymsystem.business.SuperBO;
import lk.ijse.gymsystem.dto.MemberDTO;

import java.util.ArrayList;

public interface PackageDetailBO extends SuperBO {

    ArrayList<MemberDTO> getSearchMember(String id)throws Exception;

}
