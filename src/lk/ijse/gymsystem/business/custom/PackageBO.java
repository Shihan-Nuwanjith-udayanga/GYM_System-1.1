package lk.ijse.gymsystem.business.custom;

import lk.ijse.gymsystem.business.SuperBO;
import lk.ijse.gymsystem.dto.PackageDTO;
import lk.ijse.gymsystem.entity.Package;

import java.util.ArrayList;

public interface PackageBO extends SuperBO {

    boolean addPackage (PackageDTO packageDTO)throws Exception;

    boolean updatePackage (PackageDTO packageDTO)throws Exception;

    boolean deletePackage(String id)throws Exception;

    PackageDTO searchPackage(String id)throws Exception;

    ArrayList<PackageDTO> getAll()throws Exception;
}
