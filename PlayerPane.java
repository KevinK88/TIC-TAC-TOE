
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class PlayerPane extends HBox {
    HBox currentP = new HBox();
    PlayGround play;
    Label player1 = new Label("Player 1");
    Label player2 = new Label("Player 2");
    Label player2Win = new Label("Player 2 wins!");
    Label player1Win = new Label("Player 1 wins!");
    Label draw = new Label("Draw!");
         

public PlayerPane(PlayGround newPlay){
    play = newPlay;
      currentP.getChildren().add(player1);
      currentP.setStyle("-fx-background-color: #0093D1; -fx-border-width: 2; -fx-border-color:black;");
    
}

public void reset(){
       currentP.getChildren().clear();
   currentP.getChildren().add(player1);
      currentP.setStyle("-fx-background-color: #0093D1; -fx-border-width: 2; -fx-border-color:black;"); 
}

public void getCurrentPlayer(){
    if (play.getPlayer()){
        currentP.getChildren().clear();
        currentP.getChildren().add(player1);
        currentP.setStyle("-fx-background-color: #0093D1; -fx-border-width: 2;-fx-border-color: black;");
        
    }
    else{
        currentP.getChildren().clear();
        
        currentP.getChildren().add(player2);
        currentP.setStyle("-fx-background-color: #F2635F; -fx-border-width: 2;-fx-border-color: black;");
    }
}

public void getWinnerX(){
    
        currentP.getChildren().clear();   
        currentP.getChildren().add(player1Win);
        currentP.setStyle("-fx-background-color: #0093D1; -fx-border-width: 2;-fx-border-color: black;");
}

public void getWinnerO(){
    
        currentP.getChildren().clear();   
        currentP.getChildren().add(player2Win);
        currentP.setStyle("-fx-background-color: #F2635F; -fx-border-width: 2;-fx-border-color: black;");
        
}

public void getDraw(){
    
        currentP.getChildren().clear();   
        currentP.getChildren().add(draw);
        currentP.setStyle("-fx-background-color: #F2635F; -fx-border-width: 2;-fx-border-color: black;");
        
}

public HBox getCurrentP(){
    
    player2Win.setTextFill(Color.WHITE);
    player2Win.setFont(Font.font("Verdana",30));
    
    draw.setTextFill(Color.WHITE);
    draw.setFont(Font.font("Verdana",30));
     
    player1Win.setTextFill(Color.WHITE);
    player1Win.setFont(Font.font("Verdana",30));
     
    player1.setTextFill(Color.WHITE);
    player1.setFont(Font.font("Verdana",30));
   
   //  player1.setStyle("-fx-background-color: blue; -fx-border-width: 1;");
    player2.setTextFill(Color.WHITE);
    player2.setFont(Font.font("Verdana",30));
   //  currentP.setStyle("-fx-background-color: red; -fx-border-width: 1;");
    currentP.setAlignment(Pos.CENTER);
  
    return currentP;
}
}
