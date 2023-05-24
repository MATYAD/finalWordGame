package core;

import core.welcomePanel.WelcomePanel;

public class Game {

    public Game() {
        WelcomePanel welcomePanel = new WelcomePanel();
        GameFrame gameFrame = new GameFrame();
        welcomePanel.requestFocus();
    }
}
