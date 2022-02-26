package task1.student;

public class Student {
    private static long listStudent = 0;
    private final long id = listStudent++;

    private String lastName;;
    private String name;;
    private String patronymic;;
    private long age;
    private String adress;
    private long phone;
    private Faculty faculty;
    private long course;
    private String group;

    public Student(String lastName, String name, String patronymic, long age, String adress,
                   long phone, Faculty faculty, long course, String group) {
        this.lastName = lastName;
        this.name = name;
        this.patronymic = patronymic;
        this.age = age;
        this.adress = adress;
        this.phone = phone;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    public static long getListStudent() {
        return listStudent;
    }

    public static void setListStudent(long listStudent) {
        Student.listStudent = listStudent;
    }

    public long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public long getCourse() {
        return course;
    }

    public void setCourse(long course) {
        this.course = course;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", age=" + age +
                ", adress=" + adress +
                ", phone=" + phone +
                ", faculty=" + faculty +
                ", course=" + course +
                ", group='" + group + '\'' +
                '}';
    }
}
