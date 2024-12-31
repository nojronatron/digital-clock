import java.util.Date;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class DigitalClock extends Application {
  private double screenW = 1200.0;
  private double screenH = 360.0;
  private Date currentTime = new Date();
  private GridPane leftColonChar = new GridPane();
  private GridPane rightColonChar = new GridPane();

  public static void main(String[] args) throws Exception {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("LED Clock");
    String currTime = convertTimeToHMS(this.currentTime);
    System.out.println("Current Time: " + currTime);
    String tensHourStr = currTime.substring(0, 1);
    String onesHourStr = currTime.substring(1, 2);
    String tensMinuteStr = currTime.substring(3, 4);
    String onesMinuteStr = currTime.substring(4, 5);
    String tensSecondStr = currTime.substring(6, 7);
    String onesSecondStr = currTime.substring(7, 8);
    System.out.println("H, h, M, m, S, s: " + tensHourStr + ", " + onesHourStr + ", " + tensMinuteStr + ", "
        + onesMinuteStr + ", " + tensSecondStr + ", " + onesSecondStr);

    LedGenerator ledGen = new LedGenerator();
    GridPane tensHourDigit = ledGen.getDigitItem(tensHourStr);
    GridPane onesHourDigit = ledGen.getDigitItem(onesHourStr);
    GridPane tensMinuteDigit = ledGen.getDigitItem(tensMinuteStr);
    GridPane onesMinuteDigit = ledGen.getDigitItem(onesMinuteStr);
    GridPane tensSecondDigit = ledGen.getDigitItem(tensSecondStr);
    GridPane onesSecondDigit = ledGen.getDigitItem(onesSecondStr);

    this.leftColonChar = ledGen.getColonCharacter();
    this.rightColonChar = ledGen.getColonCharacter();

    GridPane ledBank = new GridPane();
    // ledBank.setStyle("-fx-background-color: rgba(20,20,20,0.95);");
    ledBank.setStyle("-fx-background-color: transparent;");
    ledBank.setGridLinesVisible(true);
    ledBank.setAlignment(Pos.CENTER);

    ledBank.add(tensHourDigit, 0, 0);
    ledBank.add(onesHourDigit, 1, 0);
    ledBank.add(this.leftColonChar, 2, 0);
    ledBank.add(tensMinuteDigit, 3, 0);
    ledBank.add(onesMinuteDigit, 4, 0);
    ledBank.add(this.rightColonChar, 5, 0);
    ledBank.add(tensSecondDigit, 6, 0);
    ledBank.add(onesSecondDigit, 7, 0);

    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
      updateClock(ledGen, ledBank);
    }));
    timeline.setCycleCount(Timeline.INDEFINITE);
    timeline.play();

    Scene ledReadoutScene = new Scene(ledBank, screenW, screenH);
    primaryStage.setAlwaysOnTop(true);
    // primaryStage.setFullScreen(true);
    // primaryStage.setFullScreenExitHint("Click anywhere in the Window to exit Full
    // Screen Mode");
    primaryStage.setScene(ledReadoutScene);
    primaryStage.show();

    ledReadoutScene.setOnMouseClicked(event -> {
      if (primaryStage.isFullScreen()) {
        primaryStage.setFullScreen(false);
        primaryStage.setWidth(screenW);
        primaryStage.setHeight(screenH);
      } else {
        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitHint("Click anywhere in the Window to exit Full Screen Mode");
      }
    });

    ChangeListener<Number> sizeListener = (ObservableValue<? extends Number> observable, Number oldValue,
        Number newValue) -> {
      double newWidth = ledReadoutScene.getWidth();
      double newHeight = ledReadoutScene.getHeight();
      double scaleFactor = Math.min(newWidth / screenW, newHeight / screenH);

      ledBank.setScaleX(scaleFactor);
      ledBank.setScaleY(scaleFactor);
    };

    ledReadoutScene.widthProperty().addListener(sizeListener);
    ledReadoutScene.heightProperty().addListener(sizeListener);
  }

  private void updateClock(LedGenerator ledGen, GridPane ledBank) {
    Date currentTime = new Date();
    String currTime = convertTimeToHMS(currentTime);
    String tensHourStr = currTime.substring(0, 1);
    String onesHourStr = currTime.substring(1, 2);
    String tensMinuteStr = currTime.substring(3, 4);
    String onesMinuteStr = currTime.substring(4, 5);
    String tensSecondStr = currTime.substring(6, 7);
    String onesSecondStr = currTime.substring(7, 8);

    ledBank.getChildren().clear();
    ledBank.add(ledGen.getDigitItem(tensHourStr), 0, 0);
    ledBank.add(ledGen.getDigitItem(onesHourStr), 1, 0);
    ledBank.add(this.leftColonChar, 2, 0);
    ledBank.add(ledGen.getDigitItem(tensMinuteStr), 3, 0);
    ledBank.add(ledGen.getDigitItem(onesMinuteStr), 4, 0);
    ledBank.add(this.rightColonChar, 5, 0);
    ledBank.add(ledGen.getDigitItem(tensSecondStr), 6, 0);
    ledBank.add(ledGen.getDigitItem(onesSecondStr), 7, 0);

    double scaleFactor = Math.min(ledBank.getWidth() / this.screenW, ledBank.getHeight() / this.screenH);
    ledBank.setScaleX(scaleFactor);
    ledBank.setScaleY(scaleFactor);
  }

  private String convertTimeToHMS(Date currTime) {
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm:ss");
    return sdf.format(currTime);
  }
}
