package View.Command;

import View.ViewCommand;

public abstract class Button extends ViewCommand {
    private String text;
    private int width,height;
    private int x,y; // for postion


    public Button(String text, int width, int height, int x, int y) {
        super(text,width,height);
    }

    public void leftClic() {
    }

    public void rightClic() {
    }
}
