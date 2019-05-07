
import javafx.scene.layout.Pane;


public class PlayGround {
    private boolean player = true;
    private int activeBoard = 9;
    PlayerPane currentP;
    
    public boolean getPlayer()
    {
        return player;
    }
    
    public void nextPlayer()
    {
        player = !player;
    }
    public void resetPlayer(){
        player = true;
    }
    
    public void selectActiveBoard(int b)
    {
        activeBoard = b;
    }
    
    public int getActiveBoard()
    {
        return activeBoard;
    }
    
    public void importPane(PlayerPane newPane){
        currentP = newPane;
    }
    
    public void getCurrentPlayer()       
    {
    currentP.getCurrentPlayer();
    }
    
    public PlayerPane getCurrentPlayerPane(){
    
    return currentP;
    }
}
