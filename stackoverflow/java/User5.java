import java.util.HashSet;
import java.util.Set;

public class User5 {
    private Set<Course> availableCourses;

    public User5() {
        this.availableCourses = new HashSet<>();
    }

    public void addAvailableCourse(Course course){
        if(this.availableCourses == null)
            this.availableCourses = new HashSet<>();
        this.availableCourses.add(course);
        course.getUser5s().add(this);
    }
}

class Course {
    private Set<User5> users;

    public Course() {
        this.users = new HashSet<>();
    }

    public Set<User5> getUser5s() {
        return users;
    }
}