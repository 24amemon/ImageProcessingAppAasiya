import processing.core.PApplet;

public class Main extends PApplet {
    final int NUM_PANELS_HORIZONTAL = 4;
    final int NUM_PANELS_VERTICAL = 5;
    private Drawable[] panels;

    public static PApplet app;

    public Main(){
        super();
        app = this;
    }
    public static void main(String[] args){
        PApplet.main("Main");
    }
    public void settings(){
        size(600, 775);
    }
    public void setup() {
        panels = new Drawable[NUM_PANELS_HORIZONTAL * NUM_PANELS_VERTICAL];

        int index = 0;
        for (int i = 0; i < NUM_PANELS_VERTICAL; i++) {
            for (int j = 0; j < NUM_PANELS_HORIZONTAL; j++) {
                int w = width / NUM_PANELS_HORIZONTAL;
                int h = height / NUM_PANELS_VERTICAL;
                int x = j * w;
                int y = i * h;

                Drawable s = new Panel(x, y, w, h, index, "data/extinguisher.png");

                if (i % 5 == 0) {
                    s = new Panel(x, y, w, h, index, "data/extinguisher.png");
                } else if (i % 5 == 1) {
                    s = new TintedPanel(x, y, w, h, index, "data/extinguisher.png");
                } else if (i % 5 == 2) {
                    s = new ContrastedPanel(x, y, w, h, index, "data/extinguisher.png");
                } else if (i % 5 == 3){
                    s = new SomePanel(x, y, w, h, index, "data/extinguisher.png");
                } else {
                    s = new RotatingPanel(x, y, w, h, index, "data/extinguisher.png");
                }

                panels[index] = s;
                index++;
            }
        }
    }

    public void draw() {
        fancyBackground();

        for (int i = 0; i < panels.length; i++) {
            Drawable s = panels[i];
            s.display();
        }
    }

    public void mouseClicked() {
        for (int i = 0; i < panels.length; i++) {
            if (panels[i] instanceof Clickable){
                ((Clickable) panels[i]).handleMouseClicked(mouseX, mouseY);
            }
        }
    }






    private void fancyBackground() {
        loadPixels();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                pixels[x + y * width] = color(170, y / 2, x / 2);
            }
        }
        updatePixels();
    }

}