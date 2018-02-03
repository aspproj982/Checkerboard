/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Synap
 */
public class FXMLDocumentController implements Initializable, Startable {
    
    private Stage stage;
    private Checkerboard checkerBoard;
    
    private int numRows = 8;
    private int numColumns = 8;
    private final Color blackColor = Color.BLACK;
    private final Color redColor = Color.RED;
    
    @FXML
    private VBox VBox;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    @Override
    public void start (Stage stage){
        this.stage = stage;
        
        checkerBoard = new Checkerboard(numRows, numColumns, (double)stage.getWidth(), (double)stage.getHeight());
        System.out.println("Hello");
        VBox.getChildren().add(checkerBoard.getBoard());
        
        ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            refresh();
        };
        
        this.stage.widthProperty().addListener(lambdaChangeListener);
        this.stage.heightProperty().addListener(lambdaChangeListener);
        
        refresh();
    }
    
    private void handleDimensionChanges(int numRows, int numCols){
        this.numRows = numRows;
        this.numColumns = numCols;
        clear();
        checkerBoard = new Checkerboard(numRows, numCols, (double)stage.getWidth(), (double)stage.getHeight());
        VBox.getChildren().add(checkerBoard.getBoard());
        refresh();
    }
    
    private void refresh(){
        checkerBoard.build(stage.getWidth(), stage.getHeight(), numRows, numColumns);
    }
    
    private void clear(){
        checkerBoard.clear();
    }
    
    private void handleDefaultColor(){
        
    }
    
    private void handleCustomColor(){
        
    }
    
    @FXML
    private void handleSixteen(){
        handleDimensionChanges(16, 16);
    }
    
    @FXML
    private void handleTen(){
        handleDimensionChanges(10, 10);
    }
    
    @FXML
    private void handleEight(){
        handleDimensionChanges(8, 8);
    }
    
    @FXML
    private void handleThree(){
        handleDimensionChanges(3, 3);
    }
}
