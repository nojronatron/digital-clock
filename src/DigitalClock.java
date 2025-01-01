import java.util.Date;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class DigitalClock extends Application {
  private double minScreenW = 1010.0;
  private double minScreenH = 332.0;
  private double lastScreenW = this.minScreenW;
  private double lastScreenH = this.minScreenH;
  private GridPane leftColonChar = new GridPane();
  private GridPane rightColonChar = new GridPane();

  public static void main(String[] args) throws Exception {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("LED Clock");
    primaryStage.setMinHeight(minScreenH);
    primaryStage.setMinWidth(minScreenW);

    LedGenerator ledGen = new LedGenerator();
    this.leftColonChar = ledGen.getColonCharacter();
    this.rightColonChar = ledGen.getColonCharacter();

    GridPane ledBank = new GridPane();
    ledBank.setPrefHeight(this.lastScreenH);
    ledBank.setPrefWidth(this.lastScreenW);

    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
      updateClock(ledGen, ledBank);
    }));
    timeline.setCycleCount(Timeline.INDEFINITE);
    timeline.play();

    Scene ledReadoutScene = new Scene(ledBank, primaryStage.getWidth(), primaryStage.getHeight());

    primaryStage.setAlwaysOnTop(true);
    primaryStage.setScene(ledReadoutScene);
    primaryStage.initStyle(StageStyle.DECORATED);
    primaryStage.show();

    ledReadoutScene.setOnMouseClicked(event -> {
      if (primaryStage.isFullScreen()) {
        primaryStage.setFullScreen(false);
        primaryStage.setHeight(this.lastScreenH);
        primaryStage.setWidth(this.lastScreenW);
      } else {
        this.lastScreenH = primaryStage.getHeight();
        this.lastScreenW = primaryStage.getWidth();
        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitHint("Click anywhere in the Window to exit Full Screen Mode");
      }
    });
  }

  private void updateClock(LedGenerator ledGen, GridPane ledBank) {
    String currTime = getCurrentHHMMSS();
    String tensHourStr = currTime.substring(0, 1);
    String onesHourStr = currTime.substring(1, 2);
    String tensMinuteStr = currTime.substring(3, 4);
    String onesMinuteStr = currTime.substring(4, 5);
    String tensSecondStr = currTime.substring(6, 7);
    String onesSecondStr = currTime.substring(7, 8);

    GridPane tensHourDigit = ledGen.getDigitItem(tensHourStr);
    GridPane onesHourDigit = ledGen.getDigitItem(onesHourStr);
    GridPane tensMinuteDigit = ledGen.getDigitItem(tensMinuteStr);
    GridPane onesMinuteDigit = ledGen.getDigitItem(onesMinuteStr);
    GridPane tensSecondDigit = ledGen.getDigitItem(tensSecondStr);
    GridPane onesSecondDigit = ledGen.getDigitItem(onesSecondStr);

    // idea: add column constraints to the GridPane to make the ledBank elastic
    ledBank.getColumnConstraints().clear();
    ColumnConstraints tensHourCol = new ColumnConstraints();
    tensHourCol.setPercentWidth(16.2);
    ColumnConstraints onesHourCol = new ColumnConstraints();
    onesHourCol.setPercentWidth(16.2);
    ColumnConstraints firstColonCol = new ColumnConstraints();
    firstColonCol.setPercentWidth(1.2);
    ColumnConstraints tensMinuteCol = new ColumnConstraints();
    tensMinuteCol.setPercentWidth(16.2);
    ColumnConstraints onesMinuteCol = new ColumnConstraints();
    onesMinuteCol.setPercentWidth(16.2);
    ColumnConstraints secondColonCol = new ColumnConstraints();
    secondColonCol.setPercentWidth(1.2);
    ColumnConstraints tensSecondCol = new ColumnConstraints();
    tensSecondCol.setPercentWidth(16.2);
    ColumnConstraints onesSecondCol = new ColumnConstraints();
    onesSecondCol.setPercentWidth(16.2);
    ledBank.getColumnConstraints().addAll(tensHourCol, onesHourCol, firstColonCol, tensMinuteCol, onesMinuteCol,
        secondColonCol, tensSecondCol, onesSecondCol);

    ledBank.getRowConstraints().clear();
    RowConstraints digitsRow = new RowConstraints();
    digitsRow.setPercentHeight(100.0);
    ledBank.getRowConstraints().add(digitsRow);

    ledBank.setStyle("-fx-background-color: rgba(6,6,6,0.95);");
    ledBank.setGridLinesVisible(true);
    ledBank.setAlignment(Pos.CENTER);

    ledBank.getChildren().clear();
    ledBank.add(tensHourDigit, 0, 0);
    ledBank.add(onesHourDigit, 1, 0);
    ledBank.add(this.leftColonChar, 2, 0);
    ledBank.add(tensMinuteDigit, 3, 0);
    ledBank.add(onesMinuteDigit, 4, 0);
    ledBank.add(this.rightColonChar, 5, 0);
    ledBank.add(tensSecondDigit, 6, 0);
    ledBank.add(onesSecondDigit, 7, 0);
  }

  private String getCurrentHHMMSS() {
    Date currTime = new Date();
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm:ss");
    return sdf.format(currTime);
  }
}
