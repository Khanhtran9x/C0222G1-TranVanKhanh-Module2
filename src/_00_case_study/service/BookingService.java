package _00_case_study.service;

public interface BookingService extends Service{
    @Override
    void display();

    @Override
    void addNew();

    @Override
    void edit();

    @Override
    void remove();
}
