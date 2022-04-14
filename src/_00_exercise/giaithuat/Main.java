package _00_exercise.giaithuat;

public class Main {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 5};
        System.out.println(solution(a));

    }

    public static boolean solution(int[] a) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 1; i < a.length - 1; i++) {
            for (int j = 0; j < a.length; j++) {
                if (j < i) {
                    sum1 += a[j];
                } else {
                    sum2 += a[j];
                }
            }
           if (sum1 == sum2){
               return true;
           }
        }
        return false;
    }
}
//    boolean solution(int[] a) {
//        for(int i = 1; i < a.length - 1; i++){
//            int l = 0;
//            int r = 0;
//            for (int j = 0; j < i; j++) {
//                l += a[j];
//            }
//            for (int j = a.length - 1; j > i; j--) {
//                r += a[j];
//            }
//            if (l == r){
//                return true;
//            }
//        }
//        return false;
//    }

