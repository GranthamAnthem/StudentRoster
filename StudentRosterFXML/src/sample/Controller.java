package sample;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Controller {
    public TextField studentId;
    public TextField lastName;
    public TextField firstName;
    public ComboBox major;
    public ComboBox gradeBox;
    public CheckBox honorStatus;
    public TextArea notes;
    public BorderPane photoLayout;
    public ToggleGroup gradeOption;
    public RadioButton letterGrade;
    public RadioButton passNP;
    public Image[] image = new Image[1];
    public ImageView photo = new ImageView();
    LinkedList<File> files;
    private ListIterator<File> fileIterator;
    public Stage myStage;
    private String studentIdRoster;
    private String lastNameRoster;
    private String firstNameRoster;
    private String majorRoster;
    private String gradeBoxRoster;
    private String gradeOptionRoster;
    private CheckBox honorStatusRoster;
    public String notesRoster;
    public ImageView imageRoster;
    public ObservableList<Student> studentRosterList;
    public TableView tableView = new TableView();
    private double countSoftware;
    private double countEnglish;
    private double countNeuro;
    private double countMusic;
    private double countSociology;
    private double countA;
    private double countB;
    private double countC;
    private double countD;
    private double countF;
    private ObservableList<PieChart.Data>  pieChartData = FXCollections.observableArrayList();
    private double calcSoftware;
    private double calcEnglish;
    private double calcNeuro;
    private double calcMusic;
    private double calcSociology;
    public PieChart chart = new PieChart(pieChartData);
    public CategoryAxis xAxis;
    public NumberAxis yAxis;
    public BarChart barChart;
    public XYChart.Series dataSeries = new XYChart.Series();
    public StackPane logo;
    public Text textLogo;
    public StackPane square;
    public TableColumn<Student, String> studentIdColumn;
    public TableColumn<Student, String> firstNameColumn;
    public TableColumn<Student, String> lastNameColumn;
    public TableColumn<Student, String> majorColumn;
    public TableColumn<Student, String> gradeColumn;
    public TableColumn<Student, String> gradeOptionColumn;
    public TableColumn<Student, CheckBox> honorStatusColumn;
    public TableColumn<Student, String> notesColumn;
    public TableColumn<Student, ImageView> imageColumn;



    public void initialize(Stage stage) {


        logo.setEffect(new InnerShadow(15, Color.BLUE));
        textLogo.setFont(Font.font("Arial", FontWeight.BOLD, 18));

        Light.Distant light = new Light.Distant();
        light.setAzimuth(120);
        Lighting lighting = new Lighting();
        lighting.setLight(light);
        lighting.setSurfaceScale(70);


        square.setMaxSize(0,0);
        Reflection reflection = new Reflection();
        reflection.setFraction(0.45);
        square.setEffect(reflection);
        square.setEffect(lighting);


        myStage = stage;
        //TableColumn<Student, String> studentIdColumn = new TableColumn<>("Student Id");
        studentIdColumn.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        studentIdColumn.setCellFactory(TextFieldTableCell.<Student>forTableColumn());


        //TableColumn<Student, String> firstNameColumn = new TableColumn<>("First");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        firstNameColumn.setCellFactory(TextFieldTableCell.<Student>forTableColumn());
//        firstNameColumn.setOnEditCommit(
//                (TableColumn.CellEditEvent<Student, String> t) -> {
//                    ((Student) t.getTableView().getItems().get(
//                            t.getTablePosition().getRow())
//                    ).setFirstName(t.getNewValue());
//                    firstName.setText(t.getNewValue());
//                    save();
//                });


        //TableColumn<Student, String> lastNameColumn = new TableColumn<>("Last");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        lastNameColumn.setCellFactory(TextFieldTableCell.<Student>forTableColumn());
//        lastNameColumn.setOnEditCommit(
//                (TableColumn.CellEditEvent<Student, String> t) -> {
//                    ((Student) t.getTableView().getItems().get(
//                            t.getTablePosition().getRow())
//                    ).setLastName(t.getNewValue());
//                    lastName.setText(t.getNewValue());
//                    save();
//                });



        //TableColumn<Student, String> majorColumn = new TableColumn<>("Major");
        majorColumn.setCellValueFactory(new PropertyValueFactory<>("major"));
        majorColumn.setCellFactory(TextFieldTableCell.<Student>forTableColumn());
        majorColumn.setCellFactory(ComboBoxTableCell.forTableColumn("Software Engineering", "English", "Neuroscience", "Music", "Sociology"));
//        majorColumn.setOnEditCommit(
//                (TableColumn.CellEditEvent<Student, String> t) -> {
//                    ((Student) t.getTableView().getItems().get(
//                            t.getTablePosition().getRow())
//                    ).setMajor(t.getNewValue());
//                    major.setValue(t.getNewValue());
//                    save();
//                });


        //TableColumn<Student, String> gradeColumn = new TableColumn<>("Grade");
        gradeColumn.setCellValueFactory(new PropertyValueFactory<>("gradeBox"));
        gradeColumn.setCellFactory(TextFieldTableCell.<Student>forTableColumn());
        gradeColumn.setCellFactory(ComboBoxTableCell.forTableColumn("A", "B", "C", "D", "F"));
//        gradeColumn.setOnEditCommit(
//                (TableColumn.CellEditEvent<Student, String> t) -> {
//                    ((Student) t.getTableView().getItems().get(
//                            t.getTablePosition().getRow())
//                    ).setGradeBox(t.getNewValue());
//                    gradeBox.setValue(t.getNewValue());
//                    save();
//                });


        //TableColumn<Student, String> gradeOptionColumn = new TableColumn<>("Grade Option");
        gradeOptionColumn.setCellValueFactory(new PropertyValueFactory<>("gradeOption"));
        gradeOptionColumn.setCellFactory(TextFieldTableCell.<Student>forTableColumn());
        gradeOptionColumn.setCellFactory(ComboBoxTableCell.forTableColumn("Letter Grade", "Pass / No Pass"));
//        gradeOptionColumn.setOnEditCommit(
//                (TableColumn.CellEditEvent<Student, String> t) -> {
//                    ((Student) t.getTableView().getItems().get(
//                            t.getTablePosition().getRow())
//                    ).setGradeOption(t.getNewValue());
//                    if(t.getNewValue().contains("Letter Grade")){
//                        letterGrade.setSelected(true);
//                    }
//                    else
//                        passNP.setSelected(true);
//                    save();
//                });


        //TableColumn<Student, CheckBox> honorStatusColumn = new TableColumn<>("Honor Status");
        honorStatusColumn.setCellValueFactory(new PropertyValueFactory<>("honorStatus"));
        //honorStatusColumn.setCellFactory(TextFieldTableCell.<Student>forTableColumn());
        //honorStatusColumn.setCellFactory( tc -> new CheckBoxTableCell<>());


        //TableColumn<Student, String> notesColumn = new TableColumn<>("Notes");
        notesColumn.setCellValueFactory(new PropertyValueFactory<>("notes"));
        notesColumn.setMaxWidth(70);
        notesColumn.setCellFactory(TextFieldTableCell.<Student>forTableColumn());
//        notesColumn.setOnEditCommit(
//                (TableColumn.CellEditEvent<Student, String> t) -> {
//                    ((Student) t.getTableView().getItems().get(
//                            t.getTablePosition().getRow())
//                    ).setNotes(t.getNewValue());
//                    notes.setText(t.getNewValue());
//                    save();
//                });

        //TableColumn<Student, ImageView> imageColumn = new TableColumn<>("Image");
        imageColumn.setCellValueFactory(new PropertyValueFactory<>("image"));

//        tableView.getColumns().add(studentIdColumn);
//        tableView.getColumns().add(lastNameColumn);
//        tableView.getColumns().add(firstNameColumn);
//        tableView.getColumns().add(majorColumn);
//        tableView.getColumns().add(gradeColumn);
//        tableView.getColumns().add(gradeOptionColumn);
//        tableView.getColumns().add(honorStatusColumn);
//        tableView.getColumns().add(notesColumn);
//        tableView.getColumns().add(imageColumn);
        tableView.setEditable(true);



        preload();
        getValues();


        chart.setData(pieChartData);
        chart.setTitle("Major Frequencies");
        chart.setLegendSide(Side.LEFT);
        chart.setMinHeight(350);
        chart.setMaxHeight(350);


        xAxis.setLabel("Grades");
        yAxis.setLabel("Frequency of Grades");


        dataSeries.setName("Student Grades");
        barChart.getData().add(dataSeries);
        barChart.setTitle("Grade Frequencies");
        barChart.setMaxHeight(350);

    }


    public void preload() {

        files =  new LinkedList<>();
        File dir = new File(".");
        File[] filesList = dir.listFiles();
        for (File file : filesList) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                files.add(file);
            }
        }

        studentRosterList = FXCollections.observableArrayList();
        tableView.setItems(studentRosterList);
        // Iterator for files
        fileIterator = files.listIterator();

        while(fileIterator.hasNext()) {
            File nextFile = fileIterator.next();
            try {
                BufferedReader inputStream = new BufferedReader(new FileReader(nextFile));
                String l;
                ArrayList<String> temp = new ArrayList<>();
                while ((l = inputStream.readLine()) != null) {
                    temp.add(l);
                }
                studentIdRoster = temp.set(0,l);
                lastNameRoster = temp.set(1,l);
                firstNameRoster = temp.set(2,l);
                majorRoster = temp.set(3,l);
                gradeBoxRoster = temp.set(4,l);
                gradeOptionRoster = temp.set(5,l);
                if(gradeOptionRoster.contains("Letter Grade")) {
                    gradeOptionRoster = "Letter Grade";
                }
                else {
                    gradeOptionRoster = "Pass/No Pass";
                }

                if(temp.get(6).equals("true")) {
                    honorStatusRoster = new CheckBox();
                    honorStatusRoster.setSelected(true);
                }
                else {
                    honorStatusRoster = new CheckBox();
                    honorStatusRoster.setSelected(false);
                }


                notesRoster = temp.set(7,l);
                imageRoster = new ImageView(temp.set(8,l));
                imageRoster.setFitHeight(40);
                imageRoster.setFitWidth(40);

                Student student = new Student(studentIdRoster, lastNameRoster, firstNameRoster, majorRoster, gradeBoxRoster, gradeOptionRoster, honorStatusRoster, notesRoster, imageRoster);
                studentRosterList.add(student);


            } catch (FileNotFoundException e) {
                System.out.println("");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Select Row and have student come in to focus
        tableView.getSelectionModel().getSelectedItems().addListener(new ListChangeListener<Student>() {
            public void onChanged(Change<? extends Student> c) {
                for (Student stu : c.getList()) {
                    // Grab name from selected row
                    String fullName =(stu.getLastName() + stu.getFirstName() +".txt");

                    //open new file with selected row name
                    File selectTableFile = new File(fullName);
                    if (selectTableFile != null) {
                        //System.out.println(stu.getFirstName() + " " + stu.getLastName() + " Selected");
                        try {
                            BufferedReader inputStream = new BufferedReader(new FileReader(selectTableFile));
                            String l;
                            ArrayList<String> temp = new ArrayList<>();
                            while ((l = inputStream.readLine()) != null) {
                                temp.add(l);
                            }
                            studentId.setText(temp.set(0,l));
                            lastName.setText(temp.set(1,l));
                            firstName.setText(temp.set(2,l));
                            String title = firstName.getText() + " " + lastName.getText();
                            major.setValue(temp.set(3,l));
                            String grade = temp.set(4,l);
                            gradeBox.setValue(grade);
                            String gradeOption = temp.set(5,l);
                            if(gradeOption.contains("Letter Grade")) {
                                letterGrade.setSelected(true);
                            }
                            else {
                                passNP.setSelected(true);
                            }

                            if(temp.get(6).equals("true")) {
                                honorStatus.setSelected(true);
                            }
                            else
                                honorStatus.setSelected(false);
                            notes.setText(temp.set(7,l));
                            String tempFileName = temp.set(8,l);
                            image[0] = new Image(tempFileName, 200, 0, true, true);
                            ImageView loadPhoto = new ImageView(image[0]);
                            photoLayout.setCenter(loadPhoto);
                            myStage.setTitle(title);

                        } catch (FileNotFoundException e) {
                            System.out.println("");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        getValues();
    }



    public void editStudentId(TableColumn.CellEditEvent<Student, String> t) {

        ((Student) t.getTableView().getItems().get(
                t.getTablePosition().getRow())
        ).setStudentId(t.getNewValue());
        studentId.setText(t.getNewValue());
        save();
    }

    public void editFirstName(TableColumn.CellEditEvent<Student, String> t) {
        ((Student) t.getTableView().getItems().get(
                t.getTablePosition().getRow())
        ).setFirstName(t.getNewValue());
        firstName.setText(t.getNewValue());
        save();
    }

    public void editLastName(TableColumn.CellEditEvent<Student, String> t) {
        ((Student) t.getTableView().getItems().get(
                t.getTablePosition().getRow())
        ).setLastName(t.getNewValue());
        lastName.setText(t.getNewValue());
        save();
    }

    public void editMajor(TableColumn.CellEditEvent<Student, String> t) {
        ((Student) t.getTableView().getItems().get(
                t.getTablePosition().getRow())
        ).setMajor(t.getNewValue());
        major.setValue(t.getNewValue());
        save();
    }

    public void editGrade(TableColumn.CellEditEvent<Student, String> t) {
        ((Student) t.getTableView().getItems().get(
                t.getTablePosition().getRow())
        ).setGradeBox(t.getNewValue());
        gradeBox.setValue(t.getNewValue());
        save();
    }

    public void editGradeOption(TableColumn.CellEditEvent<Student, String> t) {
        ((Student) t.getTableView().getItems().get(
                t.getTablePosition().getRow())
        ).setGradeOption(t.getNewValue());
        if(t.getNewValue().contains("Letter Grade")){
            letterGrade.setSelected(true);
        }
        else
            passNP.setSelected(true);
        save();
    }

    public void editNotes(TableColumn.CellEditEvent<Student, String> t) {
        ((Student) t.getTableView().getItems().get(
                t.getTablePosition().getRow())
        ).setNotes(t.getNewValue());
        notes.setText(t.getNewValue());
        save();
    }

    public void onClickNewStudent(){
        studentId.clear();
        lastName.clear();
        firstName.clear();
        major.setValue("");
        gradeBox.setValue("");
        letterGrade.setSelected(false);
        passNP.setSelected(false);
        honorStatus.setSelected(false);
        notes.clear();
        if(photo != null) {
            photo.setImage(null);
        }
        photoLayout.setCenter(null);
    }


    public void onClickSaveStudent() {
        String saveName = (lastName.getText() + firstName.getText()) + ".txt";
        File selectedFile = new File(saveName);
        if (selectedFile != null) {
            save();
            getValues();
        }
    }


    public void onClickPreviousStudent() {
        if(fileIterator.hasPrevious()) {
            File nextFile = fileIterator.previous();
            try {
                BufferedReader inputStream = new BufferedReader(new FileReader(nextFile));
                String l;
                ArrayList<String> temp = new ArrayList<>();
                while ((l = inputStream.readLine()) != null) {
                    temp.add(l);
                }
                studentId.setText(temp.set(0,l));
                lastName.setText(temp.set(1,l));
                firstName.setText(temp.set(2,l));
                String title = firstName.getText() + " " + lastName.getText();
                major.setValue(temp.set(3,l));
                String grade = temp.set(4,l);
                gradeBox.setValue(grade);
                String gradeOption = temp.set(5,l);
                if(gradeOption.contains("Letter Grade")) {
                    letterGrade.setSelected(true);
                }
                else {
                    passNP.setSelected(true);
                }

                if(temp.get(6).equals("true")) {
                    honorStatus.setSelected(true);
                }
                else
                    honorStatus.setSelected(false);
                notes.setText(temp.set(7,l));
                String tempFileName = temp.set(8,l);
                image[0] = new Image(tempFileName, 200, 0, true, true);
                ImageView loadPhoto = new ImageView(image[0]);
                photoLayout.setCenter(loadPhoto);
                myStage.setTitle(title);


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void onClickNextStudent(){
        if(fileIterator.hasNext()) {
            File nextFile = fileIterator.next();
            try {
                BufferedReader inputStream = new BufferedReader(new FileReader(nextFile));
                String l;
                ArrayList<String> temp = new ArrayList<>();
                while ((l = inputStream.readLine()) != null) {
                    temp.add(l);
                }
                studentId.setText(temp.set(0,l));
                lastName.setText(temp.set(1,l));
                firstName.setText(temp.set(2,l));
                String title = firstName.getText() + " " + lastName.getText();
                major.setValue(temp.set(3,l));
                String grade = temp.set(4,l);
                gradeBox.setValue(grade);
                String gradeOption = temp.set(5,l);
                if(gradeOption.contains("Letter Grade")) {
                    letterGrade.setSelected(true);
                }
                else {
                    passNP.setSelected(true);
                }

                if(temp.get(6).equals("true")) {
                    honorStatus.setSelected(true);
                }
                else
                    honorStatus.setSelected(false);
                notes.setText(temp.set(7,l));
                String tempFileName = temp.set(8,l);
                image[0] = new Image(tempFileName, 200, 0, true, true);
                ImageView loadPhoto = new ImageView(image[0]);
                photoLayout.setCenter(loadPhoto);
                myStage.setTitle(title);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Next Student");
    }

    public void onClickDeleteStudent() {
        String saveName = (lastName.getText() + firstName.getText()) + ".txt";
        File selectedFile = new File(saveName);
        if(selectedFile.exists()) {
            selectedFile.delete();
            //System.out.println("Student Deleted From Roster");
            studentId.clear();
            lastName.clear();
            firstName.clear();
            major.setValue("");
            gradeBox.setValue("");
            letterGrade.setSelected(false);
            passNP.setSelected(false);
            honorStatus.setSelected(false);
            notes.clear();
            if(photo != null) {
                photo.setImage(null);
            }
            photoLayout.setCenter(null);
            myStage.setTitle("Student Roster");
        }
        preload();
    }


    public void onClickNewFile() {
        onClickNewStudent();
    }


    public void onClickOpenFile() {
        FileChooser openFileChooser = new FileChooser();
        File openFile = openFileChooser.showOpenDialog(myStage);

        if (openFile != null) {
            System.out.println("New Student File Opened");
            try {
                BufferedReader inputStream = new BufferedReader(new FileReader(openFile));
                String l;
                ArrayList<String> temp = new ArrayList<>();
                while ((l = inputStream.readLine()) != null) {
                    temp.add(l);
                }
                studentId.setText(temp.set(0,l));
                lastName.setText(temp.set(1,l));
                firstName.setText(temp.set(2,l));
                String title = firstName.getText() + " " + lastName.getText();
                major.setValue(temp.set(3,l));
                String grade = temp.set(4,l);
                gradeBox.setValue(grade);
                String gradeOption = temp.set(5,l);
                if(gradeOption.contains("Letter Grade")) {
                    letterGrade.setSelected(true);
                }
                else {
                    passNP.setSelected(true);
                }

                if(temp.get(6).equals("true")) {
                    honorStatus.setSelected(true);
                }
                else
                    honorStatus.setSelected(false);
                notes.setText(temp.set(7,l));
                String tempFileName = temp.set(8,l);
                image[0] = new Image(tempFileName, 200, 0, true, true);
                ImageView loadPhoto = new ImageView(image[0]);
                photoLayout.setCenter(loadPhoto);
                myStage.setTitle(title);

            } catch (FileNotFoundException e) {
                System.out.println("");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void onClickSaveFile() {
        onClickSaveStudent();
    }

    public void onClickSaveAs() {
        FileChooser saveFileChooser = new FileChooser();
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("TEXT files (*.txt)", "*.txt");
        saveFileChooser.getExtensionFilters().add(extensionFilter);
        File saveFile = saveFileChooser.showSaveDialog(myStage);

        if (saveFile != null) {
            System.out.println("Student Saved To Roster");
            boolean honorStatusSelected = honorStatus.isSelected();
            try {
                String studentData = studentId.getText() + "\n" + lastName.getText() + "\n" +
                        firstName.getText() + "\n" + major.getValue() + "\n" +
                        gradeBox.getValue() + "\n" + gradeOption.getSelectedToggle() + "\n" +
                        honorStatusSelected + "\n" + notes.getText() + "\n" + image[0].getUrl();

                byte [] data = studentData.getBytes();

                FileOutputStream out = new FileOutputStream(saveFile);
                out.write(data);
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            files.add(saveFile);
        }
        preload();
        getValues();
    }



    public void onClickClose() {
        onClickNewStudent();
    }

    public void onClickExit() {
        myStage.close();
    }



    public void uploadButton() {
        FileChooser fileChooser = new FileChooser();

        File file = fileChooser.showOpenDialog(new Stage());
        if(file != null) {
            image[0] = new Image(file.toURI().toString(), 200, 0, true, true);
            photo = new ImageView(image[0]);
            photoLayout.setCenter(photo);
        }
    }




    public void getValues() {
        countSoftware = 0;
        countEnglish = 0;
        countNeuro = 0;
        countMusic = 0;
        countSociology = 0;
        countA = 0;
        countB = 0;
        countC = 0;
        countD = 0;
        countF = 0;

        fileIterator = files.listIterator();
        while (fileIterator.hasNext()) {
            File nextFile = fileIterator.next();
            try {
                BufferedReader inputStream = new BufferedReader(new FileReader(nextFile));
                String l;
                ArrayList<String> temp = new ArrayList<>();
                while ((l = inputStream.readLine()) != null) {
                    temp.add(l);
                }
                majorRoster = temp.set(3, l);
                String grade = temp.set(4,l);
                if(majorRoster.equals("Software Engineering"))
                    countSoftware++;
                if(majorRoster.equals("English"))
                    countEnglish++;
                if(majorRoster.equals("Neuroscience"))
                    countNeuro++;
                if(majorRoster.equals("Music"))
                    countMusic++;
                if(majorRoster.equals("Sociology"))
                    countSociology++;

                if(grade.equals("A"))
                    countA++;
                if(grade.equals("B"))
                    countB++;
                if(grade.equals("C"))
                    countC++;
                if(grade.equals("D"))
                    countD++;
                if(grade.equals("F"))
                    countF++;

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Data data = new Data(countSoftware, countEnglish, countNeuro, countMusic, countSociology, countA, countB, countC, countD, countF);

        calcSoftware = data.calcData(countSoftware);
        calcEnglish = data.calcData(countEnglish);
        calcNeuro = data.calcData(countNeuro);
        calcMusic = data.calcData(countMusic);
        calcSociology = data.calcData(countSociology);



        pieChartData.clear();
        pieChartData.addAll(
                new PieChart.Data("Software Engineering - " + calcSoftware + "% \nCount " + countSoftware, calcSoftware),
                new PieChart.Data("English - " + calcEnglish +"% \nCount " + countEnglish, calcEnglish),
                new PieChart.Data("Neuroscience - " + calcNeuro + "% \nCount " + countNeuro,calcNeuro),
                new PieChart.Data("Music - " + calcMusic +"% \nCount " + countMusic ,calcMusic),
                new PieChart.Data("Sociology - " + calcSociology +"% \nCount " +countSociology ,calcSociology));



        dataSeries.getData().add(new XYChart.Data("A", countA));
        dataSeries.getData().add(new XYChart.Data("B"  , countB));
        dataSeries.getData().add(new XYChart.Data("C"  , countC));
        dataSeries.getData().add(new XYChart.Data("D"  , countD));
        dataSeries.getData().add(new XYChart.Data("F"  , countF));
    }






    public void save() {
        String saveName = (lastName.getText() + firstName.getText()) + ".txt";
        File selectedFile = new File(saveName);
        if (selectedFile != null) {
            if (selectedFile.exists()) {
                boolean honorStatusSelected = honorStatus.isSelected();
                try {
                    String studentData = studentId.getText() + "\n" + lastName.getText() + "\n" +
                            firstName.getText() + "\n" + major.getValue() + "\n" +
                            gradeBox.getValue() + "\n" + gradeOption.getSelectedToggle() + "\n" +
                            honorStatusSelected + "\n" + notes.getText() + "\n" + image[0].getUrl();
                    studentIdRoster = studentId.getText();
                    lastNameRoster = lastName.getText();
                    firstNameRoster = firstName.getText();
                    majorRoster = major.getValue().toString();
                    gradeBoxRoster = gradeBox.getValue().toString();
                    gradeOptionRoster = gradeOption.getSelectedToggle().toString();
                    if (gradeOptionRoster.contains("Letter Grade")) {
                        gradeOptionRoster = "Letter Grade";
                    } else {
                        gradeOptionRoster = "Pass/No Pass";
                    }
                    honorStatusRoster.equals(honorStatusSelected);
                    notesRoster = notes.getText();
                    imageRoster = new ImageView(image[0]);
                    imageRoster.setFitHeight(40);
                    imageRoster.setFitWidth(40);


                    Student student = new Student(studentIdRoster, lastNameRoster, firstNameRoster, majorRoster, gradeBoxRoster, gradeOptionRoster, honorStatusRoster, notesRoster, imageRoster);
                    studentRosterList.add(student);
                    tableView.setItems(studentRosterList);


                    byte[] data = studentData.getBytes();

                    FileOutputStream out = new FileOutputStream(selectedFile);
                    out.write(data);
                    out.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                preload();
            }
            else {
                boolean honorStatusSelected = honorStatus.isSelected();
                try {
                    String studentData = studentId.getText() + "\n" + lastName.getText() + "\n" +
                            firstName.getText() + "\n" + major.getValue() + "\n" +
                            gradeBox.getValue() + "\n" + gradeOption.getSelectedToggle() + "\n" +
                            honorStatusSelected + "\n" + notes.getText() + "\n" + image[0].getUrl();
                    studentIdRoster = studentId.getText();
                    lastNameRoster = lastName.getText();
                    firstNameRoster = firstName.getText();
                    majorRoster = major.getValue().toString();
                    gradeBoxRoster = gradeBox.getValue().toString();
                    gradeOptionRoster = gradeOption.getSelectedToggle().toString();
                    if (gradeOptionRoster.contains("Letter Grade")) {
                        gradeOptionRoster = "Letter Grade";
                    } else {
                        gradeOptionRoster = "Pass/No Pass";
                    }
                    honorStatusRoster.equals(honorStatusSelected);
                    notesRoster = notes.getText();
                    imageRoster = new ImageView(image[0]);
                    imageRoster.setFitHeight(40);
                    imageRoster.setFitWidth(40);


                    Student student = new Student(studentIdRoster, lastNameRoster, firstNameRoster, majorRoster, gradeBoxRoster, gradeOptionRoster, honorStatusRoster, notesRoster, imageRoster);
                    studentRosterList.add(student);
                    tableView.setItems(studentRosterList);


                    byte[] data = studentData.getBytes();

                    FileOutputStream out = new FileOutputStream(selectedFile);
                    out.write(data);
                    out.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                files.add(selectedFile);
                preload();
                studentId.clear();
                lastName.clear();
                firstName.clear();
                major.setValue("");
                gradeBox.setValue("");
                letterGrade.setSelected(false);
                passNP.setSelected(false);
                honorStatus.setSelected(false);
                notes.clear();
                if(photo != null) {
                    photo.setImage(null);
                }
                photoLayout.setCenter(null);
            }
        }
    }


}
