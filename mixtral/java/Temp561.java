class Student {
    private String resume;

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }
}

class MyBean {

    private void save(Student student) {
        // Implementation of save method
        System.out.println("Student saved with resume: " + student.getResume());
    }

    private String purifyXss(String string) {
        // Implementation of purifyXss method
        // For demonstration, just returning the input string
        return string.replaceAll("<[^>]*>", ""); // Simple XSS purification
    }

    public void saveStudent(Student student) {
        student.setResume(purifyXss(student.getResume()));
        save(student);
    }

    public static void main(String[] args) {
        MyBean myBean = new MyBean();
        Student student = new Student();
        student.setResume("<script>alert('xss')</script>Safe content");
        myBean.saveStudent(student);
    }
}