package lk.ijse.gymsystem.dao;


import lk.ijse.gymsystem.business.custom.impl.MemberBOImpl;
import lk.ijse.gymsystem.business.custom.impl.ProductBOImpl;
import lk.ijse.gymsystem.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory dAOFactory;

    private DAOFactory(){
    }

    public static DAOFactory getInstance(){
        if (dAOFactory == null){
            dAOFactory = new DAOFactory();
        }
        return dAOFactory;
    }

    public <T extends SuperDAO> T getDAO(DAOFactory.DAOTypes daoType){
        switch (daoType){
            case MEMBER:
                return (T)new MemberDAOImpl();
            case PACKAGE:
                return (T)new PackageDAOImpl();
            case PAYMENT:
                return (T)new PaymentDAOImpl();
            case INSTRUCTOR:
                return (T)new InstructorDAOImpl();
            case SCHEDULE:
                return (T)new ScheduleDAOImpl();
            case ITEM:
                return (T)new ItemDAOImpl();
            case PRODUCT:
                return (T)new ProductBOImpl();
            case PACKAGEDETAILS:
                return (T)new PackageDetailDAOImpl();
            case ATTENDANCE:
                return (T)new AttendanceDAOImpl();
            default:
                return null;
        }
    }

    public static enum  DAOTypes {
        MEMBER,
        PACKAGE,
        PAYMENT,
        INSTRUCTOR,
        SCHEDULE,
        ITEM,
        PRODUCT,
        PACKAGEDETAILS,
        ATTENDANCE;

    }
}
