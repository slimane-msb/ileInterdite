package Controller;

import Controller.Controller;
import Model.Island.Island;

public class Main {
    public static void main(String[] args) {
        Island island = new Island(10);
        Controller controller = new Controller(island);
    }
}






