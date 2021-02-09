package studentmanagementsystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class AddStudentLayoutController implements Initializable {
    @FXML
    private TextField studentName;
    @FXML
    private TextField studentEmail;
    @FXML
    private TextField departmentName;
    @FXML
    private TextArea address;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    static ObservableList<Student>stdList=FXCollections.observableArrayList();
    @FXML
    private void saveButtonAction(ActionEvent event) throws IOException {
        
    String name=studentName.getText();
    String email=studentEmail.getText();
    String department=departmentName.getText();
    String addr=address.getText();
    
    if (name.equals("") && email.equals("") && department.equals("") && addr.equals(""))return;
    Student std=new Student(name,email,department,addr);
    
    File file=new File("data.txt");
    if(!file.exists())file.createNewFile();
    
    FileWriter filewriter=new FileWriter(file,true);
    filewriter.write(name + "#" +email + "#" +department + "#" +addr+ "\n");
    
    filewriter.close();
    studentName.clear();
    studentEmail.clear();
    departmentName.clear();
    address.clear();    
   
    }

    @FXML
    private void resetButtonAction(ActionEvent event) {
    studentName.clear();
    studentEmail.clear();
    departmentName.clear();
    address.clear();
    }
    
}
