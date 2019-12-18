package lk.ijse.gymsystem.business.custom;

import lk.ijse.gymsystem.business.SuperBO;
import lk.ijse.gymsystem.dto.InstructorDTO;


import java.util.ArrayList;

public interface InstructorBO extends SuperBO {

    boolean addInstructor(InstructorDTO instructorDTO)throws Exception;

    boolean updateInstructor(InstructorDTO instructorDTO)throws Exception;

    boolean deleteInstructor(String id)throws Exception;

    InstructorDTO searchInstructor (String id)throws Exception;

    ArrayList<InstructorDTO> getAll() throws Exception;
}
