package main;

import Controller.Controleur;
import Model.Island.Island;
import View.*;
import View.Command.SearchKey;
import View.Command.ToDry;

public class Main {
    public static void main(String[] args) {
        Island island = new Island(10);
        Controleur controleur = new Controleur(island);
    }
}






