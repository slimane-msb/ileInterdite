package Controller;

import Model.Island.Island;
import Model.Player.Player;
import Model.Utils.Direction;
import View.ViewGame.ViewIsland;
import View.ViewUtil.ImageLoader;
import View.ViewUtil.StartScreenSelection;
import View.ViewUtil.UIManager;

import javax.swing.*;
import java.awt.*;


public class Controller implements Runnable{

    private int length;
    private Island island;
    private ViewIsland viewIsland;
    //manage rounds
    private int playerIndex = 0;
    private int nbAction = 3;
    private int currRound = 0;

    // view attribute
    private final static int WIDTH = 1268, HEIGHT = 708;
    private int IMAGELENGTH = 125;
    private UIManager uiManager;
    private GameStatus gameStatus;
    private ImageLoader imageLoader;
    private int selectedLevel = 0;
    private StartScreenSelection startScreenSelection = StartScreenSelection.START_GAME;

    // update attribute
    private boolean isRunning;
    private Thread thread;


    public Controller(Island island) {
        this.length = island.getLength();
        this.island = island;
        this.initView();
        this.viewIsland = new ViewIsland(this, island.getLength());
        System.out.println("good to go");
    }

    private void initView() {
        this.imageLoader = new ImageLoader();
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
        thread = new Thread(this);
        thread.start();
    }



    private void render() {
        uiManager.repaint();
    }


    private String gameStateString() {
        return "player: " + playerIndex + " Nb actions left: " + (3 - nbAction);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }



    public Island getIsland() {
        return island;
    }

    public void setIsland(Island island) {
        this.island = island;
    }

    public ViewIsland getViewIsland() {
        return viewIsland;
    }

    public void setViewIsland(ViewIsland viewIsland) {
        this.viewIsland = viewIsland;
    }


    /**
     * get the number of the zone we need to submerge, and then call the methode submergeView to color ble
     */
    public void endRound() {
        int[][] zonesNb = island.submerge3NotSubmergedZones();
        this.viewIsland.submerge3ViewZones(
                this.viewIsland.getViewZones(zonesNb[0][0], zonesNb[0][1]),
                this.viewIsland.getViewZones(zonesNb[1][0], zonesNb[1][1]),
                this.viewIsland.getViewZones(zonesNb[2][0], zonesNb[2][1]));
    }

    public void actionMade() {
        if (currRound == 2) {
            playerIndex = (playerIndex + 1) % 4;
            this.endRound();
        }
        currRound = (currRound + 1) % 3;

    }


    public void move(){ //en fonction de la position de player
        //TODO emilie
        //TODO emilie
        // if key= z
        // curr player.searchkeu
        // this.action made()
    }

    public void dry(){
        //TODO emilie
    }

    public void searchKey(){
        //TODO emilie
    }

    // view controlller methdoes
    private void reset() {
        setGameStatus(GameStatus.START_SCREEN);
    }
    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }


    public GameStatus getGameStatus() {
        return gameStatus;
    }

    private void selectOption(boolean selectUp) {
        startScreenSelection = startScreenSelection.select(selectUp);
    }

    private void startGame() {
        if (gameStatus != GameStatus.GAME_OVER) {
            setGameStatus(GameStatus.RUNNING);
        }
    }

    // we gonna manage inputs
    public void receiveInput(ButtonAction input) {

        if (gameStatus == GameStatus.START_SCREEN) {
            if (input == ButtonAction.SELECT && startScreenSelection == StartScreenSelection.START_GAME) {
                startGame();
            } else if (input == ButtonAction.SELECT && startScreenSelection == StartScreenSelection.VIEW_ABOUT) {
                setGameStatus(GameStatus.ABOUT_SCREEN);
            } else if (input == ButtonAction.SELECT && startScreenSelection == StartScreenSelection.VIEW_HELP) {
                setGameStatus(GameStatus.HELP_SCREEN);
            } else if (input == ButtonAction.GO_UP) {
                selectOption(true);
            } else if (input == ButtonAction.GO_DOWN) {
                selectOption(false);
            }
        }

        // running
        else if (gameStatus == GameStatus.RUNNING) {
            if (input == ButtonAction.JUMP) {
                this.move();
            } else if (input == ButtonAction.M_RIGHT) {
                this.move();
            } else if (input == ButtonAction.M_LEFT) {
                this.move();
            } else if (input == ButtonAction.ACTION_COMPLETED) {
                this.move();
            } else if (input == ButtonAction.FIRE) {
                this.move();
            } else if (input == ButtonAction.PAUSE_RESUME) {
                this.move();
            }
        }
        else if(gameStatus == GameStatus.GAME_OVER && input == ButtonAction.GO_TO_START_SCREEN){
            reset();
        } else if(gameStatus == GameStatus.MISSION_PASSED && input == ButtonAction.GO_TO_START_SCREEN){
            reset();
        }
        //

        if(input == ButtonAction.GO_TO_START_SCREEN){
            setGameStatus(GameStatus.START_SCREEN);
        }



    }

    public ImageLoader getImageLoader() {
        return this.imageLoader;
    }
    public StartScreenSelection getStartScreenSelection() {
        return startScreenSelection;
    }

    public int getIMAGELENGTH() {
        return IMAGELENGTH;
    }

    public void setIMAGELENGTH(int IMAGELENGTH) {
        this.IMAGELENGTH = IMAGELENGTH;
    }


    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();

        while (isRunning && !thread.isInterrupted()) {

            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                if (gameStatus == GameStatus.RUNNING) {
                    gameLoop();
                }
                delta--;
            }
            render();

        }
    }

    private void gameLoop() {
        //updates
        if (isGameOver()) {
            setGameStatus(GameStatus.GAME_OVER);
        }
    }

    private boolean isGameOver() {
        if(gameStatus == GameStatus.RUNNING)
            return island.isGameOver();
        return false;
    }

}







