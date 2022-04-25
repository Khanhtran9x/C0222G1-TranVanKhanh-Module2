package _22_structural_design_pattern.exercise.facade_pattern;


public class RandomNumber {
    public int generateInteger(int min, int max){
        double randomDouble = Math.random();
        int randomInteger =  (int) (randomDouble * (max - min + 1) + min);
        return randomInteger;
    }
}