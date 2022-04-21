package _21_design_patterns.practice.object_pool;

public class TaxiNotFoundException extends Throwable {
    public TaxiNotFoundException(String message) {
        System.out.println(message);
    }
}
