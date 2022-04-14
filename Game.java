import javax.swing.JFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game implements KeyListener{
    Snake player=new Snake();
    private JFrame window=new JFrame();

    public static final int height=30;
    public static final int width=30;
    public static final int dimension=20;
    Game(){
        window.setTitle("Snake");
        window.setSize(width*dimension, height*dimension);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    @Override
    public void keyPressed(KeyEvent e) {
        int keycode=e.getKeyCode();
        if(keycode==KeyEvent.VK_W){
            player.up();
        }
        if(keycode==KeyEvent.VK_A){
            player.left();
        }
        if(keycode==KeyEvent.VK_S){
            player.down();
        }
        if(keycode==KeyEvent.VK_D){
            player.right();
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {}
    
    @Override
    public void keyReleased(KeyEvent e){}
}