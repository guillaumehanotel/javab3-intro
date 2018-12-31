package exercices.classdynamics;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ClassDynamics {

    private List<Student> students;

    public ClassDynamics(List<Student> students) {
        this.students = students;
    }


    public String bestProgression() {
        return this.students.stream()
                .filter(this::hasBestProgression)
                .max(Comparator.comparingDouble(s -> s.getThirdAvg() - s.getFirstAvg()))
                .map(Student::getName)
                .get();
    }


    private boolean hasBestProgression(Student student) {
        return student.getThirdAvg() > student.getSecondAvg() &&
                student.getSecondAvg() > student.getFirstAvg();
    }


    public String[] topThree() {
        return this.students.stream()
                .sorted(Comparator.comparing(Student::getYearAvg).reversed())
                .limit(3)
                .map(Student::getName)
                .toArray(String[]::new);
    }

    public double[] statSummary() {

        double[] year_avgs = this.students.stream()
                .map(Student::getYearAvg)
                .sorted()
                .mapToDouble(Double::doubleValue)
                .toArray();

        int total = students.size();

        int first_quartil = (int)Math.ceil(total / 4);
        int median = (int)Math.ceil(total / 2);
        int third_quartil = first_quartil * 3;

        return new double[]{
                year_avgs[first_quartil],
                year_avgs[median],
                year_avgs[third_quartil]
        };
    }
}
