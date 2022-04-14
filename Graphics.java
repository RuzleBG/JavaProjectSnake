import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Graphics extends JPanel implements ActionListener {
    private Timer t= new Timer(100, this);

    public Graphics(){
        t.start();
    }

    public void paintComponent(java.awt.Graphics g){
        super.paintComponent(g);
        Graphics2D g2d= (Graphics2D) g;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();        
    }
    
}
