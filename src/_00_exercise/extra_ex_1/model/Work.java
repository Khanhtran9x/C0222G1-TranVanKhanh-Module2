package _00_exercise.extra_ex_1.model;

public class Work {
    private String workCode;
    private String workName;
    private String dayOfWeek;
    private String priority;

    public Work(String workCode, String workName, String dayOfWeek, String priority) {
        this.workCode = workCode;
        this.workName = workName;
        this.dayOfWeek = dayOfWeek;
        this.priority = priority;
    }

    public Work(String[] strArr) {
        this.workCode = strArr[0];
        this.workName = strArr[1];
        this.dayOfWeek = strArr[2];
        this.priority = strArr[3];
    }

    public String getWorkCode() {
        return workCode;
    }

    public void setWorkCode(String workCode) {
        this.workCode = workCode;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return  workCode + ',' +
                workName + ',' +
                dayOfWeek + ',' +
                priority;
    }

    public String getInfo(){
        return  "WORK \n" +
                "Work Code: " + workCode + '\n' +
                "Work Name: " + workName + '\n' +
                "Work Day: " + dayOfWeek + '\n' +
                "Work Priority: " + priority + '\n';
    }
}
