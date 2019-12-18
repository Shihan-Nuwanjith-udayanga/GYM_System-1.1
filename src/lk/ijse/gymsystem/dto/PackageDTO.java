package lk.ijse.gymsystem.dto;

public class PackageDTO {
    private String package_id;
    private String package_name;
    private String duration;
    private double amount;
    private double discount;
    private double discount_amount;
    private double new_amount;

    public PackageDTO() {
    }

    public PackageDTO(String package_id, String package_name, String duration, double amount, double discount, double discount_amount, double new_amount) {
        this.package_id = package_id;
        this.package_name = package_name;
        this.duration = duration;
        this.amount = amount;
        this.discount = discount;
        this.discount_amount = discount_amount;
        this.new_amount = new_amount;
    }

    public String getPackage_id() {
        return package_id;
    }

    public void setPackage_id(String package_id) {
        this.package_id = package_id;
    }

    public String getPackage_name() {
        return package_name;
    }

    public void setPackage_name(String package_name) {
        this.package_name = package_name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getDiscount_amount() {
        return discount_amount;
    }

    public void setDiscount_amount(double discount_amount) {
        this.discount_amount = discount_amount;
    }

    public double getNew_amount() {
        return new_amount;
    }

    public void setNew_amount(double new_amount) {
        this.new_amount = new_amount;
    }

    @Override
    public String toString() {
        return "PackageDTO{" +
                "package_id='" + package_id + '\'' +
                ", package_name='" + package_name + '\'' +
                ", duration='" + duration + '\'' +
                ", amount=" + amount +
                ", discount=" + discount +
                ", discount_amount=" + discount_amount +
                ", new_amount=" + new_amount +
                '}';
    }

}
