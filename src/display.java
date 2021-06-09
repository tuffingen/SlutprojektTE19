import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.util.Random;


public class display extends Canvas implements ActionListener,Runnable {

    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    static final int DELAY = 175;
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


    public display() {
        JFrame frame = new JFrame("A simple painting");
        this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
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

    public synchronized void stopGame() {
        isRunning = false;
        try {
            thread.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //    public void PaintComp(Graphics g){
//        super.paintComponent(g);
//    }
    public void draw() {
        bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        update();
        g.setColor(Color.black);
        g.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

        drawApple(g, appleX, appleY);
        for (int i = 0; i < bodyParts; i++) {
            if (i == 0) {
                g.setColor(Color.green);
                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            } else {
                g.setColor(new Color(45, 180, 0));
                //g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            }
        }

        g.dispose();
        bs.show();

    }

    private void drawApple(Graphics g, int appleX, int appleY) {
        g.setColor(Color.red);
        g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
    }

    public void newApple() {

        appleX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        appleY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
    }

    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (direction) {
            case 'U':
                y[0] = y[0] - UNIT_SIZE;
                break;
            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                break;
            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;
        }

    }

    public void checkApple() {

    }

    public void checkpoint() {
    }

    public void checkCollisions() {
        //kollar ifall huvuded krockar med kroppen
        for (int i = bodyParts; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                isRunning = false;
            }
        }
        //kollar ifall huvuded krockar med kanterna
        if (x[0] < 0) {
            isRunning = false;
        }
        if (x[0] < SCREEN_WIDTH) {
            isRunning = false;
        }
        if (x[0] < 0) {
            isRunning = false;
        }
        if (x[0] < SCREEN_HEIGHT) {
            isRunning = false;
        }
        if (!isRunning) {
            stopGame();
        }
    }

    public void gameOver() {

    }

    public void update() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (isRunning) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }

    @Override
    public void run() {
        double deltaT = 30.0 / fps;
        long lastTime = System.currentTimeMillis();

        while (isRunning) {
            long now = System.currentTimeMillis();
            if (now - lastTime > deltaT) {
                update();
                draw();
                lastTime = now;
            }

        }
        stopGame();
    }

    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if(direction != 'R') {
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(direction != 'L') {
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(direction != 'D') {
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(direction != 'U') {
                        direction = 'D';
                    }
                    break;
            }
        }
    }
}