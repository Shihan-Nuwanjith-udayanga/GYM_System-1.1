package lk.ijse.gymsystem.dto;

public class ProductDTO {
    private String product_id;
    private String product_name;
    private String category;
    private String features;
    private double price;
    private double discount;
    private double discount_Price;
    private double new_price;

    public ProductDTO() {
    }

    public ProductDTO(String product_id, String product_name, String category, String features, double price, double discount, double discount_Price, double new_price) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.category = category;
        this.features = features;
        this.price = price;
        this.discount = discount;
        this.discount_Price = discount_Price;
        this.new_price = new_price;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getDiscount_Price() {
        return discount_Price;
    }

    public void setDiscount_Price(double discount_Price) {
        this.discount_Price = discount_Price;
    }

    public double getNew_price() {
        return new_price;
    }

    public void setNew_price(double new_price) {
        this.new_price = new_price;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "product_id='" + product_id + '\'' +
                ", product_name='" + product_name + '\'' +
                ", category='" + category + '\'' +
                ", features='" + features + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", discount_Price=" + discount_Price +
                ", new_price=" + new_price +
                '}';
    }
}
