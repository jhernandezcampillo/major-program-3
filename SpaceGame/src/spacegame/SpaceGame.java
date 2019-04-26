/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacegame;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Judith
 */
public class SpaceGame extends Application {
    
    @Override
    public void start(Stage pStage) {
        GamePane root = new GamePane();
        BorderPane bp = new BorderPane();
        HBox controlPane = new HBox();

        Button startB = new Button("Start");
        startB.setOnAction(e -> {root.startGame(); root.requestFocus();});
        Button restartB = new Button("Restart");
        restartB.setOnAction(e -> {root.restartGame(); root.requestFocus();});
        Button exitB = new Button("Exit");
        exitB.setOnAction(e -> {System.exit(0); root.requestFocus();});
        
        controlPane.getChildren().addAll(startB, restartB, exitB);
        controlPane.setAlignment(Pos.CENTER);
        root.setBottom(controlPane);
        
        
        bp.setTop(root);
        bp.setBottom(controlPane);
        
        Scene scene = new Scene(bp, 560, 630);
        
        pStage.setTitle("Space Invaders");
        pStage.setScene(scene);
        root.requestFocus();
        pStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
