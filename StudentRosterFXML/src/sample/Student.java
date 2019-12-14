package sample;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Student {

    private final SimpleStringProperty studentId;
    private final SimpleStringProperty lastName;
    private final SimpleStringProperty firstName;
    private  final SimpleStringProperty major;
    private final SimpleStringProperty gradeBox;
    private final SimpleStringProperty gradeOption;
    private CheckBox honorStatus;
    private final SimpleStringProperty notes;
    private ImageView image;

    Student(String studentId, String lastName, String firstName, String major, String gradeBox, String gradeOption, CheckBox honorStatus, String notes, ImageView image) {
        this.studentId = new SimpleStringProperty(studentId);
        this.lastName = new SimpleStringProperty(lastName);
        this.firstName = new SimpleStringProperty(firstName);
        this.major = new SimpleStringProperty(major);
        this.gradeBox = new SimpleStringProperty(gradeBox);
        this.gradeOption = new SimpleStringProperty(gradeOption);
        this.honorStatus = honorStatus;
        this.notes = new SimpleStringProperty(notes);
        this.image = image;
    }

    public String getStudentId() {
        return studentId.get();
    }

    public void setStudentId(String stuId) {
        studentId.set(stuId);
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String stuLastName) {
        lastName.set(stuLastName);

    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String fName) {
        firstName.set(fName);
    }

    public String getMajor() {
        return major.get();
    }

    public void setMajor(String major1) {
        major.set(major1);
    }


    public String getGradeBox() {
        return gradeBox.get();
    }

    public void setGradeBox(String gbox) {
        gradeBox.set(gbox);
    }

    public String getGradeOption() {
        return gradeOption.get();
    }

    public void setGradeOption(String gradeOption1) {
        gradeOption.set(gradeOption1);
    }

    public CheckBox getHonorStatus() {
        return honorStatus;
    }

    public void setHonorStatus(CheckBox honorStatus1) {
        this.honorStatus = honorStatus1;
    }

    public String getNotes() {
        return notes.get();
    }

    public void setNotes(String notes1) {
        notes.set(notes1);
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

}
