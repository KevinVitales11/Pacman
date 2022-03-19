import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pacman here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pacman extends Actor
{   private static final int MAX_COUNTER_MOUTH=10;
     private static final int MAX_COUNTER_MOVE=6;
    private static final int OFFSET = 10;
    private static final int UP = 0;
    private static final int DOWN = 1;
    private static final int LEFT = 2;
    private static final int RIGHT = 3;
    private GreenfootImage []images;
    private int currentImage;
    private int score = 0;
    private int counterMouth;
     private int counterMove;
     private int direction;
    private int offsetX=0;
    private int offsetY=0;
    private PacmanHud pacmanHud;
    
    public Pacman(PacmanHud pacmanHud){
        images = new GreenfootImage[2];
        images[0]= new GreenfootImage("images/pacman-close.png");
        images[1]= new GreenfootImage("images/pacman-open.png");
        this.pacmanHud=pacmanHud;
     
    }
    public void act()
    {    
         openCloseMouth();
         movePacman();
           
       checkColisions();
    }
    private void checkColisions(){
    Item item = (Item)getOneIntersectingObject(Item.class);
       if (item != null){
        getWorld().removeObject(item);
        score += item.getScore();
        pacmanHud.setScore(score);
        
        if (getWorld().getObjects(Item.class).isEmpty()){
        offsetX = 0;
        offsetY = 0;
        getWorld().showText("YOU WIN!!",400, 250);
        
        }
        
    }
}
    
    private void openCloseMouth(){
    counterMouth++;
        if(counterMouth==MAX_COUNTER_MOUTH){
            counterMouth=0;
        setImage(images[currentImage]);
        currentImage=(currentImage+1)% images.length;
        }
    }
    private void movePacman(){
        counterMove ++;
        if(counterMove < MAX_COUNTER_MOVE){
        return;
        } 
        
        
        
        int currentX=getX();
        int currentY=getY();
        
        counterMove = 0;
        handleDirection();
        Actor wall = getWallOnTheWay();
        
        
        if(wall == null){
        setLocation(currentX + offsetX,currentY+offsetY);
        }
        
        
        
        
    }
    
    private void handleDirection(){
    
    if(Greenfoot.isKeyDown("UP")){
            offsetX = 0; 
            offsetY = - OFFSET;
           direction = UP;
        }else if(Greenfoot.isKeyDown("DOWN")){
            offsetX = 0; 
            offsetY = OFFSET;
            direction = DOWN;
        }else if(Greenfoot.isKeyDown("RIGHT")){
            offsetY = 0; 
            offsetX = OFFSET;
            direction = RIGHT;
        }else if(Greenfoot.isKeyDown("LEFT")){
            offsetY = 0; 
            offsetX = -OFFSET;
            direction = LEFT;
        }
    
    }
    
    private Wall getWallOnTheWay(){
    
    
        switch(direction){
        case UP:
            return (Wall)getOneObjectAtOffset(0,-30,Wall.class);
            
        case DOWN:
             return (Wall)getOneObjectAtOffset(0,30,Wall.class);
             
        case RIGHT:
             return (Wall)getOneObjectAtOffset(30,0,Wall.class);
            
        case LEFT:

             return (Wall)getOneObjectAtOffset(-30,0,Wall.class);     
        
        }
    return null;
    }
}
