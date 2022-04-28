package V2;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;


public class GamePanel extends JPanel implements ActionListener {
<<<<<<< HEAD
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
=======
    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNIT = SCREEN_HEIGHT*SCREEN_HEIGHT/UNIT_SIZE;
    static final int DELAY = 100;
    final int[] x = new int[GAME_UNIT];
    final int[] x1 = new int[GAME_UNIT];
    final int[] y = new int[GAME_UNIT];
    final int[] y1 = new int[GAME_UNIT];
    int bodyparts = 3;
    int bodyparts1 = 3;
>>>>>>> 4c5e08b7aa63729c4bba6c8b425b7604efdcd568
    int foodEaten;
    int foodEaten1;
    int appleX;
    int appleY;
    int obstacleX;
    int obstacleY;
    int obstacleX1;
    int obstacleY1;
    char direction='R';
    char direction1='D';
    static boolean running = false;
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
                if (color.equals("GREEN"))
                g.setColor(Color.GREEN);
                else 
                g.setColor(Color.RED);
                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            }
            else{
                if (color.equals("GREEN"))
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
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
        g.setColor(Color.white);
        g.setFont(new Font("serif", Font.BOLD, 25));
        g.drawString("Score: " + foodEaten, 20, 40);
    }
    public void draw(Graphics g){

        if(running){
            for(int i = 0; i < SCREEN_HEIGHT/UNIT_SIZE; i++){
                g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
                g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
            }
            g.setColor(Color.red);
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

            drawSnake(x, y, bodyparts, g, "GREEN");
            drawSnake(x1, y1, bodyparts1, g, "RED");
            
            if (foodEaten >= 10){
                g.setColor(Color.cyan);
                g.fillRect(obstacleX, obstacleY, UNIT_SIZE, UNIT_SIZE);
                g.fillRect(obstacleX1, obstacleY1, UNIT_SIZE, UNIT_SIZE);
            }
        }
        else{gameOver(g);}
    }
    
    public void newObstacle(){
        obstacleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
        obstacleY = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
        obstacleX1 = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
        obstacleY1 = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
    }
    
    public void newFood(){
        appleX=random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
        appleY=random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
    }

    public void move(){
<<<<<<< HEAD
        moveSnake(x, y, bodyparts);
        moveSnake(x1, y1, bodyparts1);
        changeDirection(x,y,direction);
        changeDirection(x1,y1,direction1);
=======
        for(int i=bodyparts; i>0; i--){
            x[i]=x[i-1];
            y[i]=y[i-1];
        }

        for(int i=bodyparts1; i>0; i--){
            x1[i]=x1[i-1];
            y1[i]=y1[i-1];

        }

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
        switch (direction1){
            case 'U':
                y1[0]= y1[0]-UNIT_SIZE;
                break;
            case 'D':
                y1[0]=y1[0]+UNIT_SIZE;
                break;
            case 'L':
                x1[0]=x1[0]-UNIT_SIZE;
                break;
            case 'R':
                x1[0]=x1[0]+UNIT_SIZE;
                break;
        }
        
    }
    public int checkSnakeFood(int[] x, int[] y, int bodyparts){
        if((x[0]==appleX) && (y[0]==appleY)){
            System.out.println(bodyparts);
            this.foodEaten++;
            bodyparts++;
            newObstacle();
            newFood();
        }
        return bodyparts;
>>>>>>> 4c5e08b7aa63729c4bba6c8b425b7604efdcd568
    }

    public void checkFood(){
        bodyparts = checkSnakeFood(x, y, bodyparts);
        bodyparts1 = checkSnakeFood(x1, y1, bodyparts1);
    }

<<<<<<< HEAD
=======
    public void checkSnakeCollisionBody(int[] x, int[] y, int bodyparts){
        for(int i = bodyparts; i > 0; i--){
            if((x[0]==x[i]) && (y[0]==y[i])){
                running = false;
            }
        }
    }
    
    public void checkObstacleCollisionBody(int[] x, int[] y, int bodyparts){
        if((x[0]==obstacleX) && (y[0]==obstacleY)){
            running = false;
        }
        if((x[0]==obstacleX1) && (y[0]==obstacleY1)){
            running = false;
        }
    }

    public void checkSnakeCollisionWall(int[] x, int[] y, int bodyparts){
        if(x[0] < 0){
            running = false;
        }
        if(x[0] > SCREEN_WIDTH-1){
            running = false;
        }
        if(y[0] < 0){
            running = false;
        }
        if(y[0] > SCREEN_HEIGHT-1){
            running = false;
        }
    }
>>>>>>> 4c5e08b7aa63729c4bba6c8b425b7604efdcd568

    public void checkCollision(){

        checkSnakeCollisionBody(x, y, bodyparts);
        checkSnakeCollisionBody(x1, y1, bodyparts1);
        checkSnakeCollisionWall(x, y, bodyparts);
        checkSnakeCollisionWall(x1, y1, bodyparts1);
        
        checkObstacleCollisionBody(x, y, bodyparts);
        checkObstacleCollisionBody(x1, y1, bodyparts1);

        if(!running){
            timer.stop(); 
        }
    }
    
    public void gameOver(Graphics g){
<<<<<<< HEAD
        JOptionPane.showMessageDialog(null, "Gamer Over! You Scored " + (foodEaten)+ " Points!");

=======
        int result = JOptionPane.showConfirmDialog(null, "Gamer Over! You Scored " + (foodEaten)+ " Points!"
                + "\n Would you like to restart?", "Game Over" , JOptionPane.YES_NO_OPTION);

        if (result  == JOptionPane.YES_OPTION) {
            // YES button was pressed
            new GameFrame();
        } else {
            System.exit(0);
        }
>>>>>>> 4c5e08b7aa63729c4bba6c8b425b7604efdcd568
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
