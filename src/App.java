import java.util.Date;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
  private double screenW = 1000.0;
  private double screenH = 600.0;
  private Date currentTime = new Date();

  public static void main(String[] args) throws Exception {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("LED Clock");
    String currTime = convertTimeToHMS(this.currentTime);

    LedGenerator ledGen = new LedGenerator();
    GridPane tensHourDigit = ledGen.getDigitItem(currTime.substring(0, 1));
    GridPane onesHourDigit = ledGen.getDigitItem(currTime.substring(1, 2));
    GridPane tensMinuteDigit = ledGen.getDigitItem(currTime.substring(3, 4));
    GridPane onesMinuteDigit = ledGen.getDigitItem(currTime.substring(4, 5));
    GridPane tensSecondDigit = ledGen.getDigitItem(currTime.substring(6, 7));
    GridPane onesSecondDigit = ledGen.getDigitItem(currTime.substring(7, 8));

    GridPane ledBank = new GridPane();
    ledBank.setHgap(10);
    ledBank.setVgap(10);
    ledBank.setPadding(new Insets(0, 10, 0, 10));

    ledBank.setStyle("-fx-background-color: darkturquoise;");
    ledBank.setGridLinesVisible(true);
    ledBank.setAlignment(Pos.BASELINE_CENTER);

    // var tensHourDigit = getTensHourDigitOld();
    ledBank.add(tensHourDigit, 0, 0);
    ledBank.add(onesHourDigit, 1, 0);
    ledBank.add(tensMinuteDigit, 3, 0);
    ledBank.add(onesMinuteDigit, 4, 0);
    ledBank.add(tensSecondDigit, 6, 0);
    ledBank.add(onesSecondDigit, 7, 0);

    Scene ledReadoutScene = new Scene(ledBank, screenW, screenH);
    primaryStage.setScene(ledReadoutScene);
    primaryStage.show();
  }

  private String convertTimeToHMS(Date currTime) {
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm:ss");
    return sdf.format(currTime);
  }

  public GridPane getTensHourDigitOld() {
    GridPane digitGridPane = new GridPane();
    // set a grid layout of 7 rows and 5 columns column widths should be 3%, 8%,
    // 72%, 8%, 3% row heights should be 2%, 4%, 42%, 4%, 42%. 4%, 2% rows and
    // columns should have a 1px border
    digitGridPane.setStyle("-fx-background-color: dimgray; width: 100%; height: 100%;");
    digitGridPane.setGridLinesVisible(true);
    digitGridPane.setAlignment(Pos.BASELINE_CENTER);
    // digitGridPane.setHgap(10);
    // digitGridPane.setVgap(10);

    ColumnConstraints col1 = new ColumnConstraints();
    col1.setPrefWidth(6.0);
    ColumnConstraints col2 = new ColumnConstraints();
    col2.setPrefWidth(12.0);
    ColumnConstraints col3 = new ColumnConstraints();
    col3.setPrefWidth(120.0);
    ColumnConstraints col4 = new ColumnConstraints();
    col4.setPrefWidth(12.0);
    ColumnConstraints col5 = new ColumnConstraints();
    col5.setPrefWidth(6.0);
    digitGridPane.getColumnConstraints().addAll(col1, col2, col3, col4, col5);

    VBox ulVertical = new VBox();
    ulVertical.setId("ulVertical"); // use for CSS targeting
    ulVertical.setStyle("-fx-background-color: red; width: 12px; height: 120px;");
    digitGridPane.add(ulVertical, 1, 2);

    RowConstraints row1 = new RowConstraints();
    row1.setPrefHeight(6.0);
    RowConstraints row2 = new RowConstraints();
    row2.setPrefHeight(12.0);
    RowConstraints row3 = new RowConstraints();
    row3.setPrefHeight(120.0);
    RowConstraints row4 = new RowConstraints();
    row4.setPrefHeight(12.0);
    RowConstraints row5 = new RowConstraints();
    row5.setPrefHeight(120.0);
    RowConstraints row6 = new RowConstraints();
    row6.setPrefHeight(12.0);
    RowConstraints row7 = new RowConstraints();
    row7.setPrefHeight(6.0);
    digitGridPane.getRowConstraints().addAll(row1, row2, row3, row4, row5, row6, row7);

    return digitGridPane;
  }
}
