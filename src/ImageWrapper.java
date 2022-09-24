import processing.core.PApplet;
import processing.core.PImage;

public abstract class ImageWrapper {

    private int x;
    private int y;
    private int w;
    private int h;
    private int identifier;

    private String name;

    ImageWrapper(int _x, int _y, int _w, int _h, int _identifier, String _name){
        x = _x;
        y = _y;
        w = _w;
        h = _h;
        identifier = _identifier;
        name = _name;
    }



    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setX(int _x){
        x = _x;
    }

    public void setY(int _y){
        y = _y;
    }

    public int getWidth(){
        return w;
    }

    public int getHeight(){
        return h;
    }

}
