package com.example.main;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.*;

import java.util.Map;


public class StudentRegistration extends Application{

    public static void main(String... args){ launch(args); }

    @Override
    public void start(Stage primaryStage) throws Exception{

        AnchorPane root = new AnchorPane();

        VBox vBox = new VBox(50);

        Button loginButton = new Button("LOGIN-->");
        loginButton.setOnAction((e)->loginScene(primaryStage));
        loginButton.setFont(Font.font(20.0));
        loginButton.setTextFill(Color.RED);
        loginButton.setPadding(new Insets(30,30,30,30));

        Button registerButton = new Button("REGISTER");
        registerButton.setFont(Font.font(20.0));
        registerButton.setPadding(new Insets(30,30,30,30));
        registerButton.setTextFill(Color.DODGERBLUE);
        registerButton.setOnAction(e->StudentRegistration_m(primaryStage));

        Button donateButton = new Button("UPDATE-->");
        donateButton.setFont(Font.font(20.0));
        donateButton.setPadding(new Insets(30,30,30,30));
        donateButton.setTextFill(Color.GREEN);

        vBox.getChildren().addAll(loginButton, registerButton, donateButton);

        AnchorPane.setTopAnchor(vBox, 50.0);
        AnchorPane.setLeftAnchor(vBox,120.0);

        root.getChildren().add(vBox);

        Scene scene = new Scene(root, 400, 500, true);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Student Management App");
        primaryStage.show();
    }

    public static void loginScene(Stage window){

        AnchorPane root = new AnchorPane();

        Label regNoLabel = new Label("Registration No");
        regNoLabel.setFont(Font.font("Arial", FontWeight.BOLD,FontPosture.REGULAR, 17.0));
        TextField reg_Field = new TextField();
        reg_Field.setFont(Font.font(17.0));

        Label passwordLabel = new Label("Password");
        passwordLabel.setFont(Font.font("Arial", FontWeight.BOLD,FontPosture.REGULAR, 17.0));
        PasswordField password = new PasswordField();
        password.setFont(Font.font(17.0));

        Button login = new Button("LOGIN");
        login.setFont(Font.font(20.0));
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.BOTTOM_CENTER);
        hBox.getChildren().add(login);

        login.setOnAction(e -> {
            boolean isUser = StudentDB.loginRoute(password.getText());
            if (isUser)
            {
                MessageBox.showMessage("Login Status", "Login Successful!, Do not share your details");
                System.out.println("Login Status: {OK}");
                visualizeDetails(password.getText(), window);
            }
            else {
                MessageBox.showMessage("Login Status", "Login Failed! Incorrect Login Details");
                System.out.println("Login Status: {FAIL}");
            }
        });

        GridPane grid = new GridPane();
        grid.setVgap(20);
        grid.setHgap(20);
        grid.setPadding(new Insets(25,25,25,25));

        Text title = new Text("Student Authentication");
        title.setFont(Font.font("Arial", FontWeight.BOLD,FontPosture.REGULAR, 20));
        title.setFill(Color.DODGERBLUE);
        HBox titleLayout = new HBox(10);
        titleLayout.getChildren().add(title);
        AnchorPane.setTopAnchor(titleLayout, 20.0);
        AnchorPane.setRightAnchor(titleLayout,170.0);

        AnchorPane.setTopAnchor(grid, 28.0);
        AnchorPane.setLeftAnchor(grid, 80.0);

        grid.add(regNoLabel,0, 0);
        grid.add(reg_Field, 1, 0);

        grid.add(passwordLabel, 0, 1);
        grid.add(password, 1, 1);

        grid.add(login, 1, 2);

        root.getChildren().addAll(grid, titleLayout);

        Scene scene = new Scene(root, 600, 500, true);

