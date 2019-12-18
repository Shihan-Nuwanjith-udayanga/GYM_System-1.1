package lk.ijse.gymsystem.business.custom.impl;

import lk.ijse.gymsystem.business.custom.PackageBO;
import lk.ijse.gymsystem.dao.DAOFactory;
import lk.ijse.gymsystem.dao.custom.PackageDAO;
import lk.ijse.gymsystem.dao.custom.impl.PackageDAOImpl;
import lk.ijse.gymsystem.dto.PackageDTO;
import lk.ijse.gymsystem.entity.Package;

import java.util.ArrayList;

public class PackageBOImpl implements PackageBO {

    private PackageDAO packageDAO = new PackageDAOImpl();

    public PackageBOImpl(){
        this.packageDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PACKAGE);

    }

    @Override
    public boolean addPackage(PackageDTO packageDTO) throws Exception {
        return packageDAO.save(new Package(
                packageDTO.getPackage_id(),
                packageDTO.getPackage_name(),
                packageDTO.getDuration(),
                packageDTO.getAmount(),
                packageDTO.getDiscount(),
                packageDTO.getDiscount_amount(),
                packageDTO.getNew_amount()
        ));
    }

    @Override
    public boolean updatePackage(PackageDTO packageDTO) throws Exception {
        return packageDAO.update(new Package(
                packageDTO.getPackage_id(),
                packageDTO.getPackage_name(),
                packageDTO.getDuration(),
                packageDTO.getAmount(),
                packageDTO.getDiscount(),
                packageDTO.getDiscount_amount(),
                packageDTO.getNew_amount()
        ));
    }

    @Override
    public boolean deletePackage(String id) throws Exception {
        return packageDAO.delete(id);
    }

    @Override
    public PackageDTO searchPackage(String id) throws Exception {
        Package packages = packageDAO.search(id);
        if (packages == null){
            return null;
        }else {
            return new PackageDTO(
                    packages.getPackage_id(),
                    packages.getPackage_name(),
                    packages.getDuration(),
                    packages.getAmount(),
                    packages.getDiscount(),
                    packages.getDiscount_amount(),
                    packages.getNew_amount()
            );
        }
    }

    @Override
    public ArrayList<PackageDTO> getAll() throws Exception {
        ArrayList<Package> allpack = packageDAO.getAll();
        ArrayList<PackageDTO> pack = new ArrayList<>();
        for (Package aPackage:allpack){
            pack.add(new PackageDTO(
                    aPackage.getPackage_id(),
                    aPackage.getPackage_name(),
                    aPackage.getDuration(),
                    aPackage.getAmount(),
                    aPackage.getDiscount(),
                    aPackage.getDiscount_amount(),
                    aPackage.getNew_amount()
            ));
        }
        return pack;
    }
}
