package View.ViewUtil;

import Controller.Controller;
import Controller.GameStatus;
import View.ViewGame.ViewPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

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
            drawPlayerKeyText(g2);
            drawListOfPlayersNotif(g2);

            // add more like draw point...

            if(gameStatus == GameStatus.MISSION_PASSED){
                drawVictoryScreen(g2);
            }
        }

        g2.dispose();
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

    private void drawPlayerKeyText(Graphics2D g2){
        g2.setFont(gameFont.deriveFont(25f));
        g2.setColor(Color.WHITE);
        String displayedStr = "player Keys: " ;//+ controller.getScore();
        int stringLength = g2.getFontMetrics().stringWidth(displayedStr);
        g2.drawString(displayedStr, 2*getWidth()/3, 50);
    }

    private void drawListOfPlayersNotif(Graphics2D g2){
       for (ViewPlayer viewPlayer : this.controller.getViewIsland().getViewPlayers())
           viewPlayer.draw(g2);
    }



    private void drawStartScreen(Graphics2D g2){
        int row = controller.getStartScreenSelection().getLineNumber();
        g2.drawImage(startScreenImage, 0, 0, null);
        g2.drawImage(selectIcon, 375, row * 70 + 440, null);
    }


}