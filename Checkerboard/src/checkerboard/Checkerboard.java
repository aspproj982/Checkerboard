/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Synap
 */
public class Checkerboard extends Application {
    
    private int numRows;
    private int numCols;
    private double height;
    private double width;
    private double rectangleWidth;
    private double rectangleHeight;
    private AnchorPane anchorPane;
    private final Color blackColor = Color.BLACK;
    private final Color redColor = Color.RED;
    private Color lightColor;
    private Color darkColor;
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root = loader.load();
        Startable controller = loader.getController();

        Scene scene = new Scene(root);

        stage.setTitle("Checkerboard");
        stage.setScene(scene);
        stage.show();
        controller.start(stage);
    }
    
    public Checkerboard(){
        
    }
    
    public Checkerboard(int numRows, int numCols, double boardWidth, double boardHeight){
        this();
        this.numRows = numRows;
        this.numCols = numCols;
        this.width = boardWidth;
        this.height = boardHeight;
        
        anchorPane = new AnchorPane();
    }
    
    public Checkerboard(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor){
        this(numRows, numCols, boardWidth, boardHeight);
        this.lightColor = lightColor;
        this.darkColor = darkColor;
    }
    
    public AnchorPane build(double boardWidth, double boardHeight, int numRows, int numCols){
        
        this.width = boardWidth;
        this.height = boardHeight;
        rectangleWidth = Math.ceil(width / (double)numCols);
        rectangleHeight = Math.ceil(height / (double)numRows);
        anchorPane.setPrefWidth(width);
        anchorPane.setPrefHeight(height);
        for (int i = 0; i < numRows; i++){
            for (int j = 0; j < numCols; j++){
                Rectangle rectangle = null;
                if (( (i+j) % 2) == 0 ) {
                    rectangle = new Rectangle(rectangleWidth, rectangleHeight, redColor);
                    rectangle.setLayoutX(j * rectangleWidth);
                    rectangle.setLayoutY(i * rectangleHeight);
                } else {
                    rectangle = new Rectangle(rectangleWidth, rectangleHeight, blackColor);
                    rectangle.setLayoutX(j * rectangleWidth);
                    rectangle.setLayoutY(i * rectangleHeight);
                }
                anchorPane.getChildren().add(rectangle);
            }
            
        }
        
        return anchorPane;
    }
    
    public AnchorPane getBoard(){
        return anchorPane;
    }
    
    public int getNumRows(){
        return numRows;
    }
    
    public int getNumCols(){
        return numCols;
    }
    
    public double getWidth(){
        return width;
    }
    
    public double getHeight(){
        return height;
    }
    
    public Color getLightColor(){
        return lightColor;
    }
    
    public Color getDarkColor(){
        return darkColor;
    }
    
    public double getRectangleWidth(){
        return rectangleWidth;
    }
    
    public double getRectangleHeight(){
        return rectangleHeight;
    }
    
    public void clear() {
        anchorPane.getChildren().clear();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
