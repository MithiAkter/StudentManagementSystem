
package studentmanagementsystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class AllStudentController implements Initializable {

    @FXML
    private TableView<Student> StudentTable;
    @FXML
    private TableColumn<Student, String> NameCall;
    @FXML
    private TableColumn<Student, String> EmailCall;
    @FXML
    private TableColumn<Student, String> DeptCall;
    @FXML
    private TableColumn<Student, String> AddressCall;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        StudentTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        AddStudentLayoutController.stdList.clear();
        try {

            File file = new File("data.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                String str = sc.nextLine();
                String parts[] = str.split("#");

                Student std = new Student(parts[0], parts[1], parts[2], parts[3]);
                AddStudentLayoutController.stdList.add(std);
            }

            NameCall.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
            EmailCall.setCellValueFactory(new PropertyValueFactory<Student, String>("email"));
            DeptCall.setCellValueFactory(new PropertyValueFactory<Student, String>("department"));
            AddressCall.setCellValueFactory(new PropertyValueFactory<Student, String>("address"));

            StudentTable.setItems(AddStudentLayoutController.stdList);

        } catch (IOException ex) {
            Logger.getLogger(AllStudentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void DeletebuttonAction(ActionEvent event)  throws IOException {
        
       List<Student>selectedStudents=StudentTable.getSelectionModel().getSelectedItems();
        AddStudentLayoutController.stdList.removeAll(selectedStudents);
        
        File file=new File("data.txt");
        FileWriter fileWriter=new FileWriter(file);
        
        String str="";
        for(Student std:AddStudentLayoutController.stdList){
        
        str+=std.getName()+"#"+std.getEmail()+"#"+std.getDepartment()+"#"+std.getAddress()+"\n";
        }
        fileWriter.write(str);
        fileWriter.close();
    }

}
