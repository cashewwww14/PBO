public class Student extends Person {
    private String studentID;

    public Student(String name, int age, String studentID) {
        super(name, age);
        this.studentID = studentID;
    }

    public void study() {
        System.out.println(name + " is studying.");
    }

    @Override
    public void introduce() {
        super.introduce();
        System.out.println("I am also a student with ID: " + studentID);
    }
}
