import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PacmanWorld extends World
{
    private static final int WIDTH_WALL = 28;
    private static final int HEIGHT_WALL =28;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public PacmanWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Wall wall = new Wall();

        for(int x= 50 ; x <= 580; x+= WIDTH_WALL)
        {
            wall=new Wall();
            addObject(wall,x,30);
            wall=new Wall();
            addObject(wall,x,350);
        }
        for(int y= 58 ; y <= 350; y+= HEIGHT_WALL)
        {
            wall=new Wall();
            addObject(wall,50,y);
            wall=new Wall();
            addObject(wall,554  ,y);
        }


        BigBall bigBall = new BigBall();
        addObject(bigBall,195,102);
        BigBall bigBall2 = new BigBall();
        addObject(bigBall2,335,90);
        BigBall bigBall3 = new BigBall();
        addObject(bigBall3,84,290);
        Cherry cherry = new Cherry();
        addObject(cherry,456,87);
        Strawberry strawberry = new Strawberry();
        addObject(strawberry,470,129);
        Cherry cherry2 = new Cherry();
        addObject(cherry2,170,303);
        SmalBall smalBall = new SmalBall();
        addObject(smalBall,268,303);
        bigBall.setLocation(215,147);
        bigBall.setLocation(188,85);
        SmalBall smalBall2 = new SmalBall();
        addObject(smalBall2,179,170);
        SmalBall smalBall3 = new SmalBall();
        addObject(smalBall3,299,290);
        SmalBall smalBall4 = new SmalBall();
        addObject(smalBall4,383,225);
        SmalBall smalBall5 = new SmalBall();
        addObject(smalBall5,297,161);
        Strawberry strawberry2 = new Strawberry();
        addObject(strawberry2,431,279);
        Strawberry strawberry3 = new Strawberry();
        addObject(strawberry3,194,227);
        Cherry cherry3 = new Cherry();
        addObject(cherry3,254,81);
        BigBall bigBall4 = new BigBall();
        addObject(bigBall4,467,212);

        PacmanHud hud = new PacmanHud();
        addObject(hud,0,0);
        Pacman pacman = new Pacman(hud);
        addObject(pacman, 100,80);
    }
}
