package task1.util;

import task1.student.Faculty;
import task1.student.Student;

import java.util.List;
import java.util.Map;

public interface StudentRealization {

    public List<Student> listStudentFaculty(String initFaculty);

    public Map<Faculty, Map<Long, List<Student>>> groupingListFacultyAndCourses();

    public List<Student> listStudentSortAge(long age);

    public Map<String, List<Student>> getListGroup();
}
