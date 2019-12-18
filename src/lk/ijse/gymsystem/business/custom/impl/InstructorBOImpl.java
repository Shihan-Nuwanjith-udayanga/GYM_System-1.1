package lk.ijse.gymsystem.business.custom.impl;

import lk.ijse.gymsystem.business.custom.InstructorBO;
import lk.ijse.gymsystem.dao.DAOFactory;
import lk.ijse.gymsystem.dao.custom.InstructorDAO;
import lk.ijse.gymsystem.dao.custom.impl.InstructorDAOImpl;
import lk.ijse.gymsystem.dto.InstructorDTO;
import lk.ijse.gymsystem.entity.Instructor;
import lk.ijse.gymsystem.entity.Package;

import java.util.ArrayList;

public class InstructorBOImpl implements InstructorBO {

    private InstructorDAO instructorDAO = new InstructorDAOImpl();

    public InstructorBOImpl(){
        this.instructorDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.INSTRUCTOR);
    }


    @Override
    public boolean addInstructor(InstructorDTO instructorDTO) throws Exception {
        return instructorDAO.save(new Instructor(
                instructorDTO.getInstructor_id(),
                instructorDTO.getInstructor_name(),
                instructorDTO.getAddress(),
                instructorDTO.getContact_no(),
                instructorDTO.getE_mail(),
                instructorDTO.getGender(),
                instructorDTO.getDate_of_birth(),
                instructorDTO.getAge(),
                instructorDTO.getDate_of_join(),
                instructorDTO.getSalary(),
                instructorDTO.getHeight(),
                instructorDTO.getWeight()
        ));
    }

    @Override
    public boolean updateInstructor(InstructorDTO instructorDTO) throws Exception {
        return instructorDAO.update(new Instructor(
                instructorDTO.getInstructor_id(),
                instructorDTO.getInstructor_name(),
                instructorDTO.getAddress(),
                instructorDTO.getContact_no(),
                instructorDTO.getE_mail(),
                instructorDTO.getGender(),
                instructorDTO.getDate_of_birth(),
                instructorDTO.getAge(),
                instructorDTO.getDate_of_join(),
                instructorDTO.getSalary(),
                instructorDTO.getHeight(),
                instructorDTO.getWeight()
        ));
    }

    @Override
    public boolean deleteInstructor(String id) throws Exception {
        return instructorDAO.delete(id);
    }

    @Override
    public InstructorDTO searchInstructor(String id) throws Exception {
        Instructor instructor = instructorDAO.search(id);
        if (instructor == null){
            return null;
        }else {
            return new InstructorDTO(
                    instructor.getInstructor_id(),
                    instructor.getInstructor_name(),
                    instructor.getAddress(),
                    instructor.getContact_no(),
                    instructor.getE_mail(),
                    instructor.getGender(),
                    instructor.getDate_of_birth(),
                    instructor.getAge(),
                    instructor.getDate_of_join(),
                    instructor.getSalary(),
                    instructor.getHeight(),
                    instructor.getWeight());
        }
    }

    @Override
    public ArrayList<InstructorDTO> getAll() throws Exception {
        ArrayList<Instructor> allpack = instructorDAO.getAll();
        ArrayList<InstructorDTO> pack = new ArrayList<>();
        for (Instructor instructor : allpack){
            pack.add(new InstructorDTO(
                    instructor.getInstructor_id(),
                    instructor.getInstructor_name(),
                    instructor.getAddress(),
                    instructor.getContact_no(),
                    instructor.getE_mail(),
                    instructor.getGender(),
                    instructor.getDate_of_birth(),
                    instructor.getAge(),
                    instructor.getDate_of_join(),
                    instructor.getSalary(),
                    instructor.getHeight(),
                    instructor.getWeight()
            ));
        }
        return pack;
    }
}
