package lk.ijse.gymsystem.business;

import lk.ijse.gymsystem.business.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){
    }

    public static BOFactory getInstance(){
        if (boFactory == null){
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public <T extends SuperBO> T getBO(BOFactory.BOTypes boTypes){
        switch (boTypes){
            case MEMBER:
                return (T) new MemberBOImpl();
            case PACKAGE:
                return (T)new PackageBOImpl();
            case PAYMENT:
                return (T)new PaymentBOImpl();
            case INSTRUCTOR:
                return (T)new InstructorBOImpl();
            case SCHEDULE:
                return (T)new ScheduleBOImpl();
            case ITEM:
                return (T)new ItemBOImpl();
            case PRODUCT:
                return (T)new ProductBOImpl();
            case PACKAGEDETAILS:
                return (T)new PackageDetailBOImpl();
            case ATTENDANCE:
                return (T)new AttendanceBOImpl();
            default:
                return null;
        }
    }

    public static enum  BOTypes {
        MEMBER,
        PACKAGE,
        PAYMENT,
        INSTRUCTOR,
        SCHEDULE,
        ITEM,
        PACKAGEDETAILS,
        PRODUCT,
        ATTENDANCE;
    }
}

