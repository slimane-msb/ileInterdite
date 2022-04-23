package Controller;

import Model.Island.Island;
import Model.Utils.Direction;

import javax.swing.*;

public class GameEngine {  //choix de pas implement runnalble donc pas de thread et met methodes en public au lieu de private
    private final static int WIDTH = 1000, HEIGHT = 700;

    private Island island;
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

    private void createIsland() {
        setGameStatus(GameStatus.RUNNING);
        Island island = new Island(10, setLevel(getSelectedLevel()));

    }

    private float setLevel(int selectedLevel) {
        if (selectedLevel == 0){
            return (float) 0.6;
        }
        else if (selectedLevel == 1){
            return (float) 0.5;
        }
        else return (float) 0.4;
    }


    public void selectLevel(boolean selectUp) {
        changeSelectedLevel(selectUp);
        startGame();
    }

    public void startGame() {
        if (gameStatus != GameStatus.GAME_OVER) {
            setGameStatus(GameStatus.RUNNING);
            createIsland();
        }
    }

    private boolean isGameOver() {
        if (island.isSubmerged()){
            gameStatus = GameStatus.GAME_OVER;
        }
        return (gameStatus == GameStatus.GAME_OVER);
    }

    private boolean isWinning() {
        //TODO (condition pour mettre status en mission passed) emilie
        return (gameStatus == GameStatus.MISSION_PASSED);
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

    /**
    public void endRound() {
        int[][] zonesNb = island.submerge3NotSubmergedZones();
        this.ViewIsland.submerge3ViewZones(
                this.viewIsland.getViewZones(zonesNb[0][0], zonesNb[0][1]),
                this.viewIsland.getViewZones(zonesNb[1][0], zonesNb[1][1]),
                this.viewIsland.getViewZones(zonesNb[2][0], zonesNb[2][1]));
    }

     proposition : dans le uiManager : le simple fait d'avoir changé l'état des zones devrait changer leur affichage
     public void endRound(){
        island.submerge3NotSubmergedZones();
     }


    public void actionMade() {
        if (currRound == 2) {
            playerIndex = (playerIndex + 1) % 4;
            this.endRound();
        }
        currRound = (currRound + 1) % 3;

    } */



    public static void main(String... args) {
        new GameEngine();
    }


}
