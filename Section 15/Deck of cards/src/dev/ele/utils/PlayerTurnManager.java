package dev.ele.utils;

import dev.ele.model.BlackJack;
import dev.ele.model.Player;

public class PlayerTurnManager {

    private BlackJack game;

    public PlayerTurnManager(BlackJack game) {
        this.game = game;
    }

    public Player getPlayerByTurn(int playerIndex) {
        return game.getPlayer(playerIndex);
    }
}