package View.Button;

import Controller.Controller;

import java.awt.*;

public class EndRound extends Button {

    public EndRound(Controller controller) {
        super(controller, "endRound",45,20,10,10);
    }


    @Override
    public void leftClic() {
        super.setColor(Color.green);
        super.getController().endRound();
    }




}
