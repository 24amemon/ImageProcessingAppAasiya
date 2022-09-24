import processing.core.PApplet;

public class TintedPanel extends Panel {
    TintedPanel(int _x, int _y, int _width, int _height, int _identifier, String _name) {
        super(_x, _y, _width, _height, _identifier, _name);
    }

    public void display() {
        Main.app.tint(162, 137, 179);
        super.display();
        Main.app.noTint();
    }
}