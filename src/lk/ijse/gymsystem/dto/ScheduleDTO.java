package lk.ijse.gymsystem.dto;

public class ScheduleDTO {
    private String schedule_id;
    private String instructor_id;
    private String instructor_name;

    public ScheduleDTO() {
    }

    public ScheduleDTO(String schedule_id, String instructor_id, String instructor_name) {
        this.schedule_id = schedule_id;
        this.instructor_id = instructor_id;
        this.instructor_name = instructor_name;
    }

    public String getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(String schedule_id) {
        this.schedule_id = schedule_id;
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

    @Override
    public String toString() {
        return "ScheduleDTO{" +
                "schedule_id='" + schedule_id + '\'' +
                ", instructor_id='" + instructor_id + '\'' +
                ", instructor_name='" + instructor_name + '\'' +
                '}';
    }
}
