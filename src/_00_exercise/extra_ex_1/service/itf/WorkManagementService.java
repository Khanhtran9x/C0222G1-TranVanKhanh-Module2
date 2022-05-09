package _00_exercise.extra_ex_1.service.itf;

public interface WorkManagementService extends Service{
    @Override
    void display();

    void displayByDayOfWeek();

    @Override
    void addNew();

    @Override
    void edit();

    @Override
    void remove();
}
