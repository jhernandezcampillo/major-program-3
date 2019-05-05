/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacegame;


import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import spacegame.GameObject;
import spacegame.SpaceShip;

/**
 *  
 * @author Judith
 */
public class GamePane extends BorderPane {
    
    private ActionPane actionPane; 
    private CmdCenter commandCenter;
    private Projectile projectile; 
    private CmdHandler commandHandler;
    private GameTimer gameTimer;
    private SpaceShip spaceShip;
    private Random random;
    private Text sumScore;
    private HBox statusPane;
    private int score;
    
    public GamePane(){
        
        commandHandler = new CmdHandler(this);
        random = new Random();
        score = 0;
        
        this.setPrefSize(550, 600); 
        this.setStyle("-fx-background-color:black;");
        
        actionPane = new ActionPane();
        actionPane.setPrefSize(550, 550);
        
        commandCenter = new CmdCenter(actionPane);
        this.addGameObject(commandCenter);
        
        projectile = commandCenter.getProjectile();
        this.addGameObject(projectile);
        projectile.setVisible(false);
        
        spaceShip = new SpaceShip(this);
        this.addGameObject(spaceShip);
        
        gameTimer = new GameTimer(this);
        
        this.setCenter(actionPane); 
        
        statusPane = new HBox();
        sumScore = new Text();
        sumScore.setFill(Color.RED);
        sumScore.setScaleX(1.5);
        sumScore.setScaleY(1.5);
        
        statusPane.getChildren().add(sumScore);
        
        this.setTop(statusPane);
        
    }
    
    public void addGameObject(GameObject go){
        actionPane.getChildren().add(go);
    }
    
    public boolean surround(GameObject obj, GameObject obj1){
        return (obj.surround().intersects(obj1.surround()));
    }
    
    public void startGame(){
            gameTimer.start();
        }
        
    public void restartGame(){
        gameTimer.stop();
        commandCenter.setX(actionPane.getPrefWidth()/2);
        commandCenter.setY(actionPane.getPrefHeight());
        projectile.setY(-300);
        spaceShip.side();
        this.setScore(0);
        sumScore.setText("    SCORE: " + score);
    }
    
    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }
    
    //Handler for commandCenter keyboard inputs
    public class CmdHandler implements EventHandler<KeyEvent>{
        
        GamePane game;
        
        CmdHandler(GamePane game){
            this.game = game;
        }

        @Override
        public void handle(KeyEvent event) {
            
            if(event.getEventType() == KeyEvent.KEY_PRESSED){

                switch (event.getCode()) {
                case LEFT:
                    if(commandCenter.getX() <= 0){
                        commandCenter.setSpeed(0);
                    }
                    else{
                        commandCenter.setDirection(commandCenter.getValue("WEST"));
                        commandCenter.setSpeed(4);
                    }
                    break;
                case RIGHT:
                    if(commandCenter.getX() + 26 >= commandCenter.getParentWidth()){
                        commandCenter.setSpeed(0);
                    }
                    else{
                        commandCenter.setDirection(commandCenter.getValue("EAST"));
                        commandCenter.setSpeed(4);
                    }
                    break;
                case SPACE:
                    projectile.setSpeed(8);
                    commandCenter.fireProjectile();
                }
            }
            else if (event.getEventType() == KeyEvent.KEY_RELEASED) commandCenter.setSpeed(0);   
        }
    }
    
    public class GameTimer extends AnimationTimer{
        
        private GamePane game;
        private long period;
        
        public GameTimer(GamePane game){
            this.game = game;
            period = Math.abs(random.nextInt(25000000 - 5000000) + 5000000);
        }
        
        public void handle(long now){
            
            game.setOnKeyPressed(commandHandler);
            game.setOnKeyReleased(commandHandler);
            projectile.move();
            commandCenter.move();
            spaceShip.move();
            
            if(surround(projectile, spaceShip)){
                spaceShip.setRandomPointValue();
                spaceShip.side();
                projectile.setVisible(false);
                
                game.setScore(game.getScore() + spaceShip.getPointValue());
                sumScore.setText("    SCORE: " + game.getScore());
            }
            
            spaceShip.setPrevious(now % 25000000L);
            if(spaceShip.getX() <= 0 - 100 || spaceShip.getX() >= spaceShip.getParentWidth() + 100){
                if(spaceShip.getPrevious() >= period){
                    spaceShip.side();
                    period = Math.abs(random.nextInt(25000000 - 5000000) + 5000000);
                }
            }
        }
    }
}
