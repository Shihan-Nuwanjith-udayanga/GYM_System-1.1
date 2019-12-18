package lk.ijse.gymsystem.business.custom;

import lk.ijse.gymsystem.business.SuperBO;
import lk.ijse.gymsystem.dto.MemberDTO;
import lk.ijse.gymsystem.dto.PaymentDTO;
import lk.ijse.gymsystem.dto.PackageDTO;

import java.util.ArrayList;


public interface PaymentBO extends SuperBO {

    boolean addPayment(PaymentDTO paymentDTO) throws Exception;

    PaymentDTO searchPayment(String id) throws Exception;

    MemberDTO searchMember(String id) throws Exception;

    ArrayList<PaymentDTO> getAllPayment() throws Exception;


}
