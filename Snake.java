import java.util.ArrayList;
import java.awt.Rectangle;

public class Snake{
    private ArrayList<Rectangle> body=new ArrayList<>();
    String move="NO_MOVEMENT";
    Snake(){
        Rectangle temp= new Rectangle(Game.dimension, Game.dimension);
        temp.setLocation(Game.width/2, Game.height/2);
        body.add(temp);
        temp= new Rectangle(Game.dimension, Game.dimension);
        temp.setLocation((Game.width/2)-1, (Game.height/2)-1);
        body.add(temp);
        temp= new Rectangle(Game.dimension, Game.dimension);
        temp.setLocation((Game.width/2)-2, (Game.height/2)-2);
        body.add(temp);

    }
    public void up(){
        move="UP";
    }
    public void down(){
        move="DOWN";
    }
    public void right(){
        move="RIGHT";
    }
    public void left(){
        move="LEFT";
    }
}
