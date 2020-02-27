package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class Controller {

    public Button btnStart;
    public Button btnEnd;
    public Button btnReset;
    public Button btn_0, btn_1, btn_2, btn_3;
    public Button btn_4, btn_5, btn_6, btn_7;
    public Button btn_8, btn_9, btn_10, btn_11;
    public Button btn_12, btn_13, btn_14, btn_15;
    private Game game;

    public Controller() {game = new Game();}
    public void clickBtn(ActionEvent actionEvent) {
        String temp = ((Button)actionEvent.getSource()).getId().substring(4);
        int value = Integer.parseInt(temp);
        game.nextMove(value);
        if (game.getField() != null) rePaint();
    }
    public void startGame(ActionEvent actionEvent) {
        game.startGame();
        btnStart.setDisable(true);
        btnReset.setDisable(false);
        rePaint();
    }
    public void endGame(ActionEvent actionEvent) {
        game.endGame();
        Platform.exit();
    }
    public void resetGame(ActionEvent actionEvent) {
        game.resetGame();
        btnReset.setDisable(true);
        btnStart.setDisable(false);
    }
    public void rePaint() {
        Tile[][] arr = game.getField().getArr();
        if (arr == null) return;
        btn_0.setText(arr[0][0].isValue() ? "X" : "O");
        btn_1.setText(arr[1][0].isValue() ? "X" : "O");
        btn_2.setText(arr[2][0].isValue() ? "X" : "O");
        btn_3.setText(arr[3][0].isValue() ? "X" : "O");
        btn_4.setText(arr[0][1].isValue() ? "X" : "O");
        btn_5.setText(arr[1][1].isValue() ? "X" : "O");
        btn_6.setText(arr[2][1].isValue() ? "X" : "O");
        btn_7.setText(arr[3][1].isValue() ? "X" : "O");
        btn_8.setText(arr[0][2].isValue() ? "X" : "O");
        btn_9.setText(arr[1][2].isValue() ? "X" : "O");
        btn_10.setText(arr[2][2].isValue() ? "X" : "O");
        btn_11.setText(arr[3][2].isValue() ? "X" : "O");
        btn_12.setText(arr[0][3].isValue() ? "X" : "O");
        btn_13.setText(arr[1][3].isValue() ? "X" : "O");
        btn_14.setText(arr[2][3].isValue() ? "X" : "O");
        btn_15.setText(arr[3][3].isValue() ? "X" : "O");
    }
}
