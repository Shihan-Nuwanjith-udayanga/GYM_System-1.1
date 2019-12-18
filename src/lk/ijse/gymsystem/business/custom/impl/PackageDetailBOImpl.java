package lk.ijse.gymsystem.business.custom.impl;

import lk.ijse.gymsystem.business.custom.PackageBO;
import lk.ijse.gymsystem.business.custom.PackageDetailBO;
import lk.ijse.gymsystem.dao.DAOFactory;
import lk.ijse.gymsystem.dao.custom.MemberDAO;
import lk.ijse.gymsystem.dao.custom.PackageDAO;
import lk.ijse.gymsystem.dao.custom.PackageDetailDAO;
import lk.ijse.gymsystem.dao.custom.PaymentDAO;
import lk.ijse.gymsystem.dao.custom.impl.MemberDAOImpl;
import lk.ijse.gymsystem.dao.custom.impl.PackageDAOImpl;
import lk.ijse.gymsystem.dao.custom.impl.PackageDetailDAOImpl;
import lk.ijse.gymsystem.dao.custom.impl.PaymentDAOImpl;
import lk.ijse.gymsystem.dto.MemberDTO;
import lk.ijse.gymsystem.dto.PackageDTO;
import lk.ijse.gymsystem.entity.Member;
import lk.ijse.gymsystem.entity.Package;

import java.util.ArrayList;

public class PackageDetailBOImpl implements PackageDetailBO {

    private MemberDAO memberDAO;
    private PackageDetailDAO packageDAO;

    public PackageDetailBOImpl(){
        this.memberDAO= DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.MEMBER);
        this.packageDAO= DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PACKAGEDETAILS);
    }

    @Override
    public ArrayList<MemberDTO> getSearchMember(String id) throws Exception {

        ArrayList<Member> serachMember = packageDAO.getSearch(id);

        ArrayList<MemberDTO>members = new ArrayList<>();
        for (Member member : serachMember){
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
}
