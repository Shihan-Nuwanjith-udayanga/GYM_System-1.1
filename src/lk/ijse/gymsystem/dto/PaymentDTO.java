package lk.ijse.gymsystem.dto;

public class PaymentDTO {
    private String payment_id;
    private String member_id;
    private String member_name;
    private String package_id;
    private String package_name;
    private String duration;
    private String date;
    private String payment_method;
    private double amount;
    private double cash;
    private double balance;
    private String description;

    public PaymentDTO() {
    }

    public PaymentDTO(String payment_id, String member_id, String member_name, String package_id, String package_name, String duration, String date, String payment_method, double amount, double cash, double balance, String description) {
        this.payment_id = payment_id;
        this.member_id = member_id;
        this.member_name = member_name;
        this.package_id = package_id;
        this.package_name = package_name;
        this.duration = duration;
        this.date = date;
        this.payment_method = payment_method;
        this.amount = amount;
        this.cash = cash;
        this.balance = balance;
        this.description = description;
    }

    public String getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(String payment_id) {
        this.payment_id = payment_id;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "payment_id='" + payment_id + '\'' +
                ", member_id='" + member_id + '\'' +
                ", member_name='" + member_name + '\'' +
                ", package_id='" + package_id + '\'' +
                ", package_name='" + package_name + '\'' +
                ", duration='" + duration + '\'' +
                ", date='" + date + '\'' +
                ", payment_method='" + payment_method + '\'' +
                ", amount=" + amount +
                ", cash=" + cash +
                ", balance=" + balance +
                ", description='" + description + '\'' +
                '}';
    }
}
