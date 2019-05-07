import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import javafx.animation.ScaleTransition;
import javafx.animation.ScaleTransitionBuilder;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Cell {
    private ScaleTransition scaleTransition;
    private boolean filled = false;
    private boolean move;
    private int rowX;
    private int columnY;
    private Image imageX = new Image("Images/X.png");
    private Image imageO = new Image("Images/O.png");
    private Image imageN = new Image("Images/null.png");
    private PlayGround play;
    private TicBoard parent;
    String oSound = "soundo.mp3";
    String xSound = "soundx.wav";
    
    Media sound = new Media(new File(oSound).toURI().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(sound);
    
    Media soundx = new Media(new File(xSound).toURI().toString());
    MediaPlayer mediaPlayerx = new MediaPlayer(soundx);
    
    
    public Cell(PlayGround p, TicBoard par)
    {
        play = p;
        parent = par;
    }
    
    public void setRowX(int x)
    {
        rowX = x;
    }
    
    public void setColumnY(int y)
    {
        columnY = y;
    }
    
    public boolean makeMove(ImageView image)
    {
        if (isTaken())
            return false;
        filled = true;
        move = play.getPlayer();
        if (play.getPlayer()){
            image.setImage(imageX);
            
              scaleTransition = ScaleTransitionBuilder.create()
                .node(image)
                .duration(Duration.seconds(.1))
                .toX(1.2)
                .toY(1.2)
                .cycleCount(2)
                .autoReverse(true)
                .build();
              scaleTransition.play();
            mediaPlayerx.play();
        }
        else{
            mediaPlayer.play();
                image.setImage(imageO);
                
                scaleTransition = ScaleTransitionBuilder.create()
                .node(image)
                .duration(Duration.seconds(.1))
                .toX(1.2)
                .toY(1.2)
                .cycleCount(2)
                .autoReverse(true)
                .build();
              scaleTransition.play();
            
                
        }
            play.nextPlayer();
        return true;
    }

    
    public boolean isTaken()
    {
        return filled;
    }
    
    public boolean getMove()
    {
        return move;
    }
    
    public void displayCell(GridPane board, int i)
    {
        StackPane stackPane = new StackPane();
        ImageView image = new ImageView();
        image.setFitHeight(50);
        image.setFitWidth(50);
        stackPane.setStyle("-fx-background-color: black; -fx-padding: 0.1;");
        if (isTaken() && getMove())
            {
                image.setImage(imageX);
            }
            else if (isTaken())
            {
                image.setImage(imageO);
            }
            else 
            {
                image.setImage(imageN);
            }
        image.setOnMouseClicked(event -> {
            
            while(makeMove(image));
            play.getCurrentPlayer();
            parent.checkBoard();
            play.selectActiveBoard(rowX*3 + columnY);
            play.getPlayer();
            
        });
        
        stackPane.getChildren().add(image);
        board.addRow(i, stackPane);
    }
}
