package lk.ijse.gymsystem.dto;

public class ScheduleDetailsDTO {
    private String schedule_id;
    private String member_id;
    private String member_name;
    private String date;
    private String no;
    private String exercise;
    private String frequency;

    public ScheduleDetailsDTO() {
    }

    public ScheduleDetailsDTO(String schedule_id, String member_id, String member_name, String date, String no, String exercise, String frequency) {
        this.schedule_id = schedule_id;
        this.member_id = member_id;
        this.member_name = member_name;
        this.date = date;
        this.no = no;
        this.exercise = exercise;
        this.frequency = frequency;
    }

    public String getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(String schedule_id) {
        this.schedule_id = schedule_id;
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

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "ScheduleDetailsDTO{" +
                "schedule_id='" + schedule_id + '\'' +
                ", member_id='" + member_id + '\'' +
                ", member_name='" + member_name + '\'' +
                ", date='" + date + '\'' +
                ", no='" + no + '\'' +
                ", exercise='" + exercise + '\'' +
                ", frequency='" + frequency + '\'' +
                '}';
    }
}
