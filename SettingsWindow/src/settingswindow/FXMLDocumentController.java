/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settingswindow;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Rusty
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button btnAddGame;
    @FXML
    private TextField txfAddGame;
    @FXML
    private Button btnOK;
    @FXML
    private Button btnCancel;
    @FXML
    private AnchorPane ancSettings;
    @FXML
    private ListView<String> lvGames;
    @FXML
    private Button btnRemove;
    @FXML
    private Button btnRemoveAll;
    @FXML
    private Button btnEdit;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
            File fileList = new File("./data/list.txt");
            
            BufferedReader brGameList = null;
            try {
                brGameList = new BufferedReader(new FileReader(fileList));
                String str;
                while((str = brGameList.readLine()) != null){
                    lvGames.getItems().add(str);
                }
            } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void handleAddButtonClicked(MouseEvent event) {
        String strText = txfAddGame.getText();
        lvGames.getItems().add(strText);
    }

    @FXML
    private void handleCancelButtonClicked(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void handleRemoveButtonClicked(MouseEvent event) {
        int intGameElement = lvGames.getSelectionModel().getSelectedIndex();
        lvGames.getItems().remove(intGameElement);
        if(lvGames.getItems().size() ==0){
            btnRemove.setDisable(true);
            btnRemoveAll.setDisable(true);
            btnEdit.setDisable(true);
        }
    }

    @FXML
    private void handleRemoveAllButtonClicked(MouseEvent event) {
        
        lvGames.getItems().clear();
    }

    @FXML
    private void handleEditButtonClicked(MouseEvent event) {
    }

    @FXML
    private void handleGameSelected(MouseEvent event) {
        int intGameElement = lvGames.getSelectionModel().getSelectedIndex();
        
        if(intGameElement != -1){
            btnRemove.setDisable(false);
        }
        else{
            btnRemove.setDisable(true);
        }
    }

    
}
