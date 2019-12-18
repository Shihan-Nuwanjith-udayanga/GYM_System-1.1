package lk.ijse.gymsystem.business.custom.impl;

import lk.ijse.gymsystem.business.custom.ItemBO;
import lk.ijse.gymsystem.dao.DAOFactory;
import lk.ijse.gymsystem.dao.custom.ItemDAO;
import lk.ijse.gymsystem.dao.custom.impl.ItemDAOImpl;
import lk.ijse.gymsystem.dto.ItemDTO;
import lk.ijse.gymsystem.entity.Item;

import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {

    private ItemDAO itemDAO = new ItemDAOImpl();

    public ItemBOImpl(){
        this.itemDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);
    }

    @Override
    public boolean addItem(ItemDTO itemDTO) throws Exception {
        return itemDAO.save(new Item(
                itemDTO.getItem_id(),
                itemDTO.getItem_name(),
                itemDTO.getBrand(),
                itemDTO.getBought_price(),
                itemDTO.getBought_date(),
                itemDTO.getDescription()
        ));
    }

    @Override
    public boolean updateItem(ItemDTO itemDTO) throws Exception {
        return itemDAO.update(new Item(
                itemDTO.getItem_id(),
                itemDTO.getItem_name(),
                itemDTO.getBrand(),
                itemDTO.getBought_price(),
                itemDTO.getBought_date(),
                itemDTO.getDescription()
        ));
    }

    @Override
    public boolean deleteItem(String id) throws Exception {
        return itemDAO.delete(id);
    }

    @Override
    public ItemDTO searchItem(String id) throws Exception {
        Item item = itemDAO.search(id);
        if (item == null){
            return null;
        }else {
            return new ItemDTO(
                    item.getItem_id(),
                    item.getItem_name(),
                    item.getBrand(),
                    item.getBought_price(),
                    item.getBought_date(),
                    item.getDescription()
            );
        }
    }

    @Override
    public ArrayList<ItemDTO> getAll() throws Exception {
        ArrayList<Item> allpack = itemDAO.getAll();
        ArrayList<ItemDTO>pack = new ArrayList<>();
        for (Item item: allpack){
            pack.add(new ItemDTO(
                    item.getItem_id(),
                    item.getItem_name(),
                    item.getBrand(),
                    item.getBought_price(),
                    item.getBought_date(),
                    item.getDescription()
            ));
        }
        return pack;
    }
}
