package excercises.classdynamics;

import exercices.classdynamics.ClassDynamics;
import exercices.classdynamics.Student;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertArrayEquals;



// JUnit will execute test methods in the alphabetical order of their names
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClassDynamicsTest {

    private static final String LIGNE_1 = "Axelle,18.01,10.01,16.5";
    private static final String LIGNE_2 = "Camille,16.14,13.06,7.01";
    private static final String LIGNE_3 = "Charles,8.68,11.97,5.67";
    private static final String LIGNE_4 = "Etienne,13.88,18.32,8.53";
    private static final String LIGNE_5 = "Fanny,13.82,11.14,16.11";
    private static final String LIGNE_6 = "Gregoire,9.22,15.01,16.95";
    private static final String LIGNE_7 = "Jane,12.45,5.31,11.89";
    private static final String LIGNE_8 = "Jean,14.01,9.24,6.17";
    private static final String LIGNE_9 = "Julie,9.98,17.54,5.45";
    private static final String LIGNE_10 = "Lisa,18.52,14.71,8.94";
    private static final String LIGNE_11 = "Louis,14.98,14.64,8.65";
    private static final String LIGNE_12 = "Louise,9.47,7.84,10.17";
    private static final String LIGNE_13 = "Malaurie,12.94,7.82,15.31";
    private static final String LIGNE_14 = "Marc,14.44,16.71,17.7";
    private static final String LIGNE_15 = "Mathurin,9.08,9.25,6.85";
    private static final String LIGNE_16 = "Paul,13.35,9.87,10.91";
    private static final String LIGNE_17 = "Pierre,7.72,15.35,9.22";
    private static final String LIGNE_18 = "Quentin,9.42,10.06,5.65";
    private static final String LIGNE_19 = "Thomas,5.15,14.15,15.16";
    private static final String LIGNE_20 = "Victoire,5.27,12.25,10.90";
    private static final String LIGNE_21 = "Vincent,9.59,16.98,18.68";

    private List<String> contenu = Arrays.asList(LIGNE_1, LIGNE_2, LIGNE_3, LIGNE_4, LIGNE_5, LIGNE_6, LIGNE_7, LIGNE_8, LIGNE_9, LIGNE_10, LIGNE_11, LIGNE_12, LIGNE_13, LIGNE_14, LIGNE_15, LIGNE_16, LIGNE_17, LIGNE_18, LIGNE_19, LIGNE_20, LIGNE_21);

    private List<Student> createStudents(List<String> contenu) {

        List<String[]> contenuList = contenu.stream()
                .map(s -> s.split(","))
                .collect(Collectors.toList());

        return contenuList.stream()
                .map(s -> new Student(s[0], Double.parseDouble(s[1]), Double.parseDouble(s[2]), Double.parseDouble(s[3])))
                .collect(Collectors.toList());
    }

    @Test
    public void aProgression() {
        ClassDynamics solution = new ClassDynamics(createStudents(contenu));
        assertThat(solution.bestProgression()).isEqualTo("Thomas");
    }

    @Test
    public void aTopThree() {
        String[] expected = {"Marc", "Vincent", "Axelle"};
        ClassDynamics solution = new ClassDynamics(createStudents(contenu));
        assertArrayEquals("The students must be sorted from first to third.\nError", expected, solution.topThree());
    }

    @Test
    public void theStatSummary() {
        double[] expected = {9.80, 11.48, 13.69};
        ClassDynamics solution = new ClassDynamics(createStudents(contenu));
        assertArrayEquals("The array must be sorted like {Q1, Med, Q3}. A 0.05 delta is tolerated.\nError", expected, solution.statSummary(), 0.05);
    }
}