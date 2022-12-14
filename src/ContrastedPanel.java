import processing.core.PApplet;
import processing.core.PImage;

public class ContrastedPanel extends Panel {
    public ContrastedPanel(int _x, int _y, int _width, int _height, int _identifier, String _name) {
        super(_x, _y, _width, _height, _identifier, _name);
    }

    public void display() {
        PImage newImg = getImage().copy();
        newImg.loadPixels();

        for (int y = 0; y < newImg.height; y++) {
            for (int x = 0; x < newImg.width; x++) {
                int loc = x + y * newImg.width;
                if (Main.app.brightness(newImg.pixels[loc]) > 180) {
                    newImg.pixels[loc] = Main.app.color(255, 255);
                } else {
                    newImg.pixels[loc] = Main.app.color(0, 0);
                }
            }
        }

        newImg.updatePixels();
        Main.app.image(newImg, getX(), getY(), getWidth(), getHeight());
    }
}