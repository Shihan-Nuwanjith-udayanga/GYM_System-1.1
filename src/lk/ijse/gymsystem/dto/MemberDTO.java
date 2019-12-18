package lk.ijse.gymsystem.dto;


public class MemberDTO  {
    private String member_id;
    private String member_name;
    private String address;
    private int contact_no;
    private String e_mail;
    private String gender;
    private String date_of_birth;
    private int age;
    private String package_id;
    private String date_of_join;
    private String date_of_end;
    private String height;
    private String weight;

    public MemberDTO() {
    }

    public MemberDTO(String member_id, String member_name, String address, int contact_no, String e_mail, String gender, String date_of_birth, int age, String package_id, String date_of_join, String date_of_end, String height, String weight) {
        this.member_id = member_id;
        this.member_name = member_name;
        this.address = address;
        this.contact_no = contact_no;
        this.e_mail = e_mail;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
        this.age = age;
        this.package_id = package_id;
        this.date_of_join = date_of_join;
        this.date_of_end = date_of_end;
        this.height = height;
        this.weight = weight;
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

    public String getPackage_id() {
        return package_id;
    }

    public void setPackage_id(String package_id) {
        this.package_id = package_id;
    }

    public String getDate_of_join() {
        return date_of_join;
    }

    public void setDate_of_join(String date_of_join) {
        this.date_of_join = date_of_join;
    }

    public String getDate_of_end() {
        return date_of_end;
    }

    public void setDate_of_end(String date_of_end) {
        this.date_of_end = date_of_end;
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
        return "MemberDTO{" +
                "member_id='" + member_id + '\'' +
                ", member_name='" + member_name + '\'' +
                ", address='" + address + '\'' +
                ", contact_no=" + contact_no +
                ", e_mail='" + e_mail + '\'' +
                ", gender='" + gender + '\'' +
                ", date_of_birth='" + date_of_birth + '\'' +
                ", age=" + age +
                ", package_id='" + package_id + '\'' +
                ", date_of_join='" + date_of_join + '\'' +
                ", date_of_end='" + date_of_end + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }
}
