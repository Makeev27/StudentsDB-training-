package Students;

public class Student {
    private int id;
    private String faculty;
    private String firstName;
    private String secondName;
    private String averageRating;


    public Student() {
    }

    public Student(int id, String faculty, String secondName, String firstName, String averageRating) {
        this.id = id;
        this.faculty = faculty;
        this.secondName = secondName;
        this.firstName = firstName;
        this.averageRating = averageRating;
    }

    public Student(String faculty, String secondName, String firstName, String averageRating) {
        this.faculty = faculty;
        this.secondName = secondName;
        this.firstName = firstName;
        this.averageRating = averageRating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(String averageRating) {
        this.averageRating = averageRating;
    }
}
