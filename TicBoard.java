import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.effect.BlendMode;
import javafx.scene.Group;

import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class TicBoard{
    private TicBoard[][] parent;
    private boolean filled = false;
    private char move;
    private PlayerPane currentPlayer;
    private Image imageX = new Image("Images/X.png");
    private Image imageO = new Image("Images/O.png");
    private Image imageN = new Image("Images/null.png");
    Rectangle grayRect = new Rectangle(150, 150);
    
    private Cell cell[][] = new Cell [3][3];
    private GridPane board = new GridPane();
    private GridPane bigBoard = new GridPane();
    Group overlaid = new Group();
    
   public TicBoard(PlayGround play, TicBoard[][] par)
   {
       parent = par;
       currentPlayer = play.getCurrentPlayerPane();
       for (int i = 0; i < 3; i++)
           for (int j = 0; j < 3; j++)
           {
                cell[i][j] = new Cell(play, this);
                cell[i][j].setRowX(i);
                cell[i][j].setColumnY(j);
           }
   }
   
   
    public TicBoard(TicBoard t)
    {
        
        
        
    }

    
    public GridPane setBoard(GridPane bBoard)
    {
        bigBoard = bBoard;
        for (int i = 0; i < 3; i++)
           for (int j = 0; j < 3; j++)
           {
               cell[i][j].displayCell(board, i);
           }
        board.setStyle("-fx-background-color: black; -fx-padding: 1;");
        return board;
    }
    
   /* public boolean makeMove(boolean m, int i, int j)
    {
        return cell[i][j].makeMove(m);
    }
    */
    
    public void checkBoard()
    {
        boolean flag = false;
        ImageView image = new ImageView();
        image.setFitHeight(150.04);
        image.setFitWidth(150.04);
        
        
        
        
               if (((cell[0][0].getMove() == true) && (cell[1][0].getMove() == true) && (cell[2][0].getMove() == true) && cell[0][0].isTaken() && cell[1][0].isTaken() && cell[2][0].isTaken()) 
                       || ((cell[0][1].getMove() == true) && (cell[1][1].getMove() == true) && (cell[2][1].getMove() == true) && cell[0][1].isTaken() && cell[1][1].isTaken() && cell[2][1].isTaken())
                       || ((cell[0][2].getMove() == true) && (cell[1][2].getMove() == true) && (cell[2][2].getMove() == true) && cell[0][2].isTaken() && cell[1][2].isTaken() && cell[2][2].isTaken())
                       || ((cell[0][0].getMove() == true) && (cell[0][1].getMove() == true) && (cell[0][2].getMove() == true) && cell[0][0].isTaken() && cell[0][1].isTaken() && cell[0][2].isTaken())
                       || ((cell[1][0].getMove() == true) && (cell[1][1].getMove() == true) && (cell[1][2].getMove() == true) && cell[1][0].isTaken() && cell[1][1].isTaken() && cell[1][2].isTaken())
                       || ((cell[2][0].getMove() == true) && (cell[2][1].getMove() == true) && (cell[2][2].getMove() == true) && cell[2][0].isTaken() && cell[2][1].isTaken() && cell[2][2].isTaken())
                       || ((cell[0][0].getMove() == true) && (cell[1][1].getMove() == true) && (cell[2][2].getMove() == true) && cell[0][0].isTaken() && cell[1][1].isTaken() && cell[2][2].isTaken())
                       || ((cell[0][2].getMove() == true) && (cell[1][1].getMove() == true) && (cell[2][0].getMove() == true) && cell[0][2].isTaken() && cell[1][1].isTaken() && cell[2][0].isTaken())               
                       )
               {
                   image.setImage(imageX);
                   filled = true;
                   move = 'x';
                   board.getChildren().clear();
                   board.getChildren().add(image);
 
               }
               

               
               
               if (((cell[0][0].getMove() == false) && (cell[1][0].getMove() == false) && (cell[2][0].getMove() == false) && cell[0][0].isTaken() && cell[1][0].isTaken() && cell[2][0].isTaken()) 
                       || ((cell[0][1].getMove() == false) && (cell[1][1].getMove() == false) && (cell[2][1].getMove() == false) && cell[0][1].isTaken() && cell[1][1].isTaken() && cell[2][1].isTaken())
                       || ((cell[0][2].getMove() == false) && (cell[1][2].getMove() == false) && (cell[2][2].getMove() == false) && cell[0][2].isTaken() && cell[1][2].isTaken() && cell[2][2].isTaken())
                       || ((cell[0][0].getMove() == false) && (cell[0][1].getMove() == false) && (cell[0][2].getMove() == false) && cell[0][0].isTaken() && cell[0][1].isTaken() && cell[0][2].isTaken())
                       || ((cell[1][0].getMove() == false) && (cell[1][1].getMove() == false) && (cell[1][2].getMove() == false) && cell[1][0].isTaken() && cell[1][1].isTaken() && cell[1][2].isTaken())
                       || ((cell[2][0].getMove() == false) && (cell[2][1].getMove() == false) && (cell[2][2].getMove() == false) && cell[2][0].isTaken() && cell[2][1].isTaken() && cell[2][2].isTaken())
                       || ((cell[0][0].getMove() == false) && (cell[1][1].getMove() == false) && (cell[2][2].getMove() == false) && cell[0][0].isTaken() && cell[1][1].isTaken() && cell[2][2].isTaken())
                       || ((cell[0][2].getMove() == false) && (cell[1][1].getMove() == false) && (cell[2][0].getMove() == false) && cell[0][2].isTaken() && cell[1][1].isTaken() && cell[2][0].isTaken())
                       )
               {
                   image.setImage(imageO);
                   filled = true;
                   move = 'o';
                   board.getChildren().clear();
                   board.getChildren().add(image);
     
               }             
               
            for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++)
           {
               if(!cell[i][j].isTaken())
               {
                   flag = true;
               }
           }
            if (flag == false)
            {
                filled = true;
                //System.out.println(i);
            }
    }
            checkBigBoard();
               
    }

    public void checkBigBoard()
    {
        boolean flag = false;
        ImageView image = new ImageView();
        image.setFitHeight(450);
        image.setFitWidth(450);
        
    
    
    
        
        if (((parent[0][0].getMove() == 'x') && (parent[1][0].getMove() == 'x') && (parent[2][0].getMove() == 'x') && parent[0][0].isTaken() && parent[1][0].isTaken() && parent[2][0].isTaken()) 
                           || ((parent[0][1].getMove() == 'x') && (parent[1][1].getMove() == 'x') && (parent[2][1].getMove() == 'x') && parent[0][1].isTaken() && parent[1][1].isTaken() && parent[2][1].isTaken())
                           || ((parent[0][2].getMove() == 'x') && (parent[1][2].getMove() == 'x') && (parent[2][2].getMove() == 'x') && parent[0][2].isTaken() && parent[1][2].isTaken() && parent[2][2].isTaken())
                           || ((parent[0][0].getMove() == 'x') && (parent[0][1].getMove() == 'x') && (parent[0][2].getMove() == 'x') && parent[0][0].isTaken() && parent[0][1].isTaken() && parent[0][2].isTaken())
                           || ((parent[1][0].getMove() == 'x') && (parent[1][1].getMove() == 'x') && (parent[1][2].getMove() == 'x') && parent[1][0].isTaken() && parent[1][1].isTaken() && parent[1][2].isTaken())
                           || ((parent[2][0].getMove() == 'x') && (parent[2][1].getMove() == 'x') && (parent[2][2].getMove() == 'x') && parent[2][0].isTaken() && parent[2][1].isTaken() && parent[2][2].isTaken())
                           || ((parent[0][0].getMove() == 'x') && (parent[1][1].getMove() == 'x') && (parent[2][2].getMove() == 'x') && parent[0][0].isTaken() && parent[1][1].isTaken() && parent[2][2].isTaken())
                           || ((parent[0][2].getMove() == 'x') && (parent[1][1].getMove() == 'x') && (parent[2][0].getMove() == 'x') && parent[0][2].isTaken() && parent[1][1].isTaken() && parent[2][0].isTaken())               
                           )
        {
           image.setImage(imageX);
           bigBoard.getChildren().clear();
           bigBoard.getChildren().add(image);
           currentPlayer.getWinnerX();
        }
    
        if (((parent[0][0].getMove() == 'o') && (parent[1][0].getMove() == 'o') && (parent[2][0].getMove() == 'o') && parent[0][0].isTaken() && parent[1][0].isTaken() && parent[2][0].isTaken()) 
                           || ((parent[0][1].getMove() == 'o') && (parent[1][1].getMove() == 'o') && (parent[2][1].getMove() == 'o') && parent[0][1].isTaken() && parent[1][1].isTaken() && parent[2][1].isTaken())
                           || ((parent[0][2].getMove() == 'o') && (parent[1][2].getMove() == 'o') && (parent[2][2].getMove() == 'o') && parent[0][2].isTaken() && parent[1][2].isTaken() && parent[2][2].isTaken())
                           || ((parent[0][0].getMove() == 'o') && (parent[0][1].getMove() == 'o') && (parent[0][2].getMove() == 'o') && parent[0][0].isTaken() && parent[0][1].isTaken() && parent[0][2].isTaken())
                           || ((parent[1][0].getMove() == 'o') && (parent[1][1].getMove() == 'o') && (parent[1][2].getMove() == 'o') && parent[1][0].isTaken() && parent[1][1].isTaken() && parent[1][2].isTaken())
                           || ((parent[2][0].getMove() == 'o') && (parent[2][1].getMove() == 'o') && (parent[2][2].getMove() == 'o') && parent[2][0].isTaken() && parent[2][1].isTaken() && parent[2][2].isTaken())
                           || ((parent[0][0].getMove() == 'o') && (parent[1][1].getMove() == 'o') && (parent[2][2].getMove() == 'o') && parent[0][0].isTaken() && parent[1][1].isTaken() && parent[2][2].isTaken())
                           || ((parent[0][2].getMove() == 'o') && (parent[1][1].getMove() == 'o') && (parent[2][0].getMove() == 'o') && parent[0][2].isTaken() && parent[1][1].isTaken() && parent[2][0].isTaken())               
                           )
        {
           image.setImage(imageO);
           bigBoard.getChildren().clear();
           bigBoard.getChildren().add(image);
           currentPlayer.getWinnerO();
        }
    
        
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
           {
               if (!parent[i][j].isTaken())
               {
                    flag = true;
               }
               
           }
        
        if (flag == false)
        {
            currentPlayer.getDraw();
        }
       // grayOut();
        
        
        
        
        
        
    }
    
    
    public char getMove()
    {
        return move;
    }
    
    public boolean isTaken()
    {
        return filled;
    }
    
    public void grayOut()
    {
        grayRect.setFill(Color.GRAY);
        grayRect.setBlendMode(BlendMode.ADD);
        overlaid = new Group(new ImageView(imageN), grayRect);
    }
        
}
