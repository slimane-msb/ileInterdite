package Controller;

import Model.Utils.Direction;
import View.ImageLoader;
import View.StartScreenSelection;
import View.UIManager;

import javax.swing.*;
import java.awt.*;

public class GameEngine {  //choix de pas implement runnalble donc pas de thread et met methodes en public au lieu de private
    private final static int WIDTH = 1000, HEIGHT = 700;

    private MapManager mapManager;
    private UIManager uiManager;
    private GameStatus gameStatus;
    private boolean isRunning;
    private ImageLoader imageLoader;
    private int selectedLevel = 0;


    private GameEngine() {
        init();
    }

    private void init() {
        imageLoader = new ImageLoader();
        InputManager inputManager = new InputManager(this);
        gameStatus = GameStatus.START_SCREEN;
        uiManager = new UIManager(this, WIDTH, HEIGHT);
        mapManager = new MapManager();

        JFrame frame = new JFrame("L'île interdite");
        frame.add(uiManager);
        frame.addKeyListener(inputManager);
        frame.addMouseListener(inputManager);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        start();
    }

    private synchronized void start() {
        if (isRunning)
            return;

        isRunning = true;
    }

    private void reset() {
        setGameStatus(GameStatus.START_SCREEN);
    }

    public void changeSelectedLevel(boolean up){
        selectedLevel = uiManager.changeSelectedLevel(selectedLevel, up);
    }

    private void createMap(String path) {
        boolean loaded = mapManager.createMap(imageLoader, path);
        if(loaded){
            setGameStatus(GameStatus.RUNNING);
        }

        else
            setGameStatus(GameStatus.START_SCREEN);
    }

    private void render() {
        uiManager.repaint();
    }

    private void gameLoop() {
        updateLocations();

        if (isGameOver()) {
            setGameStatus(GameStatus.GAME_OVER);
        }

        if (mapManager.endLevel()) {
            setGameStatus(GameStatus.MISSION_PASSED);
        }
    }


    private void updateLocations() {
        mapManager.updateLocations();
    }

    public void selectLevel(boolean selectUp) {
        changeSelectedLevel(selectUp);
        startGame();
    }

    public void startGame() {
        if (gameStatus != GameStatus.GAME_OVER) {
            setGameStatus(GameStatus.RUNNING);
        }
    }

    private boolean isGameOver() {
        if(gameStatus == GameStatus.RUNNING)
            return mapManager.isGameOver();
        return false;
    }

    public ImageLoader getImageLoader() {
        return imageLoader;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public int getSelectedLevel() {
        return selectedLevel;
    }

    public void drawMap(Graphics2D g2) {
        mapManager.drawMap(g2);
    }

    public MapManager getMapManager() {
        return mapManager;
    }

    public void move(Direction dir){ //en fonction de la position de player
        //TODO emilie
    }

    public void dry(Direction dir){
        //TODO emilie
    }

    public void searchKey(){
        //TODO emilie
    }

    public void takeArtefact(){
        //TODO emilie
    }



    public static void main(String... args) {
        new GameEngine();
    }


}
