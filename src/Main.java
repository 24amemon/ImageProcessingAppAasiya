import processing.core.PApplet;

import java.util.ArrayList;

import java.util.Random;

public class Main extends PApplet {
    final int NUM_PANELS_HORIZONTAL = 4;
    final int NUM_PANELS_VERTICAL = 5;
    private ArrayList<Drawable> panels;

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
        panels = new ArrayList<Drawable>();

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

                panels.add(s);
                index++;
            }
        }
    }

    public void draw() {
        fancyBackground();

        for (int i = 0; i < panels.size(); i++) {
            Drawable s = panels.get(i);
            s.display();
        }
    }

    public void mouseClicked() {
        for (int i = 0; i < panels.size(); i++) {
            if (panels.get(i) instanceof Clickable){
                ((Clickable) panels.get(i)).handleMouseClicked(mouseX, mouseY);
            }
        }
    }

    public void keyPressed(){
        if(key == 's'){
            Drawable first = panels.get(0);
            Drawable last = panels.get(panels.size() - 1);
            panels.remove(0);;
            panels.add(0, last);
            panels.remove(panels.size() - 1);
            panels.add(panels.size() - 1, first);

            int firstX = ((Panel)first).getX();
            int firstY = ((Panel)first).getY();
            int lastX = ((Panel)last).getX();
            int lastY = ((Panel)last).getY();

            ((Panel)first).setX(lastX);
            ((Panel)first).setY(lastY);
            ((Panel)last).setX(firstX);
            ((Panel)last).setY(firstY);
            //System.out.println("Switch!");
        } else if(key == 'r'){
            Random r = new Random();
            int index = r.nextInt(0, panels.size());
            Drawable brandnew = panels.get(index);
            int brandnewX = ((Panel)brandnew).getX();
            int brandnewY = ((Panel)brandnew).getY();
            if (brandnew instanceof ContrastedPanel){
                brandnew = new RotatingPanel(brandnewX, brandnewY, width / NUM_PANELS_HORIZONTAL, height / NUM_PANELS_VERTICAL, index, "data/extinguisher.png");
            } else {
                brandnew = new ContrastedPanel(brandnewX, brandnewY, width / NUM_PANELS_HORIZONTAL, height / NUM_PANELS_VERTICAL, index, "data/extinguisher.png");
            }
            panels.set(index, brandnew);
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