package lk.ijse.gymsystem.business.custom.impl;

import lk.ijse.gymsystem.business.custom.PaymentBO;
import lk.ijse.gymsystem.dao.DAOFactory;
import lk.ijse.gymsystem.dao.custom.MemberDAO;
import lk.ijse.gymsystem.dao.custom.PackageDAO;
import lk.ijse.gymsystem.dao.custom.PaymentDAO;
import lk.ijse.gymsystem.dao.custom.impl.MemberDAOImpl;
import lk.ijse.gymsystem.dao.custom.impl.PackageDAOImpl;
import lk.ijse.gymsystem.dao.custom.impl.PaymentDAOImpl;
import lk.ijse.gymsystem.dto.MemberDTO;
import lk.ijse.gymsystem.dto.PackageDTO;
import lk.ijse.gymsystem.dto.PaymentDTO;
import lk.ijse.gymsystem.entity.Member;
import lk.ijse.gymsystem.entity.Package;
import lk.ijse.gymsystem.entity.Payment;

import java.util.ArrayList;

public class PaymentBOImpl implements PaymentBO {

    private PaymentDAO paymentDAO = new PaymentDAOImpl();

    private MemberDAO memberDAO = new MemberDAOImpl();

    private PackageDAO packageDAO = new PackageDAOImpl();

    public PaymentBOImpl(){
        this.paymentDAO= DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PAYMENT);
    }

    @Override
    public boolean addPayment(PaymentDTO paymentDTO) throws Exception {
        return paymentDAO.save(new Payment(
                paymentDTO.getPayment_id(),
                paymentDTO.getMember_id(),
                paymentDTO.getMember_name(),
                paymentDTO.getPackage_id(),
                paymentDTO.getPackage_name(),
                paymentDTO.getDuration(),
                paymentDTO.getDate(),
                paymentDTO.getPayment_method(),
                paymentDTO.getAmount(),
                paymentDTO.getCash(),
                paymentDTO.getBalance(),
                paymentDTO.getDescription()
        ));
    }

    @Override
    public PaymentDTO searchPayment(String id) throws Exception {
        Payment payment = paymentDAO.search(id);
        if (payment == null){
            return null;
        }else {
            return new PaymentDTO(
               payment.getPayment_id(),
               payment.getMember_id(),
               payment.getMember_name(),
               payment.getPackage_id(),
               payment.getPackage_name(),
               payment.getDuration(),
               payment.getDate(),
               payment.getPayment_method(),
               payment.getAmount(),
               payment.getCash(),
               payment.getBalance(),
               payment.getDescription()
            );
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
    public ArrayList<PaymentDTO> getAllPayment() throws Exception {
        ArrayList<Payment> allpack = paymentDAO.getAll();
        ArrayList<PaymentDTO> pack = new ArrayList<>();
        for (Payment payment:allpack){
            pack.add(new PaymentDTO(
                    payment.getPayment_id(),
                    payment.getMember_id(),
                    payment.getMember_name(),
                    payment.getPackage_id(),
                    payment.getPackage_name(),
                    payment.getDuration(),
                    payment.getDate(),
                    payment.getPayment_method(),
                    payment.getAmount(),
                    payment.getCash(),
                    payment.getBalance(),
                    payment.getDescription()
            ));
        }
        return pack;
    }
}
