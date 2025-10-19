class Student {
    private int studentId;
    private String fullName;
    private int birthDate;
    private String gender;
    private String course;
    public Student(int studentId, String fullName, int birthDate, String gender, String course) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.course = course;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return this.gender;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    void DisplayInfo() {
        System.out.println("\nStudent Id: " + this.studentId);
        System.out.println("Full Name: " + this.fullName);
        System.out.println("Age: " + this.birthDate);
        System.out.println("Gender: " + this.gender);
        System.out.println("Course: " + this.course + "\n");
    }
}
