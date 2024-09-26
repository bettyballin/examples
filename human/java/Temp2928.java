import java.util.HashSet;
import java.util.Set;

class Course {
    private Set<User> users = new HashSet<>();

    public Set<User> getUsers() {
        return users;
    }
}

class User {
    private Set<Course> availableCourses;

    public void addAvailableCourse(Course course) {
        if (this.availableCourses == null) {
            this.availableCourses = new HashSet<>();
        }
        this.availableCourses.add(course);
        course.getUsers().add(this);
    }
}

public class Temp2928 {
    public static void main(String[] args) {
        User user = new User();
        Course course = new Course();
        user.addAvailableCourse(course);

        System.out.println("Course added to user's available courses.");
        System.out.println("User added to course's users.");
    }
}