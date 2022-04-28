package V2;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;


public class GamePanel extends JPanel implements ActionListener {
    static final int SCREEN_WIDTH=600;
    static final int SCREEN_HEIGHT=600;
    static final int UNIT_SIZE=25;
    static final int GAME_UNIT= SCREEN_HEIGHT*SCREEN_HEIGHT/UNIT_SIZE;
    static final int DELAY=150;
    final int[] x=new int[GAME_UNIT];
    final int[] x1=new int[GAME_UNIT];
    final int[] y=new int[GAME_UNIT];
    final int[] y1=new int[GAME_UNIT];
    int bodyparts=3;
    int bodyparts1=3;
    int foodEaten;
    int foodEaten1;
    int appleX;
    int appleY;
    char direction='R';
    char direction1='D';
    static boolean running=false;
    Timer timer;
    Random random;


    GamePanel(){
        random=new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();


    }

    public void drawSnake(int[] x, int[] y, int bodyparts, Graphics g, String color){
        for(int i=0; i<bodyparts; i++){
            if(i==0){
                if (color=="GREEN")
                g.setColor(Color.GREEN);
                else 
                g.setColor(Color.RED);
                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            }
            else{
                if (color=="GREEN")
                g.setColor(new Color(45,180,0));
                else 
                g.setColor(new Color(180,40,0));
                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            }
        }
    }

    public void moveSnake(int [] x, int[] y, int bodyparts){
        for(int i=bodyparts; i>0; i--){
            x[i]=x[i-1];
            y[i]=y[i-1];
        }
    }
    public void changeDirection(int [] x, int [] y, int direction){

        switch (direction){
            case 'U':
                y[0]= y[0]-UNIT_SIZE;
                break;
            case 'D':
                y[0]=y[0]+UNIT_SIZE;
                break;
            case 'L':
                x[0]=x[0]-UNIT_SIZE;
                break;
            case 'R':
                x[0]=x[0]+UNIT_SIZE;
                break;
        }
        
    }
    public int checkSnakeFood(int[] x, int[] y, int bodyparts){
        if((x[0]==appleX) && (y[0]==appleY)){
            System.out.println(bodyparts);
            this.foodEaten++;
            bodyparts++;
            newFood();
        }
        return bodyparts;
    }
    public void checkSnakeCollisionBody(int[] x, int[] y, int bodyparts){
        for(int i=bodyparts; i>0; i--){
            if((x[0]==x[i]) && (y[0]==y[i])){
                running=false;
            }
        }
    }

    public void checkSnakeCollisionWall(int[] x, int[] y, int bodyparts){
        if(x[0]<0){
            running=false;
        }
        if(x[0]>SCREEN_WIDTH-1){
            running=false;
        }
        if(y[0]<0){
            running=false;
        }
        if(y[0]>SCREEN_HEIGHT-1){
            running=false;
        }

    }

    public void startGame(){
        running=true;
        newFood();
        timer=new Timer(DELAY, this);
        timer.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){

        if(running){
            for(int i=0; i<SCREEN_HEIGHT/UNIT_SIZE; i++){
                g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
                g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
            }
            g.setColor(Color.red);
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

            drawSnake(x, y, bodyparts, g, "GREEN");
            drawSnake(x1, y1, bodyparts1, g, "RED");
        }
        else{gameOver(g);}
        
    }
    public void newFood(){
        appleX=random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
        appleY=random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
        

    }

    public void move(){
        moveSnake(x, y, bodyparts);
        moveSnake(x1, y1, bodyparts1);
        changeDirection(x,y,direction);
        changeDirection(x1,y1,direction1);
    }

    public void checkFood(){
        
        bodyparts=checkSnakeFood(x, y, bodyparts);
        bodyparts1=checkSnakeFood(x1, y1, bodyparts1);
    }


    public void checkCollision(){

        checkSnakeCollisionBody(x,y,bodyparts);
        checkSnakeCollisionBody(x1,y1,bodyparts1);
        checkSnakeCollisionWall(x, y, bodyparts);
        checkSnakeCollisionWall(x1, y1, bodyparts1);

        if(running==false){
            timer.stop(); 
        }
    }
    
    public void gameOver(Graphics g){
        JOptionPane.showMessageDialog(null, "Gamer Over! You Scored " + (foodEaten)+ " Points!");

    }

    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            switch(e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    if(direction!='R'){
                        direction='L';
                        break;
                    }
                case KeyEvent.VK_RIGHT:
                    if(direction!='L'){
                        direction='R';
                        break;
                    }
                case KeyEvent.VK_UP:
                    if(direction!='D'){
                        direction='U';
                        break;
                    }
                case KeyEvent.VK_DOWN:
                    if(direction!='U'){
                        direction='D';
                        break;
                    }
                    case KeyEvent.VK_A:
                    if(direction1!='R'){
                        direction1='L';
                        break;
                    }
                case KeyEvent.VK_D:
                    if(direction1!='L'){
                        direction1='R';
                        break;
                    }
                case KeyEvent.VK_W:
                    if(direction1!='D'){
                        direction1='U';
                        break;
                    }
                case KeyEvent.VK_S:
                    if(direction1!='U'){
                        direction1='D';
                        break;
                    }
                
            }
        }
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(running){
            move();
            checkFood();
            checkCollision();
        }
        repaint();        
    }
    
}
