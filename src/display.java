import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.util.Random;


public class display extends Canvas implements ActionListener,Runnable{

    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
    static final int  DELAY = 75;
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int bodyParts = 6;
    int applesEaten;
    int appleX;
    int appleY;
    char direction = 'R';
    boolean isRunning;
    int fps = 30;
    private Thread thread;
    private BufferStrategy bs;
    Random random;


    public display(){
            JFrame frame = new JFrame("A simple painting");
            this.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
            frame.add(this);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            random = new Random();
            isRunning = false;

        }


    public static void main(String[] args) {

    }

    public synchronized void startGame() {
        newApple();
        thread = new Thread(this);
        isRunning = true;
        thread.start();
    }

    public synchronized void stopGame(){
        isRunning= false;
        try{
            thread.join();

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

//    public void PaintComp(Graphics g){
//        super.paintComponent(g);
//    }
    public void draw(){
        bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        update();
        g.setColor(Color.green);
        g.fillRect(0,0,SCREEN_WIDTH,SCREEN_HEIGHT);
        drawApple(g, appleX,appleY);
        g.dispose();
        bs.show();
      }

      private void drawApple(Graphics g, int appleX, int appleY){
        g.setColor(Color.red);
        g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
      }

    public void newApple(){

        appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
        appleY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
    }
    public void move(){

    }
    public void checkpoint(){
    }
    public void checkCollisions(){

    }
    public void gameOver(){

    }
    public void update(){

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void run() {
        double deltaT = 30.0/fps;
        long lastTime = System.currentTimeMillis();

        while (isRunning) {
            long now = System.currentTimeMillis();
            if (now-lastTime > deltaT) {
                update();
                draw();
                lastTime = now;
            }

        }
        stopGame();
    }

    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){

        }
    }


}
