package lk.ijse.gymsystem.business.custom;

import lk.ijse.gymsystem.business.SuperBO;
import lk.ijse.gymsystem.dto.ProductDTO;

import java.util.ArrayList;

public interface ProductBO extends SuperBO {

    boolean addProduct(ProductDTO productDTO)throws Exception;

    boolean updateProduct(ProductDTO productDTO)throws Exception;

    boolean deleteProduct(String id)throws Exception;

    ProductDTO searchProduct(String id)throws Exception;

    ArrayList<ProductDTO>getAll()throws Exception;
}
