import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

/**
 * Created by eniakel on 24/07/2015.
 */
public class Main {
    public static void main (String args[]) {
        Main m = new Main();
        Enrolled enrolled = m.setEnrolledStudents();
        m.testFeatures(enrolled);
    }

    public Enrolled setEnrolledStudents() {
        Student s = new Student("Niall", 30000, 31);
        Student s2 = new Student("Aileen", 35000, 20);
        Student s3 = new Student("Alan", 40000, 27);
        Student s4 = new Student("Laura", 45000, 33);

        Enrolled enrolled = new Enrolled();
        enrolled.addStudent(s);
        enrolled.addStudent(s2);
        enrolled.addStudent(s3);
        enrolled.addStudent(s4);

        return enrolled;
    }

    public void testFeatures(Enrolled e) {
        //Print all students
        List<Student> students =  e.getStudents();
        students.forEach((s) -> System.out.println(s.getName()));
        System.out.println("");

        //Filter List by age>25
        students.stream()
                .filter((s) -> s.getAge()>25)
                .limit(2)
                .forEach((s) -> System.out.println(s.getName()));
        System.out.println("");


        //Filer by age and salary
        Predicate<Student> salaryFilter = (s)->(s.getSalary()>33000);
        students.stream()
                .filter((s) -> s.getAge() > 25)
                .filter(salaryFilter)
                .forEach((s) -> System.out.println(s.getName()));
        System.out.println("");


        //Sort alphabetically
        List<Student> sortedByName = students.stream()
                                        .sorted((s, s2)->s.getName().compareTo(s2.getName()))
                                        .collect(toList());
        sortedByName.forEach((s) -> System.out.println(s.getName()));
        System.out.println("");

        //Print string with first character from each string
        List<String> strings = Arrays.asList("Hellod", "World", "Howd", "Are", "You");
        StringBuilder sb = new StringBuilder();
        strings.stream().forEach((s) -> sb.append(s.charAt(0)));
        System.out.println(sb);
        System.out.println("");

        //Print words with even number of characters
        strings.stream()
                .filter((s) -> s.length()%2==0)
                .forEach((s) -> System.out.println(s));
        System.out.println("");

        //Print in uppercase
        strings.stream()
                .map(String::toUpperCase)
                .forEach((s) -> System.out.println(s));
        strings.replaceAll(String::toUpperCase);
        System.out.println("");

        //Create map of key value pair and print each one
        Map<String, Integer> studentMap = new HashMap();
        studentMap.put(students.get(0).getName(), students.get(0).getAge());
        studentMap.put(students.get(1).getName(), students.get(1).getAge());
        studentMap.put(students.get(2).getName(), students.get(2).getAge());
        studentMap.put(students.get(3).getName(), students.get(3).getAge());

        studentMap.forEach((k, v) -> {
            System.out.println("Key: " + k + ", Value: " + v + "\n");
        });
    }
}
