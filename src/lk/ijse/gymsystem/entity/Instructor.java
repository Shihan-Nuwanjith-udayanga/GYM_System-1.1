package lk.ijse.gymsystem.entity;

public class Instructor {
    private String instructor_id;
    private String instructor_name;
    private String address;
    private int contact_no;
    private String e_mail;
    private String gender;
    private String date_of_birth;
    private int age;
    private String date_of_join;
    private double salary;
    private String height;
    private String weight;

    public Instructor() {
    }

    public Instructor(String instructor_id, String instructor_name, String address, int contact_no, String e_mail, String gender, String date_of_birth, int age, String date_of_join, double salary, String height, String weight) {
        this.instructor_id = instructor_id;
        this.instructor_name = instructor_name;
        this.address = address;
        this.contact_no = contact_no;
        this.e_mail = e_mail;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
        this.age = age;
        this.date_of_join = date_of_join;
        this.salary = salary;
        this.height = height;
        this.weight = weight;
    }

    public String getInstructor_id() {
        return instructor_id;
    }

    public void setInstructor_id(String instructor_id) {
        this.instructor_id = instructor_id;
    }

    public String getInstructor_name() {
        return instructor_name;
    }

    public void setInstructor_name(String instructor_name) {
        this.instructor_name = instructor_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getContact_no() {
        return contact_no;
    }

    public void setContact_no(int contact_no) {
        this.contact_no = contact_no;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDate_of_join() {
        return date_of_join;
    }

    public void setDate_of_join(String date_of_join) {
        this.date_of_join = date_of_join;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "instructor_id='" + instructor_id + '\'' +
                ", instructor_name='" + instructor_name + '\'' +
                ", address='" + address + '\'' +
                ", contact_no=" + contact_no +
                ", e_mail='" + e_mail + '\'' +
                ", gender='" + gender + '\'' +
                ", date_of_birth='" + date_of_birth + '\'' +
                ", age=" + age +
                ", date_of_join='" + date_of_join + '\'' +
                ", salary=" + salary +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }
}
