package lk.ijse.gymsystem.business.custom;

import lk.ijse.gymsystem.business.SuperBO;
import lk.ijse.gymsystem.dto.ItemDTO;

import java.util.ArrayList;

public interface ItemBO extends SuperBO {

    boolean addItem(ItemDTO itemDTO)throws Exception;

    boolean updateItem(ItemDTO itemDTO)throws Exception;

    boolean deleteItem(String id)throws Exception;

    ItemDTO searchItem(String id)throws Exception;

    ArrayList<ItemDTO> getAll() throws Exception;
}
