package com.example.lab4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    private ComboBox<String> courseComboBox;
    private ListView<String> courseListView;
    private TextArea displayArea;
    private ToggleGroup majorGroup;
    private CheckBox studentCouncilCheckBox, volunteerWorkCheckBox;

    @Override
    public void start(Stage primaryStage) {
        // Input fields
        TextField nameField = new TextField();
        nameField.setPrefWidth(200);
        TextField addressField = new TextField();
        addressField.setPrefWidth(200);
        TextField cityField = new TextField();
        cityField.setPrefWidth(200);
        TextField provinceField = new TextField();
        provinceField.setPrefWidth(200);
        TextField postalCodeField = new TextField();
        postalCodeField.setPrefWidth(200);
        TextField phoneField = new TextField();
        phoneField.setPrefWidth(200);
        TextField emailField = new TextField();
        emailField.setPrefWidth(200);

        // Major selection (radio buttons)
        RadioButton csRadioButton = new RadioButton("Computer Science");
        RadioButton businessRadioButton = new RadioButton("Business");
        majorGroup = new ToggleGroup();
        csRadioButton.setToggleGroup(majorGroup);
        businessRadioButton.setToggleGroup(majorGroup);
        csRadioButton.setSelected(true); // Preselect Computer Science

        // Course selection (ComboBox and ListView)
        courseComboBox = new ComboBox<>();
        courseComboBox.setPrefWidth(200);
        courseListView = new ListView<>();
        courseListView.setPrefHeight(70);
        courseListView.setPrefWidth(200);

        // Checkboxes
        studentCouncilCheckBox = new CheckBox("Student Council");
        volunteerWorkCheckBox = new CheckBox("Volunteer Work");

        // Display button and output
        Button displayButton = new Button("Display");
        displayArea = new TextArea();
        displayArea.setEditable(false);
        displayArea.setPrefHeight(150);
        displayArea.setPrefWidth(400);
        displayArea.setWrapText(true);

        // Student information layout
        GridPane studentInfoGrid = new GridPane();
        studentInfoGrid.setPadding(new Insets(10));
        studentInfoGrid.setHgap(10);
        studentInfoGrid.setVgap(10);

        studentInfoGrid.add(new Label("Name:"), 0, 0);
        studentInfoGrid.add(nameField, 1, 0);
        studentInfoGrid.add(new Label("Address:"), 0, 1);
        studentInfoGrid.add(addressField, 1, 1);
        studentInfoGrid.add(studentCouncilCheckBox, 2, 1);
        studentInfoGrid.add(new Label("Province:"), 0, 2);
        studentInfoGrid.add(provinceField, 1, 2);
        studentInfoGrid.add(new Label("City:"), 0, 3);
        studentInfoGrid.add(cityField, 1, 3);
        studentInfoGrid.add(new Label("Postal Code:"), 0, 4);
        studentInfoGrid.add(postalCodeField, 1, 4);
        studentInfoGrid.add(new Label("Phone Number:"), 0, 5);
        studentInfoGrid.add(phoneField, 1, 5);
        studentInfoGrid.add(volunteerWorkCheckBox, 2, 5);
        studentInfoGrid.add(new Label("Email:"), 0, 6);
        studentInfoGrid.add(emailField, 1, 6);

        // Major selection layout
        HBox majorBox = new HBox(10); // spacing between the radio buttons
        majorBox.getChildren().addAll(csRadioButton, businessRadioButton);

        // Course selection layout
        VBox courseSelectionBox = new VBox(10);
        courseSelectionBox.setPadding(new Insets(10));
        courseSelectionBox.getChildren().addAll(courseComboBox, courseListView);

        // Create the VBox for the display section
        VBox displaySection = new VBox(10);
        displaySection.setPadding(new Insets(10));
        displaySection.setAlignment(Pos.CENTER); // Center align all children inside the VBox

        // button above the display area
        displaySection.getChildren().addAll(displayButton, displayArea);

        // Main layout combining both sections
        HBox mainLayout = new HBox(20, studentInfoGrid, courseSelectionBox);

        // Event handling
        csRadioButton.setOnAction(e -> updateCourses("Computer Science"));
        businessRadioButton.setOnAction(e -> updateCourses("Business"));

        displayButton.setOnAction(e -> displayStudentInfo(nameField, addressField, cityField, provinceField, postalCodeField, phoneField, emailField));

        courseComboBox.setOnAction(e -> {
            String selectedCourse = courseComboBox.getValue();
            if (selectedCourse != null && !courseListView.getItems().contains(selectedCourse)) {
                courseListView.getItems().add(selectedCourse);
            }
        });

        // Prepopulate the courses for "Computer Science" on startup
        updateCourses("Computer Science");

        // Ensure only one checkbox is selected at a time
        studentCouncilCheckBox.setOnAction(e -> {
            if (studentCouncilCheckBox.isSelected()) {
                volunteerWorkCheckBox.setSelected(false);
            }
        });

        volunteerWorkCheckBox.setOnAction(e -> {
            if (volunteerWorkCheckBox.isSelected()) {
                studentCouncilCheckBox.setSelected(false);
            }
        });

        // Place  display section
        VBox finalLayout = new VBox(20);
        finalLayout.getChildren().addAll(mainLayout, displaySection);

        // Scene setup
        Scene scene = new Scene(finalLayout, 600, 500);

        // Set window icon
        primaryStage.getIcons().add(new Image("icon.png"));


        //  title
        primaryStage.setTitle("");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateCourses(String major) {
        courseComboBox.getItems().clear();
        if (major.equals("Computer Science")) {
            courseComboBox.getItems().addAll("Python", "C#", "Java");
        } else if (major.equals("Business")) {
            courseComboBox.getItems().addAll("Marketing", "Finance", "Accounting");
        }
    }

    private void displayStudentInfo(TextField nameField, TextField addressField, TextField cityField, TextField provinceField, TextField postalCodeField, TextField phoneField, TextField emailField) {
        StringBuilder studentInfo = new StringBuilder();

        studentInfo.append(nameField.getText()).append(", ")
                .append(addressField.getText()).append(", ")
                .append(cityField.getText()).append(", ")
                .append(provinceField.getText()).append(", ")
                .append(postalCodeField.getText()).append(", ")
                .append(phoneField.getText()).append(", ")
                .append(emailField.getText()).append("\n");

        RadioButton selectedMajor = (RadioButton) majorGroup.getSelectedToggle();
        if (selectedMajor != null) {
            studentInfo.append("Major: ").append(selectedMajor.getText()).append("\n");
        }

        studentInfo.append("Courses: ");
        for (String course : courseListView.getItems()) {
            studentInfo.append(course).append(" ");
        }

        studentInfo.append("\nActivities: ");
        if (studentCouncilCheckBox.isSelected()) studentInfo.append("Student Council ");
        if (volunteerWorkCheckBox.isSelected()) studentInfo.append("Volunteer Work");

        displayArea.setText(studentInfo.toString());
    }

    public static void main(String[] args) {
        launch(args);
    }
}