package lk.ijse.gymsystem.business.custom.impl;

import lk.ijse.gymsystem.business.custom.ProductBO;
import lk.ijse.gymsystem.dao.DAOFactory;
import lk.ijse.gymsystem.dao.custom.ProductDAO;
import lk.ijse.gymsystem.dao.custom.impl.ProductDAOImpl;
import lk.ijse.gymsystem.dto.ProductDTO;
import lk.ijse.gymsystem.entity.Product;

import java.util.ArrayList;

public class ProductBOImpl implements ProductBO {


    private ProductDAO productDAO = new ProductDAOImpl();

    public ProductBOImpl(){
//        this.productDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PRODUCT);
    }

    @Override
    public boolean addProduct(ProductDTO productDTO) throws Exception {
        return productDAO.save(new Product(
                productDTO.getProduct_id(),
                productDTO.getProduct_name(),
                productDTO.getCategory(),
                productDTO.getFeatures(),
                productDTO.getPrice(),
                productDTO.getDiscount(),
                productDTO.getDiscount_Price(),
                productDTO.getNew_price()
        ));
    }

    @Override
    public boolean updateProduct(ProductDTO productDTO) throws Exception {
        return productDAO.update(new Product(
                productDTO.getProduct_id(),
                productDTO.getProduct_name(),
                productDTO.getCategory(),
                productDTO.getFeatures(),
                productDTO.getPrice(),
                productDTO.getDiscount(),
                productDTO.getDiscount_Price(),
                productDTO.getNew_price()
        ));
    }

    @Override
    public boolean deleteProduct(String id) throws Exception {
        return productDAO.delete(id);
    }

    @Override
    public ProductDTO searchProduct(String id) throws Exception {
        Product product=productDAO.search(id);
        if (product == null){
            return null;
        }else {
            return new ProductDTO(
                    product.getProduct_id(),
                    product.getProduct_name(),
                    product.getCategory(),
                    product.getFeatures(),
                    product.getPrice(),
                    product.getDiscount(),
                    product.getDiscount_price(),
                    product.getNew_price());
        }
    }

    @Override
    public ArrayList<ProductDTO> getAll() throws Exception {
        ArrayList<Product>allpack = productDAO.getAll();
        ArrayList<ProductDTO>pack = new ArrayList<>();
        for (Product product : allpack){
            pack.add(new ProductDTO(
                    product.getProduct_id(),
                    product.getProduct_name(),
                    product.getCategory(),
                    product.getFeatures(),
                    product.getPrice(),
                    product.getDiscount(),
                    product.getDiscount_price(),
                    product.getNew_price()
            ));
        }
        return pack;
    }
}
