import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene; 
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.geometry.Insets;
import javafx.animation.FadeTransition;
import javafx.animation.FadeTransitionBuilder;
import javafx.scene.media.AudioClip;
import javafx.concurrent.Task;
import javafx.util.*;


public class TicTacStart extends Application {
    private FadeTransition fadeTransition;
    public static void main(String[] args)
    {
        launch(args);
    }

     @Override
     public void start(Stage primaryStage){
         primaryStage.setTitle("The Ultimate Tic Tac Toe");
         
         BorderPane bPane = new BorderPane();
         GridPane bBoardPane = new GridPane();
         GridPane Menu = new GridPane();
         PlayGround play = new PlayGround();
         PlayerPane currentPlayer = new PlayerPane(play);
         play.importPane(currentPlayer);
         
         Stage stage;
         Scene menu, game;
         stage = primaryStage;
         game = new Scene (bPane,800, 800);
         
         //Creates buttons for Menu to play the game or exit
         Button start = new Button ("Play");
         Button exit = new Button("Exit");
         HBox button1 = new HBox(10);
         button1.setSpacing(50);
         button1.setAlignment(Pos.CENTER);
         start.setFont(Font.font("Verdena",50));
         start.setOnAction(e -> {stage.setScene(game);});
         exit.setFont(Font.font("Verdena",50));
         exit.setOnAction(e-> System.exit(0));
      
         button1.getChildren().addAll(start,exit);
         Menu.add(button1, 1, 4);
         Menu.setAlignment(Pos.BOTTOM_RIGHT);
         Menu.setHgap(10);
         Menu.setVgap(60);
         Menu.setPadding(new Insets(25, 25, 25, 25));
         Menu.setStyle("-fx-background: black;");

         //Creates buttons to reset board or exit game
         HBox hbox = new HBox();
         Button a = new Button ("New game");
         Button b = new Button("Exit");
         a.setFont(Font.font("Verdena",30));
         b.setFont(Font.font("Verdena",30));
         
     
         hbox.getChildren().addAll(a,b);
         hbox.setAlignment(Pos.CENTER);
         hbox.setSpacing(10);
         hbox.setStyle("-fx-background-color:  #74829f; -fx-padding: 1;-fx-border-width: 2; -fx-border-color:black;"); 
         b.setOnAction(e-> System.exit(0));
         TicBoard bigBoard[][] = new TicBoard[3][3];
         for (int i = 0; i < 3; i++)
           for (int j = 0; j < 3; j++)
           {
               bigBoard[i][j] = new TicBoard(play, bigBoard);
               bBoardPane.addRow(i, bigBoard[i][j].setBoard(bBoardPane));
           }
          
         a.setOnAction(e->{
              
             //play fade transition when new game is clicked
             fadeTransition = FadeTransitionBuilder.create()
            .duration(Duration.seconds(0.7))
            .node(bBoardPane)
            .fromValue(1)
            .toValue(0.1)
            .cycleCount(2)
            .autoReverse(true)
            .build();
            fadeTransition.play();
             
            //clear all cells and reset to player 1
            bBoardPane.getChildren().clear();
            currentPlayer.reset();
            play.resetPlayer();
            
         for (int i = 0; i < 3; i++)
           for (int j = 0; j < 3; j++)
           {
               bigBoard[i][j] = new TicBoard(play, bigBoard);
               bBoardPane.addRow(i, bigBoard[i][j].setBoard(bBoardPane));
           } 
            
           });
         
        bBoardPane.setStyle("-fx-background-color: #74828f; -fx-padding: 100;");
        bBoardPane.setAlignment(Pos.CENTER);
        bPane.setTop(currentPlayer.getCurrentP());
        bPane.setBottom(hbox);
        bPane.setCenter(bBoardPane);
        
        //Creates menu screen and opens as primary stage
        menu = new Scene (Menu, 800, 800);
        primaryStage.setScene(menu);
        primaryStage.show();
        String image = this.getClass().getResource("Images/TicTac.png").toExternalForm();
        Menu.setStyle("-fx-background-image:  url('" + image + " ');" + "-fx-background-position: center center; " +
        "-fx-background-repeat: stretch;" + "-fx-background-size:cover");
        
        //Adds background music for the game
        final Task task = new Task() {

        @Override
        protected Object call() throws Exception {
            int s = 10000;
            AudioClip audio = new AudioClip(getClass().getResource("Media/TicTac.wav").toExternalForm());
            audio.setVolume(0.2f);
            audio.setCycleCount(s);
            audio.play();
            return null;
        }
        };
    Thread thread = new Thread(task);
    thread.start();
     }
}

