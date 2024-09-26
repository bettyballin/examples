import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/course")
public class CourseController {

    // Example autowired service
    // @Autowired
    // private CourseService courseService;

    @RequestMapping(value = "/{courseId}", method = RequestMethod.GET)
    public @ResponseBody String getCourse(@PathVariable("courseId") String courseId) {
        // Assuming there is a method in CourseService to get course details
        // String courseDetails = courseService.getCourseDetails(courseId);
        // return courseDetails;
        
        // Placeholder return for compilation
        return "Course details for ID: " + courseId;
    }
}