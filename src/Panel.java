import processing.core.PImage;

import static processing.core.PApplet.print;

public class Panel extends ImageWrapper implements Drawable {
    //private PImage img;
    //private int x;
    //private int y;
    //private int w;
    //private int h;
    //private int identifier;
    //private PApplet pApplet;

    private PImage img;

    Panel(int _x, int _y, int _w, int _h, int _identifier, String _name){
        super(_x, _y, _w, _h, _identifier, _name);
        img = Main.app.loadImage(_name);
    }

    public PImage getImage(){
        return img;
    }





    public void display(){
        Main.app.image(img, getX(), getY(), getWidth(), getHeight());
    }


}