        window.setScene(scene);
    }

    public static void StudentRegistration_m(Stage window){

        AnchorPane root = new AnchorPane();

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(25,25,25,25));

        Text title = new Text("Student Registration Form");
        title.setFont(Font.font("Arial", FontWeight.BOLD,FontPosture.REGULAR, 20));
        title.setFill(Color.DODGERBLUE);
        HBox titleLayout = new HBox(10);
        titleLayout.getChildren().add(title);
        AnchorPane.setTopAnchor(titleLayout, 20.0);
        AnchorPane.setLeftAnchor(titleLayout,240.0);

        Label firstname = new Label("Firstname");
        firstname.setFont(Font.font("Arial", FontWeight.BOLD,FontPosture.REGULAR, 17.0));
        TextField firstname_Field = new TextField();
        firstname_Field.setFont(Font.font(17.0));
        grid.add(firstname, 0,0);
        grid.add(firstname_Field, 1, 0);

        Label middlename = new Label("Middlename");
        middlename.setFont(Font.font("Arial", FontWeight.BOLD,FontPosture.REGULAR, 17.0));
        TextField middlename_Field = new TextField();
        middlename_Field.setFont(Font.font(17.0));
        grid.add(middlename, 0, 1);
        grid.add(middlename_Field, 1,1);

        Label lastname = new Label("Lastname");
        lastname.setFont(Font.font("Arial", FontWeight.BOLD,FontPosture.REGULAR, 17.0));
        TextField lastname_Field = new TextField();
        lastname_Field.setFont(Font.font(17.0));
        grid.add(lastname, 0,2);
        grid.add(lastname_Field, 1, 2);

        Label d_o_b = new Label("D.O.B");
        d_o_b.setFont(Font.font("Arial", FontWeight.BOLD,FontPosture.REGULAR, 17.0));
        TextField d_o_b_Field = new TextField();
        d_o_b_Field.setFont(Font.font(17.0));
        d_o_b_Field.setPromptText("22/03/1978");
        grid.add(d_o_b, 0, 3);
        grid.add(d_o_b_Field, 1, 3);

        Label id_No = new Label("ID No");
        id_No.setFont(Font.font("Arial", FontWeight.BOLD,FontPosture.REGULAR, 17.0));
        TextField id_field = new TextField();
        id_field.setFont(Font.font(17.0));
        grid.add(id_No, 0, 4);
        grid.add(id_field, 1,4);

        Label regNo = new Label("Reg No");
        regNo.setFont(Font.font("Arial", FontWeight.BOLD,FontPosture.REGULAR, 17.0));
        TextField reg_field = new TextField();
        reg_field.setFont(Font.font(17.0));
        grid.add(regNo, 0, 5);
        grid.add(reg_field, 1, 5);

        Label year = new Label("Current year");
        year.setFont(Font.font("Arial", FontWeight.BOLD,FontPosture.REGULAR, 17.0));
        ComboBox<String> year_S = new ComboBox<>();
        year_S.setValue("Current Year");
        year_S.setPadding(new Insets(10,10,10,10));
        ObservableList<String> data = FXCollections.observableArrayList();
        data.addAll("1.1", "1.2", "2.1","2.2", "3.1", "3.2", "4.1", "4.2");
        year_S.itemsProperty().setValue(data);
        grid.add(year, 0, 6);
        grid.add(year_S, 1, 6);

        Label study_type = new Label("Study Level");
        study_type.setFont(Font.font("Arial", FontWeight.BOLD,FontPosture.REGULAR, 17.0));
        ComboBox<String> studyType = new ComboBox<>();
        studyType.setValue("Type of Study");
        studyType.setPadding(new Insets(10,10,10,10));
        ObservableList<String> data_S = FXCollections.observableArrayList();
        data_S.addAll("Doctorate","Masters","Degree", "Diploma", "Certificate");
        studyType.itemsProperty().setValue(data_S);
        grid.add(study_type, 0,7);
        grid.add(studyType, 1, 7);

        TextField course_Field = new TextField();

        studyType.setOnAction(e->{
            if (studyType.getValue().equals("Doctorate")){
                course_Field.clear();
                course_Field.appendText("PHd ");
            }
            else if (studyType.getValue().equals("Masters"))
            {
                course_Field.clear();
                course_Field.appendText("MSt ");
            }
            else if (studyType.getValue().equals("Degree"))
            {
                course_Field.clear();
                course_Field.appendText("BSc ");
            }
            else{
                course_Field.clear();
            }
        });

        Label course_Label = new Label("Course Name");
        course_Label.setFont(Font.font("Arial", FontWeight.BOLD,FontPosture.REGULAR, 17.0));
        course_Field.setFont(Font.font(17.0));
        grid.add(course_Label, 0, 8);
        grid.add(course_Field, 1, 8);

        Button register = new Button("REGISTER");
        register.setFont(Font.font(20.0));
        register.setAlignment(Pos.BOTTOM_CENTER);
        register.setOnAction(e->{
            StudentDB.insertStudentDetails(
                    firstname_Field.getText(), middlename_Field.getText(), lastname_Field.getText(),
                    d_o_b_Field.getText(), id_field.getText(), reg_field.getText(),year_S.getValue(),
                    studyType.getValue(),course_Field.getText()
            );
            loginScene(window);
        });
        HBox register_btn_layout = new HBox(10);
        register_btn_layout.getChildren().add(register);

        grid.add(register_btn_layout, 1,11);

        root.getChildren().addAll(grid,titleLayout);
        AnchorPane.setTopAnchor(grid,28.0);
        AnchorPane.setLeftAnchor(grid, 150.0);

        Scene scene = new Scene(root, 700, 600,true);
        window.setScene(scene);
        window.setTitle("Student Registration Form");
    }

    public static void visualizeDetails(String key, Stage window){

        Map<String, String> studentData = StudentDB.getStudentDetails(key);

        ObservableList<Student> data = FXCollections.observableArrayList(
                new Student("FirstName", studentData.get("FirstName")),
                new Student("MiddleName", studentData.get("MiddleName")),
                new Student("LastName", studentData.get("LastName")),
                new Student("Date of Birth", studentData.get("Date of Birth")),
                new Student("ID No", studentData.get("ID No")),
                new Student("Registration No", studentData.get("Registration No")),
                new Student("Current Year", studentData.get("Current Year")),
                new Student("Study Level", studentData.get("Study Level")),
                new Student("Course Name", studentData.get("CourseName"))
        );

        TableView<Student> table = new TableView<>();
        table.itemsProperty().setValue(data);

        TableColumn<Student, String> fieldColumn = new TableColumn<>("Field Name");
        TableColumn<Student, String> detailsColumn = new TableColumn<>("Details");

        fieldColumn.setCellValueFactory((e)->e.getValue().fieldNameProperty());
        detailsColumn.setCellValueFactory((e)->e.getValue().fieldValueProperty());

        table.getColumns().addAll(fieldColumn,detailsColumn);

        AnchorPane root = new AnchorPane();
        AnchorPane.setTopAnchor(table, 20.0);
        AnchorPane.setLeftAnchor(table, 200.0);
        root.getChildren().add(table);
        Scene scene = new Scene(root, window.getScene().getWidth(), window.getScene().getHeight(), true);
        window.setTitle(studentData.get("FirstName")+" Details");
        window.setScene(scene);
    }
}