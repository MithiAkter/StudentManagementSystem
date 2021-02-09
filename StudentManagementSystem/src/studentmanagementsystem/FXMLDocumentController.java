
package studentmanagementsystem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;


public class FXMLDocumentController implements Initializable {
    @FXML
    private VBox mainContent;
    
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Parent pane=FXMLLoader.load(getClass().getResource("addStudentLayout.fxml"));
            mainContent.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void addStudent(ActionEvent event) throws IOException {
       Parent pane=FXMLLoader.load(getClass().getResource("addStudentLayout.fxml"));
       mainContent.getChildren().setAll(pane);
        
    }

    @FXML
    private void showAllstudents(ActionEvent event) throws IOException {
        
        Parent pane=FXMLLoader.load(getClass().getResource("AllStudent.fxml"));
        mainContent.getChildren().setAll(pane);  
        
        
        
    }
    
}
