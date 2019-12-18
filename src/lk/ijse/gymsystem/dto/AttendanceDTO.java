package lk.ijse.gymsystem.dto;

public class AttendanceDTO {
    private String member_id;
    private String member_name;
    private String date;
    private String arrival_time;
    private String departure_time;

    public AttendanceDTO() {
    }

    public AttendanceDTO(String member_id, String member_name, String date, String arrival_time, String departure_time) {
        this.member_id = member_id;
        this.member_name = member_name;
        this.date = date;
        this.arrival_time = arrival_time;
        this.departure_time = departure_time;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    @Override
    public String toString() {
        return "AttendanceDTO{" +
                "member_id='" + member_id + '\'' +
                ", member_name='" + member_name + '\'' +
                ", date='" + date + '\'' +
                ", arrival_time='" + arrival_time + '\'' +
                ", departure_time='" + departure_time + '\'' +
                '}';
    }
}
