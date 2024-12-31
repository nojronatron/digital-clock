import java.util.Date;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class DigitalClock extends Application {
  private double screenW = 1000.0;
  private double screenH = 600.0;
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
    // GridPane firstColon = ledGen.getColonCharacter();
    // GridPane secondColon = ledGen.getColonCharacter();
    this.leftColonChar = ledGen.getColonCharacter();
    this.rightColonChar = ledGen.getColonCharacter();

    GridPane ledBank = new GridPane();
    ledBank.setHgap(10);
    ledBank.setVgap(10);
    ledBank.setPadding(new Insets(0, 10, 0, 10));

    // ledBank.setStyle("-fx-background-color: black;");
    ledBank.setGridLinesVisible(true);
    ledBank.setAlignment(Pos.BASELINE_CENTER);

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
    primaryStage.setFullScreen(true);
    primaryStage.setFullScreenExitHint("Click anywhere in the Window to exit Full Screen Mode");
    primaryStage.setScene(ledReadoutScene);
    primaryStage.show();

    ledReadoutScene.setOnMouseClicked(event -> {
      if (primaryStage.isFullScreen()) {
        primaryStage.setFullScreen(false);
        primaryStage.setWidth(screenW);
        primaryStage.setHeight(screenH);
      } else {
        primaryStage.setFullScreen(true);
      }
    });
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
  }

  private String convertTimeToHMS(Date currTime) {
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm:ss");
    return sdf.format(currTime);
  }

  // public GridPane getTensHourDigitOld() {
  // GridPane digitGridPane = new GridPane();
  // // set a grid layout of 7 rows and 5 columns column widths should be 3%, 8%,
  // // 72%, 8%, 3% row heights should be 2%, 4%, 42%, 4%, 42%. 4%, 2% rows and
  // // columns should have a 1px border
  // digitGridPane.setStyle("-fx-background-color: dimgray; width: 100%; height:
  // 100%;");
  // digitGridPane.setGridLinesVisible(true);
  // digitGridPane.setAlignment(Pos.BASELINE_CENTER);
  // // digitGridPane.setHgap(10);
  // // digitGridPane.setVgap(10);

  // ColumnConstraints col1 = new ColumnConstraints();
  // col1.setPrefWidth(6.0);
  // ColumnConstraints col2 = new ColumnConstraints();
  // col2.setPrefWidth(12.0);
  // ColumnConstraints col3 = new ColumnConstraints();
  // col3.setPrefWidth(120.0);
  // ColumnConstraints col4 = new ColumnConstraints();
  // col4.setPrefWidth(12.0);
  // ColumnConstraints col5 = new ColumnConstraints();
  // col5.setPrefWidth(6.0);
  // digitGridPane.getColumnConstraints().addAll(col1, col2, col3, col4, col5);

  // VBox ulVertical = new VBox();
  // ulVertical.setId("ulVertical"); // use for CSS targeting
  // ulVertical.setStyle("-fx-background-color: red; width: 12px; height:
  // 120px;");
  // digitGridPane.add(ulVertical, 1, 2);

  // RowConstraints row1 = new RowConstraints();
  // row1.setPrefHeight(6.0);
  // RowConstraints row2 = new RowConstraints();
  // row2.setPrefHeight(12.0);
  // RowConstraints row3 = new RowConstraints();
  // row3.setPrefHeight(120.0);
  // RowConstraints row4 = new RowConstraints();
  // row4.setPrefHeight(12.0);
  // RowConstraints row5 = new RowConstraints();
  // row5.setPrefHeight(120.0);
  // RowConstraints row6 = new RowConstraints();
  // row6.setPrefHeight(12.0);
  // RowConstraints row7 = new RowConstraints();
  // row7.setPrefHeight(6.0);
  // digitGridPane.getRowConstraints().addAll(row1, row2, row3, row4, row5, row6,
  // row7);

  // return digitGridPane;
  // }
}
