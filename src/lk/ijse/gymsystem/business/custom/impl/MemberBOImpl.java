package lk.ijse.gymsystem.business.custom.impl;

import lk.ijse.gymsystem.business.custom.MemberBO;
import lk.ijse.gymsystem.dao.DAOFactory;
import lk.ijse.gymsystem.dao.custom.MemberDAO;
import lk.ijse.gymsystem.dao.custom.impl.MemberDAOImpl;
import lk.ijse.gymsystem.dto.MemberDTO;
import lk.ijse.gymsystem.entity.Member;

import java.util.ArrayList;

public class MemberBOImpl implements MemberBO {

    private MemberDAO memberDAO = new MemberDAOImpl();

    public MemberBOImpl(){
        this.memberDAO= DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.MEMBER);
    }


    @Override
    public boolean addMember(MemberDTO memberDTO) throws Exception {
        return memberDAO.save(new Member(
                memberDTO.getMember_id(),
                memberDTO.getMember_name(),
                memberDTO.getAddress(),
                memberDTO.getContact_no(),
                memberDTO.getE_mail(),
                memberDTO.getGender(),
                memberDTO.getDate_of_birth(),
                memberDTO.getAge(),
                memberDTO.getPackage_id(),
                memberDTO.getDate_of_join(),
                memberDTO.getDate_of_end(),
                memberDTO.getHeight(),
                memberDTO.getWeight()
        ));
    }

    @Override
    public boolean updateMember(MemberDTO memberDTO) throws Exception {
        return memberDAO.update(new Member(
                memberDTO.getMember_id(),
                memberDTO.getMember_name(),
                memberDTO.getAddress(),
                memberDTO.getContact_no(),
                memberDTO.getE_mail(),
                memberDTO.getGender(),
                memberDTO.getDate_of_birth(),
                memberDTO.getAge(),
                memberDTO.getPackage_id(),
                memberDTO.getDate_of_join(),
                memberDTO.getDate_of_end(),
                memberDTO.getHeight(),
                memberDTO.getWeight()
        ));
    }

    @Override
    public boolean deleteMember(String id) throws Exception {
        return memberDAO.delete(id);
    }

    @Override
    public MemberDTO searchMember(String id) throws Exception {
        Member member = memberDAO.search(id);
        if (member == null){
            return null;
        }else {
            return new MemberDTO(
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
                    member.getWeight()
            );
        }
    }

    @Override
    public ArrayList<MemberDTO> getMember() throws Exception {
        ArrayList<Member>allMember = memberDAO.getAll();
        ArrayList<MemberDTO>members = new ArrayList<>();
        for (Member member : allMember){
            members.add(new MemberDTO(
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
                    member.getWeight()
            ));
        }
        return members;
    }

    @Override
    public ArrayList<MemberDTO> getSearchMember(String id) throws Exception {
        return null;
    }
}
