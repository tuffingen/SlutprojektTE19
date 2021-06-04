import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.util.Random;


public class display extends Canvas implements ActionListener,Runnable{

    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 75;
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
    static final int  DELAY = 75;
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int bodyParts = 6;
    int applesEaten;
    int appleX;
    int appleY;
    char direction = 'R';
    boolean isRunning = false;
    int fps = 30;
    private Thread thread;
    private BufferStrategy bs;

    Random random;


    display(){
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(new Color(0x437B2A));
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
        stopGame();
    }

    public static void main(String[] args) {
        display painting = new display();
        painting.startGame();
    }

    public synchronized void startGame() {
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
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }


    Graphics g = bs.getDrawGraphics();
    bs.show();
    g.dispose();
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
