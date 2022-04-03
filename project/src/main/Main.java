package main;

import Controller.Controleur;
import Model.Island.Island;

public class Main {
    public static void main(String[] args) {
        Island island = new Island(10);
        Controleur controleur = new Controleur(island);
    }
}






