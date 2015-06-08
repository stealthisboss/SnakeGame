/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

/**
 *
 * @author alded3306
 */
public class SnakeGame extends JComponent implements KeyListener {

    // Height and Width of our game
    static final int WIDTH = 1000;
    static final int HEIGHT = 800;
    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    //Rectangle[] anArray= new Rectangle[5]; 
    long desiredFPS = 10;
    long desiredTime = (1000) / desiredFPS;
    int xspeed = 0;
    int yspeed = 0;
    int speed = 30;
    boolean up = false;
    boolean down = false;
    boolean right = false;
    boolean left = false;
    Color red = new Color(237, 24, 24);
    Color lime = new Color(113, 201, 36);
    Color orange = new Color(245, 85, 5);
    int randNum = (int)(Math.random()*(1000-1+1))+1;
    int randNum2 = (int)(Math.random()*(800-1+1))+1;
    int q = randNum;
    int r = randNum2;
   
    Rectangle player = new Rectangle(400,300,30,30);
    Rectangle food = new Rectangle(q, r, 30, 30);
   
    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)

    @Override
    public void paintComponent(Graphics g) {
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);

        // GAME DRAWING GOES HERE 
        g.setColor(lime);
        g.fillRect(0, 0, 1000, 800);
        
        g.setColor(orange);
        g.fillRect(player.x, player.y, player.width, player.height);
        g.setColor(red);
        g.fillRect(q, r, 30, 30);
        // GAME DRAWING ENDS HERE
    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void run() {
        // Used to keep track of time used to draw and update the game
        // This is used to limit the framerate later on
        long startTime;
        long deltaTime;
//        anArray[0] = player;
//        anArray[1] = player;
//        anArray[2] = player;
//        anArray[3] = player;
//        anArray[4] =player;
//        anArray[5] =player;
        
        
        // the main game loop section
        // game will end if you set done = false;
        boolean done = false;
        while (!done) {
            // determines when we started so we can keep a framerate
            startTime = System.currentTimeMillis();

            // all your game rules and move is done in here
            // GAME LOGIC STARTS HERE 
            //while(down1 up1 = false);
            
            {
//            if(player.intersects(food))
//            {
//                player + anArray;   
//            }
                
                
                
                
                
                if (down == true && yspeed == 0) {
                yspeed = speed;
                xspeed = 0;
                       
            }
            else if (up == true && yspeed == 0) {
                yspeed = -speed;
                xspeed = 0;
            }
            else if (right == true && xspeed == 0) {
                xspeed = speed;
                yspeed = 0;
            }
           else if (left == true && xspeed == 0) {
                xspeed = -speed;
                yspeed = 0;
                
            }
            }
            
            player.x += xspeed;
            player.y += yspeed;
            if (player.x < -50) // moving off the left hand side
            {
                break;
//                System.out.println("GaMe oVeR");
            }
            if (player.x + 0 > WIDTH) // off the right hand side
            {
                break;
//                System.out.println("GaMe oVeR");
            }
            if (player.y < -50) // moving off the left hand side
            {
                break;
//                System.out.println("GaMe oVeR");
            }
            if (player.y + 0 > HEIGHT) // off the right hand side
            {
                break;
//                System.out.println("GaMe oVeR");
            }


            // GAME LOGIC ENDS HERE 

            // update the drawing (calls paintComponent)
            repaint();



            // SLOWS DOWN THE GAME BASED ON THE FRAMERATE ABOVE
            // USING SOME SIMPLE MATH
            deltaTime = System.currentTimeMillis() - startTime;
            if (deltaTime > desiredTime) {
                //took too much time, don't wait
            } else {
                try {
                    Thread.sleep(desiredTime - deltaTime);
                } catch (Exception e) {
                };
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates a windows to show my game
        JFrame frame = new JFrame("My Game");

        // creates an instance of my game
        SnakeGame game = new SnakeGame();
        // sets the size of my game
        game.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // adds the game to the window
        frame.add(game);

        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);

        frame.addKeyListener(game);
        // starts my game loop
        game.run();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_RIGHT) {
            right = true;
        } else if (keyCode == KeyEvent.VK_UP) {
            up = true;
        } else if (keyCode == KeyEvent.VK_LEFT) {
            left = true;
        } else if (keyCode == KeyEvent.VK_DOWN) {
            down = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_RIGHT) {
            right = false;
        } else if (keyCode == KeyEvent.VK_UP) {
            up = false;
        } else if (keyCode == KeyEvent.VK_LEFT) {
            left = false;
        } else if (keyCode == KeyEvent.VK_DOWN) {
            down = false;
        }
    }
}
