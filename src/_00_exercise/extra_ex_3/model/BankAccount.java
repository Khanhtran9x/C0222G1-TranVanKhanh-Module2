package _00_exercise.extra_ex_3.model;

public abstract class BankAccount {
    private String id;
    private String code;
    private String name;
    private String creationDate;

    public BankAccount(String id, String code, String name, String creationDate) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.creationDate = creationDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public abstract String toString();
}
