package task1.realization;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import task1.student.Faculty;
import task1.student.Student;

import java.util.List;
import java.util.Map;

public class CreateAndSortedCollectionStudent {
    private static Logger logger = LogManager.getLogger(CreateAndSortedCollectionStudent.class);
    public static void main(String[] args) {
        StudentListRealization students = new StudentListRealization();
        students.addStudent(new Student(
                "Smirnova",
                "Natalia",
                "Ivanovna",
                2002,
                "8 - 98",
                6578465,
                 Faculty.CLINICAL_PSYCHOLOGY,
                1,
                "starting"));

        students.addStudent(new Student(
                "Raykovskaya",
                "Olesya",
                "Olegovna",
                2000,
                "14 - 1011",
                3546783,
                Faculty.CURATIVE,
                3,
                "advanced"));

        students.addStudent(new Student(
                "Zakrynskiy",
                "Victor",
                "Ivanovich",
                1998,
                "70 - 74",
                5112345,
                Faculty.CURATIVE,
                4,
                "higter"));

        students.addStudent(new Student(
                "Ravskiy",
                "Nikolay",
                "Petrovitch",
                2000,
                "13 - 133",
                1001002,
                Faculty.PEDIATRIC,
                2,
                "midium"));

        students.addStudent(new Student(
                "Carvelly",
                "Revaz",
                "Zaurovitch",
                2001,
                "7 - 90",
                9807689,
                Faculty.DENTAL,
                2,
                "midium"));

        students.addStudent(new Student(
                "Carvelly",
                "Tomara",
                "Zaurovna",
                2002,
                "7 - 90",
                2345431,
                Faculty.PEDIATRIC,
                1,
                "starting"));

        students.addStudent(new Student(
                "Osterovitch",
                "Marina",
                "Vitalievna",
                2000,
                "57 - 119",
                1114560,
                Faculty.CLINICAL_PSYCHOLOGY,
                3,
                "advanced"));

        students.addStudent(new Student(
                "Uygurov",
                "Marat",
                "Garzhievitch",
                1999,
                "84 - 133",
                5675675,
                Faculty.DENTAL,
                3,
                "advanced"));
        List<Student> studentFacultytList = students.listStudentFaculty("CLINICAL_PSYCHOLOGY");
        logger.info("This is list Faculty: " + studentFacultytList);
        Map<Faculty, Map<Long, List<Student>>> studentFacultyCoursesList = students.groupingListFacultyAndCourses();
        logger.info("This is list Faculty and Courses grouping: " + studentFacultyCoursesList);
        List<Student> studentAgeList = students.listStudentSortAge(2000);
        logger.info("This is Student Age list: " + studentAgeList);
        Map<String, List<Student>> studentGroupList = students.getListGroup();
        logger.info("This is Student Group List grouping: " + studentGroupList);
    }
}
