import com.google.common.collect.Lists;
import java.util.List;

/**
 * Created by eniakel on 24/07/2015.
 */
public class Enrolled {
    List<Student> students = Lists.newArrayList();

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student s) {
        this.students.add(s);
    }

}
