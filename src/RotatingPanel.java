import processing.core.PApplet;

import static processing.core.PApplet.print;

public class RotatingPanel extends Panel implements Clickable, Info {
    private float degrees;
    private boolean rotate;

    static int count = 0;

    public RotatingPanel(int _x, int _y, int _w, int _h, int _identifier, String _name) {
        super(_x, _y, _w, _h, _identifier, _name); //calling the super/parent class constructor
        degrees = 1;
        rotate = false;
    }


    public void display() {
        if (!rotate) {
            super.display();
            Main.app.fill(0);
            Main.app.textAlign(Main.app.CENTER);
        } else {
            Main.app.imageMode(Main.app.CENTER);
            int x = getX();
            int y = getY();
            setX(0);
            setY(0);
            Main.app.push();
            Main.app.translate(x + getWidth()/2, y + getHeight()/2);
            Main.app.rotate(Main.app.radians(degrees));
            degrees+=10;
            super.display();
            Main.app.pop();
            setX(x);
            setY(y);
            Main.app.imageMode(Main.app.CORNER);
        }
    }

    public void handleMouseClicked(int _x, int _y) {
        if (_x > getX() && _x < getX() + getWidth() && _y > getY() && _y < getY() + getHeight()) {
            rotate = !rotate;
            info(getWidth(), getHeight());
        }
    }

    public void info(int _w, int _h){
        if(count == 0){
            count++;
            print("These are PNGs of fire extinguishers, sized " + getWidth() + " by " + getHeight() + ". Thanks for making them spin! ");
        }
        if(count > 0){
            print("Again! ");
        }

    }
}