package Controller;

import Model.Island.Island;
import Model.Player.Key;
import Model.Player.Player;
import Model.Utils.Direction;
import View.ViewGame.ViewIsland;
import View.ViewUtil.ImageLoader;
import View.ViewUtil.StartScreenSelection;
import View.ViewUtil.UIManager;

import javax.swing.*;
import java.util.ArrayList;


public class Controller implements Runnable{

    private int length;
    private Island island;
    private ViewIsland viewIsland;

    //manage rounds
    private int playerIndex = 0;
    private int nbActionDone = 0;

    // view attribute
    private final static int WIDTH = 1268, HEIGHT = 708;
    private int IMAGELENGTH = 115;
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
        return "player: " + playerIndex + " Nb actions left: " + (3 - nbActionDone);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getNbActionDone() {
        return nbActionDone;
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
       island.submerge3NotSubmergedZones();
    }

    public void actionMade() {
        nbActionDone = (nbActionDone + 1) % 3;
        if (nbActionDone == 0) {
            playerIndex = (playerIndex + 1) % 4;
            this.endRound();
        }

    }


    public void move(Direction dir){ //en fonction de la position de player

        if (island.getPlayer(playerIndex).move(dir)){


        }

    }

    public void dry(Direction dir){
        if (island.getPlayer(playerIndex).toDry(dir)){

        }
    }

    public void searchKey(){
        if (island.getPlayer(playerIndex).searchKey()){

        }
        else{
            island.submerge3NotSubmergedZones();

        }
    }

    public void takeArtefact(){


        if (island.getPlayer(playerIndex).takeArtefact()){

        }

    }

    // view controlller methdoes
    private void reset() {
        setIsland(new Island(length));
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
            } else if (input == ButtonAction.UP) {
                selectOption(true);
            } else if (input == ButtonAction.DOWN) {
                selectOption(false);
            }
        }

        // running
        else if (gameStatus == GameStatus.RUNNING) {
            if (input == ButtonAction.UP) {
                this.move(Direction.up);
            } else if (input == ButtonAction.DOWN) {
                this.move(Direction.down);
            } else if (input == ButtonAction.RIGHT) {
                this.move(Direction.right);
            } else if (input == ButtonAction.LEFT) {
                this.move(Direction.left);

            } else if (input == ButtonAction.GETARTEFACT) {
                this.takeArtefact();
            } else if (input == ButtonAction.SHAREP1) {
                this.giveKey();
            } else if (input == ButtonAction.SELECT) {
                this.nbActionDone=2;
            } else if (input == ButtonAction.KEY) {
                this.searchKey();
            } else if (input == ButtonAction.DRY_ON) {
                this.dry(Direction.same);
            } else if (input == ButtonAction.DRY_UP) {
                this.dry(Direction.up);
            } else if (input == ButtonAction.DRY_DOWN) {
                this.dry(Direction.down);
            } else if (input == ButtonAction.DRY_LEFT) {
                this.dry(Direction.left);
            } else if (input == ButtonAction.DRY_RIGHT) {
                this.dry(Direction.right);
            }
            this.actionMade();
        }
        else if(input == ButtonAction.GO_TO_START_SCREEN){
            reset();
        }
    }

    private void giveKey() {
        if (this.island.getPlayer(getCurrPlayerIndex()).getKeys().size()>0) {
            Key key = getCurrPlayer().getKeys().get(0);
            for (Player player : this.island.getPlayers()){
                if(player.getPosition()==getCurrPlayer().getPosition()){
                    player.getKeys().add(key);
                    getCurrPlayer().getKeys().remove(key);
                }
            }
        }
    }

    public int getWidth(){
        return  WIDTH;
    }

    public int getHeight(){
        return  HEIGHT;
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
        if (isWinning()) {
            setGameStatus(GameStatus.MISSION_PASSED);
        }
    }

    private boolean isGameOver() {
        if(gameStatus == GameStatus.RUNNING){
            return island.isGameOver();
        }
        return false;
    }

    private boolean isWinning(){
        if(gameStatus == GameStatus.RUNNING) {
            return island.isWinning();
        }
        return false;
    }



    public int getCurrPlayerIndex() {
        return  this.playerIndex;
    }

    public Player getCurrPlayer() {
        return this.island.getPlayers().get(playerIndex);
    }

    public ArrayList<Key> getCurrPlayerKeys(){
        return this.getCurrPlayer().getKeys();
    }

    public void selectLevel() {
        //TODO
    }


    public static void main(String... args) {
        Island island = new Island(6);
        new Controller(island);
    }


    public int getNbActionsLeft() {
        return  3-this.nbActionDone;
    }
}







