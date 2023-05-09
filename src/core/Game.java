package core;

import core.gamePanel.GamePanel;
import core.welcomePanel.WelcomePanel;

public class Game {
    private GameFrame gameFrame;
    private GamePanel gamePanel;
    private WelcomePanel welcomePanel;

    public Game() {
        this.welcomePanel = new WelcomePanel();
        this.gameFrame = new GameFrame();
        this.welcomePanel.requestFocus();
    }
}
