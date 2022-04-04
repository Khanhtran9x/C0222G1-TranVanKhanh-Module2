package _05_access_modifier_static.pratice.build_class;

public class Student {
    private String name = "John";
    private String classes = "C02";
    public Student(){
    }

    void setName(String name) {
        this.name = name;
    }

    protected void setClasses(String classes) {
        this.classes = classes;
    }

    public String getName() {
        return name;
    }

    public String getClasses() {
        return classes;
    }
}
