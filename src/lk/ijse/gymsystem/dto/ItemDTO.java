package lk.ijse.gymsystem.dto;

public class ItemDTO {
    private String item_id;
    private String item_name;
    private String brand;
    private double bought_price;
    private String bought_date;
    private String description;

    public ItemDTO() {
    }

    public ItemDTO(String item_id, String item_name, String brand, double bought_price, String bought_date, String description) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.brand = brand;
        this.bought_price = bought_price;
        this.bought_date = bought_date;
        this.description = description;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getBought_price() {
        return bought_price;
    }

    public void setBought_price(double bought_price) {
        this.bought_price = bought_price;
    }

    public String getBought_date() {
        return bought_date;
    }

    public void setBought_date(String bought_date) {
        this.bought_date = bought_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "item_id='" + item_id + '\'' +
                ", item_name='" + item_name + '\'' +
                ", brand='" + brand + '\'' +
                ", bought_price=" + bought_price +
                ", bought_date='" + bought_date + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
