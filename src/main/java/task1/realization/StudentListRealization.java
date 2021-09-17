package task1.realization;

import task1.student.Faculty;
import task1.student.Student;
import task1.util.StudentRealization;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentListRealization implements StudentRealization {
    private List<Student> listStudent;

    public StudentListRealization() {
        listStudent = new ArrayList<Student>();
    }

    public void addStudent(Student student) {
        listStudent.add(student);
    }

    @Override
    public List<Student> listStudentFaculty(String initFaculty) {
        return listStudent
                .stream()
                .sorted(Comparator.comparing(Student::getFaculty))
                .filter(faculty -> faculty.getFaculty().toString().contains(initFaculty))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Faculty, Map<Long, List<Student>>> groupingListFacultyAndCourses() {
        return listStudent
                .stream()
                .collect(Collectors.groupingBy(Student::getFaculty, Collectors.groupingBy(Student::getCourse)));
    }

    @Override
    public List<Student> listStudentSortAge(long age) {
        return listStudent
                .stream()
                .filter(student -> student.getAge() > age)
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Student>> getListGroup() {
        return listStudent
                .stream()
                .collect(Collectors.groupingBy(Student::getGroup));
    }
}
