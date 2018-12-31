package exercices.classdynamics;

public class Student {

    private String name;
    private double firstAvg;
    private double secondAvg;
    private double thirdAvg;

    public String getName() {
        return name;
    }

    public double getFirstAvg() {
        return firstAvg;
    }

    public double getSecondAvg() {
        return secondAvg;
    }

    public double getThirdAvg() {
        return thirdAvg;
    }

    public Student() {

    }

    public Student(String name, double firstAvg, double secondAvg, double thirdAvg) {
        this.name = name;
        this.firstAvg = firstAvg;
        this.secondAvg = secondAvg;
        this.thirdAvg = thirdAvg;
    }

    public double getYearAvg() {
        return (firstAvg + secondAvg + thirdAvg) / 3;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", firstAvg=" + firstAvg +
                ", secondAvg=" + secondAvg +
                ", thirdAvg=" + thirdAvg +
                '}';
    }
}

