package sample;

import static sample.State.READY;
import static sample.State.RUNNING;

public class Game {

    private Field field;
    private State state;

    public Game() {state = READY;}
    public void startGame() {
        if (state == READY) {
            state = State.RUNNING;
            field = new Field();
            field.shuffle();
        }
    }
    public void endGame() {
        if (state == RUNNING) {
            state = State.FINISHED;
            field = null;
        }
    }
    public void resetGame() {
        if (state != READY) {
            state = READY;
            field = null;
        }
    }
    public void nextMove(int code) {
        if (state == RUNNING) field.toggleTile1(code);
        if (field.isWinner()) endGame();
    }
    public Field getField() {
        return field;
    }
}
