package View.ViewUtil;

import Controller.Controller;
import Controller.GameStatus;
import Model.Player.Artefact;
import Model.Player.Item;
import Model.Player.Key;
import View.ViewGame.ViewArteFact;
import View.ViewGame.ViewPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class UIManager extends JPanel{


    private Controller controller;
    private Font gameFont;
    private BufferedImage startScreenImage, aboutScreenImage, helpScreenImage, gameOverScreen;
    private BufferedImage selectIcon;
    private BufferedImage coinIcon;

    public UIManager(Controller controller, int width, int height) {
        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));

        this.controller = controller;
        ImageLoader loader = this.controller.getImageLoader();

        this.selectIcon = loader.loadImage("/gameStatus/select-icon.png");
        this.coinIcon = loader.loadImage("/gameStatus/select-icon.png");
        this.startScreenImage = loader.loadImage("/gameStatus/start-screen.png");
        this.helpScreenImage = loader.loadImage("/gameStatus/help-screen.png");
        this.aboutScreenImage = loader.loadImage("/gameStatus/about-screen.png");
        this.gameOverScreen = loader.loadImage("/gameStatus/game-over.png");

        try {
            InputStream in = getClass().getResourceAsStream("/media/font/player-font.ttf");
            gameFont = Font.createFont(Font.TRUETYPE_FONT, in);
        } catch (FontFormatException | IOException e) {
            gameFont = new Font("Verdana", Font.PLAIN, 12);
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        super.setBackground(new Color(70,80,200));


        Graphics2D g2 = (Graphics2D) g.create();
        GameStatus gameStatus = controller.getGameStatus();

        if(gameStatus == GameStatus.START_SCREEN){
            drawStartScreen(g2);
        }
        else if(gameStatus == GameStatus.ABOUT_SCREEN){
            drawAboutScreen(g2);
        }
        else if(gameStatus == GameStatus.HELP_SCREEN){
            drawHelpScreen(g2);
        }
        else if(gameStatus == GameStatus.GAME_OVER){
            drawGameOverScreen(g2);
        }
        else {
            drawIsland(g2);

            drawListOfPlayersNotif(g2);
            int half = (2*getWidth()/3);
            int halfH = (getHeight()*2/3);
            drawPlayer(g2,half+250,(halfH)-73,controller.getCurrPlayerIndex() ); // player for notif (current player
            drawText(g2,"player artefact: ",half-58,50);
            drawText(g2,"its round for: ",half-100,getHeight()*2/3);
            drawText(g2,"Nb Actions Left : "+controller.getNbAction(),half-122,(getHeight()*2/3)+70);
            drawText(g2,"Keys:",half-130,(halfH)+140);

            // draw player keys:
            drawPlayersArtefact(g2,(half/3)-73+105,50);
            drawCurrPlayerKeys(g2,half-130+105,(halfH)+140);

            // draw real active players
            drawListOfPlayers(g2);

            if(gameStatus == GameStatus.MISSION_PASSED){
                drawVictoryScreen(g2);
            }
        }

        g2.dispose();
    }

    private void drawListOfPlayers(Graphics2D g2) {

    }

    private void drawPlayerKeys(Graphics2D g2, double x, double y, int index) {
        int i=0;
        for (Key key: controller.getIsland().getPlayers().get(index).getKeys()){
            drawItem(g2,x+i,y,key);
            i+=100;
        }
    }

    private void drawPlayerArtefacts(Graphics2D g2, double x, double y, int index) {
        int i=0;
        for (Artefact artefact: controller.getIsland().getPlayers().get(index).getArtefacts()){
            drawItem(g2,x+i,y,artefact);
            i+=100;
        }
    }

    private void drawItem(Graphics2D g2, double x, double y, Item item) {
        switch (item.getItemType()){
            case air:
                ViewArteFact vLand = new ViewArteFact(x,y,controller.getViewIsland().getLand().getImage());
                vLand.draw(g2);
                break;
            case water:
                ViewArteFact vWater = new ViewArteFact(x,y,controller.getViewIsland().getWater().getImage());
                vWater.draw(g2);
                break;
            case earth:
                ViewArteFact vAir = new ViewArteFact(x,y,controller.getViewIsland().getAir().getImage());
                vAir.draw(g2);
                break;
            case fire:
                ViewArteFact vFire = new ViewArteFact(x,y,controller.getViewIsland().getFire().getImage());
                vFire.draw(g2);
                break;
        }

    }

    private void drawCurrPlayerKeys(Graphics2D g2,double x, double y) {
       drawPlayerKeys(g2,x,y,controller.getCurrPlayerIndex());
    }

    private void drawPlayersArtefact(Graphics2D g2,double x, double y){
        int j=0;
        for (int i=0;i<4;i++){
            // make new playuer
            drawPlayerArtefacts(g2,x,y+j,i);
            j +=105;
        }
    }

    private void drawPlayer(Graphics2D g2, double x, double y, int index){
        ViewPlayer curPlayerView = new ViewPlayer(x,y,this.controller.getViewIsland().getViewPlayers().get(index).getImage());
        curPlayerView.draw(g2);
    }

    private void drawArtefact(Graphics2D g2, double x, double y, ViewArteFact viewArteFact){
        ViewArteFact viewArteFact1 = new ViewArteFact(x,y,viewArteFact.getImage());
        viewArteFact1.draw(g2);
    }


    private void drawText(Graphics2D g2, String text, int x, int y) {
        g2.setFont(gameFont.deriveFont(25f));
        g2.setColor(Color.WHITE);
        String displayedStr = text ;
        int stringLength = g2.getFontMetrics().stringWidth(displayedStr);
        g2.drawString(displayedStr, x, y);
    }

    private void drawIsland(Graphics2D g2) {
        for (int i = 0; i < controller.getLength(); i++) {
            for (int j = 0; j < controller.getLength(); j++) {
                controller.getViewIsland().getViewZones(i,j).draw(g2);
            }
        }
    }



    private void drawVictoryScreen(Graphics2D g2) {
        g2.setFont(gameFont.deriveFont(50f));
        g2.setColor(Color.WHITE);
        String displayedStr = "YOU WON!";
        int stringLength = g2.getFontMetrics().stringWidth(displayedStr);
        g2.drawString(displayedStr, (getWidth()-stringLength)/2, getHeight()/2);
    }

    private void drawHelpScreen(Graphics2D g2) {
        g2.drawImage(helpScreenImage, 0, 0, null);
    }

    private void drawAboutScreen(Graphics2D g2) {
        g2.drawImage(aboutScreenImage, 0, 0, null);
    }

    private void drawGameOverScreen(Graphics2D g2) {
        g2.drawImage(gameOverScreen, 0, 0, null);
        g2.setFont(gameFont.deriveFont(50f));
        g2.setColor(new Color(130, 48, 48));
        String acquiredPoints = "game over!: " ;
        int stringLength = g2.getFontMetrics().stringWidth(acquiredPoints);
        int stringHeight = g2.getFontMetrics().getHeight();
        g2.drawString(acquiredPoints, (getWidth()-stringLength)/2, getHeight()-stringHeight*2);
    }

    private void drawPauseScreen(Graphics2D g2) {
        g2.setFont(gameFont.deriveFont(50f));
        g2.setColor(Color.WHITE);
        String displayedStr = "PAUSED";
        int stringLength = g2.getFontMetrics().stringWidth(displayedStr);
        g2.drawString(displayedStr, (getWidth()-stringLength)/2, getHeight()/2);
    }



    private void drawListOfPlayersNotif(Graphics2D g2) {
        int i=1;
        ViewPlayer pp1 = this.controller.getViewIsland().getViewPlayers().get(0);
        ViewPlayer p1 = new ViewPlayer(controller.getWidth()*2/3.5,(i++)*(controller.getIMAGELENGTH()-40),pp1.getImage());
        ViewPlayer pp2 = this.controller.getViewIsland().getViewPlayers().get(1);
        ViewPlayer p2 = new ViewPlayer(controller.getWidth()*2/3.5,(i++)*(controller.getIMAGELENGTH()-40),pp2.getImage());
        ViewPlayer pp3 = this.controller.getViewIsland().getViewPlayers().get(2);
        ViewPlayer p3 = new ViewPlayer(controller.getWidth()*2/3.5,(i++)*(controller.getIMAGELENGTH()-40),pp3.getImage());
        ViewPlayer pp4 = this.controller.getViewIsland().getViewPlayers().get(3);
        ViewPlayer p4 = new ViewPlayer(controller.getWidth()*2/3.5,(i++)*(controller.getIMAGELENGTH()-40),pp4.getImage());
        p1.draw(g2);
        p2.draw(g2);
        p3.draw(g2);
        p4.draw(g2);
    }



    private void drawStartScreen(Graphics2D g2){
        int row = controller.getStartScreenSelection().getLineNumber();
        g2.drawImage(startScreenImage, 0, 0, null);
        g2.drawImage(selectIcon, 375, row * 70 + 440, null);
    }


}