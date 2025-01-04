package digitalclock;

import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

public class LedGenerator {
  private static final double DIGIT_COL_PAD_PERCENT_WIDTH = 7.0; // 3.8;
  private static final double DIGIT_COL_EL_PERCENT_WIDTH = 15.0; // 7.6;
  private static final double DIGIT_COL_SPACE_PERCENT_WIDTH = 56.0;// 77.0;

  private static final double DIGIT_ROW_PAD_PERCENT_HEIGHT = 2.1;
  private static final double DIGIT_ROW_HEL_PERCENT_HEIGHT = 4.2;
  private static final double DIGIT_ROW_VEL_PERCENT_HEIGHT = 41.2;

  private static final double COLON_COL_PAD_PERCENT_WIDTH = 15.0;
  private static final double COLON_COL_EL_PERCENT_WIDTH = 70.0;

  private static final double COLON_ROW_PAD_PERCENT_HEIGHT = 30.0;
  private static final double COLON_ROW_EL_PERCENT_HEIGHT = 4.4;
  private static final double COLON_ROW_CENTERPAD_PERCENT_HEIGHT = 30.0;

  private String elementOn = "-fx-background-color: red;";
  private String elementOff = "-fx-background-color: transparent;";

  /*
   * This method returns a GridPane object that represents a digit on a 7-segment.
   * Start with this method to create a single digit.
   */
  public GridPane getDigitItem(String digit) {
    if (digit.length() > 1) {
      digit = "0";
    }

    GridPane resultGridPane = InitDigitCharacter();

    switch (digit) {
      case "1": {
        getDigitOne(resultGridPane);
        break;
      }
      case "2": {
        getDigitTwo(resultGridPane);
        break;
      }
      case "3": {
        getDigitThree(resultGridPane);
        break;
      }
      case "4": {
        getDigitFour(resultGridPane);
        break;
      }
      case "5": {
        getDigitFive(resultGridPane);
        break;
      }
      case "6": {
        getDigitSix(resultGridPane);
        break;
      }
      case "7": {
        getDigitSeven(resultGridPane);
        break;
      }
      case "8": {
        getDigitEight(resultGridPane);
        break;
      }
      case "9": {
        getDigitNine(resultGridPane);
        break;
      }
      default: {
        getDigitZero(resultGridPane);
        break;
      }
    }

    return resultGridPane;
  }

  private void getDigitNine(GridPane digitGridPane) {
    // ON
    VBox ulBar = new VBox();
    ulBar.setStyle(getVElOnStyle());
    HBox topBar = new HBox();
    topBar.setStyle(getHElOnStyle());
    VBox urBar = new VBox();
    urBar.setStyle(getVElOnStyle());
    HBox middleBar = new HBox();
    middleBar.setStyle(getHElOnStyle());
    HBox bottomBar = new HBox();
    bottomBar.setStyle(getHElOnStyle());
    VBox brBar = new VBox();
    brBar.setStyle(getVElOnStyle());

    // OFF
    VBox blBar = new VBox();
    blBar.setStyle(getVElOffStyle());

    setElements(digitGridPane, ulBar, topBar, urBar, blBar, bottomBar, brBar, middleBar);
  }

  private void getDigitEight(GridPane digitGridPane) {
    // ON
    VBox ulBar = new VBox();
    ulBar.setStyle(getVElOnStyle());
    HBox topBar = new HBox();
    topBar.setStyle(getHElOnStyle());
    VBox urBar = new VBox();
    urBar.setStyle(getVElOnStyle());
    HBox middleBar = new HBox();
    middleBar.setStyle(getHElOnStyle());
    VBox blBar = new VBox();
    blBar.setStyle(getVElOnStyle());
    HBox bottomBar = new HBox();
    bottomBar.setStyle(getHElOnStyle());
    VBox brBar = new VBox();
    brBar.setStyle(getVElOnStyle());

    setElements(digitGridPane, ulBar, topBar, urBar, blBar, bottomBar, brBar, middleBar);
  }

  private void getDigitSeven(GridPane digitGridPane) {
    // ON
    HBox topBar = new HBox();
    topBar.setStyle(getHElOnStyle());
    VBox urBar = new VBox();
    urBar.setStyle(getVElOnStyle());
    VBox brBar = new VBox();
    brBar.setStyle(getVElOnStyle());

    // OFF
    VBox ulBar = new VBox();
    ulBar.setStyle(getVElOffStyle());
    HBox middleBar = new HBox();
    middleBar.setStyle(getHElOffStyle());
    VBox blBar = new VBox();
    blBar.setStyle(getVElOffStyle());
    HBox bottomBar = new HBox();
    bottomBar.setStyle(getHElOffStyle());

    setElements(digitGridPane, ulBar, topBar, urBar, blBar, bottomBar, brBar, middleBar);
  }

  private void getDigitSix(GridPane digitGridPane) {
    // ON
    VBox ulBar = new VBox();
    ulBar.setStyle(getVElOnStyle());
    HBox topBar = new HBox();
    topBar.setStyle(getHElOnStyle());
    HBox middleBar = new HBox();
    middleBar.setStyle(getHElOnStyle());
    VBox blBar = new VBox();
    blBar.setStyle(getVElOnStyle());
    HBox bottomBar = new HBox();
    bottomBar.setStyle(getHElOnStyle());
    VBox brBar = new VBox();
    brBar.setStyle(getVElOnStyle());

    // OFF
    VBox urBar = new VBox();
    urBar.setStyle(getVElOffStyle());

    setElements(digitGridPane, ulBar, topBar, urBar, blBar, bottomBar, brBar, middleBar);
  }

  private void getDigitFive(GridPane digitGridPane) {
    // ON
    VBox ulBar = new VBox();
    ulBar.setStyle(getVElOnStyle());
    HBox topBar = new HBox();
    topBar.setStyle(getHElOnStyle());
    HBox middleBar = new HBox();
    middleBar.setStyle(getHElOnStyle());
    HBox bottomBar = new HBox();
    bottomBar.setStyle(getHElOnStyle());
    VBox brBar = new VBox();
    brBar.setStyle(getVElOnStyle());

    // OFF
    VBox urBar = new VBox();
    urBar.setStyle(getVElOffStyle());
    VBox blBar = new VBox();
    blBar.setStyle(getVElOffStyle());

    setElements(digitGridPane, ulBar, topBar, urBar, blBar, bottomBar, brBar, middleBar);
  }

  private void getDigitFour(GridPane digitGridPane) {
    // ON
    VBox ulBar = new VBox();
    ulBar.setStyle(getVElOnStyle());
    VBox urBar = new VBox();
    urBar.setStyle(getVElOnStyle());
    HBox middleBar = new HBox();
    middleBar.setStyle(getHElOnStyle());
    VBox brBar = new VBox();
    brBar.setStyle(getVElOnStyle());

    // OFF
    HBox topBar = new HBox();
    topBar.setStyle(getHElOffStyle());
    VBox blBar = new VBox();
    blBar.setStyle(getVElOffStyle());
    HBox bottomBar = new HBox();
    bottomBar.setStyle(getHElOffStyle());

    setElements(digitGridPane, ulBar, topBar, urBar, blBar, bottomBar, brBar, middleBar);
  }

  private void getDigitThree(GridPane digitGridPane) {
    // ON
    HBox topBar = new HBox();
    topBar.setStyle(getVElOnStyle());
    VBox urBar = new VBox();
    urBar.setStyle(getVElOnStyle());
    HBox middleBar = new HBox();
    middleBar.setStyle(getHElOnStyle());
    VBox brBar = new VBox();
    brBar.setStyle(getVElOnStyle());
    HBox bottomBar = new HBox();
    bottomBar.setStyle(getHElOnStyle());

    // OFF
    VBox ulBar = new VBox();
    ulBar.setStyle(getHElOffStyle());
    VBox blBar = new VBox();
    blBar.setStyle(getVElOffStyle());

    setElements(digitGridPane, ulBar, topBar, urBar, blBar, bottomBar, brBar, middleBar);
  }

  private void getDigitTwo(GridPane digitGridPane) {
    // ON
    HBox topBar = new HBox();
    topBar.setStyle(getVElOnStyle());
    VBox urBar = new VBox();
    urBar.setStyle(getVElOnStyle());
    HBox middleBar = new HBox();
    middleBar.setStyle(getHElOnStyle());
    VBox blBar = new VBox();
    blBar.setStyle(getHElOnStyle());
    HBox bottomBar = new HBox();
    bottomBar.setStyle(getHElOnStyle());

    // OFF
    VBox ulBar = new VBox();
    ulBar.setStyle(getHElOffStyle());
    VBox brBar = new VBox();
    brBar.setStyle(getVElOffStyle());

    setElements(digitGridPane, ulBar, topBar, urBar, blBar, bottomBar, brBar, middleBar);
  }

  private void getDigitOne(GridPane digitGridPane) {
    // ON
    VBox urBar = new VBox();
    urBar.setStyle(getVElOnStyle());
    VBox brBar = new VBox();
    brBar.setStyle(getVElOnStyle());

    // OFF
    VBox ulBar = new VBox();
    ulBar.setStyle(getHElOffStyle());
    HBox topBar = new HBox();
    topBar.setStyle(getVElOffStyle());
    HBox middleBar = new HBox();
    middleBar.setStyle(getHElOffStyle());
    VBox blBar = new VBox();
    blBar.setStyle(getVElOffStyle());
    HBox bottomBar = new HBox();
    bottomBar.setStyle(getHElOffStyle());

    setElements(digitGridPane, ulBar, topBar, urBar, blBar, bottomBar, brBar, middleBar);
  }

  public GridPane getColonCharacter() {

    VBox upperDot = new VBox();
    upperDot.setStyle(this.elementOn);
    VBox lowerDot = new VBox();
    lowerDot.setStyle(this.elementOn);

    GridPane colonGridPane = new GridPane();
    colonGridPane.setAlignment(Pos.CENTER);

    colonGridPane.getColumnConstraints().clear();
    ColumnConstraints col1 = new ColumnConstraints();
    col1.setPercentWidth(COLON_COL_PAD_PERCENT_WIDTH);
    ColumnConstraints col2 = new ColumnConstraints();
    col2.setPercentWidth(COLON_COL_EL_PERCENT_WIDTH);
    ColumnConstraints col3 = new ColumnConstraints();
    col3.setPercentWidth(COLON_COL_PAD_PERCENT_WIDTH);
    colonGridPane.getColumnConstraints().addAll(col1, col2, col3);

    RowConstraints row1 = new RowConstraints();
    row1.setPercentHeight(COLON_ROW_PAD_PERCENT_HEIGHT);
    RowConstraints row2 = new RowConstraints();
    row2.setPercentHeight(COLON_ROW_EL_PERCENT_HEIGHT);
    RowConstraints row3 = new RowConstraints();
    row3.setPercentHeight(COLON_ROW_CENTERPAD_PERCENT_HEIGHT);
    RowConstraints row4 = new RowConstraints();
    row4.setPercentHeight(COLON_ROW_EL_PERCENT_HEIGHT);
    RowConstraints row5 = new RowConstraints();
    row5.setPercentHeight(COLON_ROW_PAD_PERCENT_HEIGHT);
    colonGridPane.getRowConstraints().addAll(row1, row2, row3, row4, row5);

    colonGridPane.add(upperDot, 1, 1);
    colonGridPane.add(lowerDot, 1, 3);

    return colonGridPane;
  }

  private void getDigitZero(GridPane digitGridPane) {
    // ON
    VBox ulBar = new VBox();
    ulBar.setStyle(getHElOnStyle());
    HBox topBar = new HBox();
    topBar.setStyle(getVElOnStyle());
    VBox urBar = new VBox();
    urBar.setStyle(getVElOnStyle());
    VBox blBar = new VBox();
    blBar.setStyle(getVElOnStyle());
    HBox bottomBar = new HBox();
    bottomBar.setStyle(getHElOnStyle());
    VBox brBar = new VBox();
    brBar.setStyle(getVElOnStyle());
    // OFF
    HBox middleBar = new HBox();
    middleBar.setStyle(getHElOffStyle());

    setElements(digitGridPane, ulBar, topBar, urBar, blBar, bottomBar, brBar, middleBar);
  }

  private void setElements(GridPane digitGridPane, VBox ulBar, HBox topBar, VBox urBar, VBox blBar, HBox bottomBar,
      VBox brBar, HBox middleBar) {
    digitGridPane.add(ulBar, 1, 2);
    digitGridPane.add(topBar, 2, 1);
    digitGridPane.add(urBar, 3, 2);
    digitGridPane.add(middleBar, 2, 3);
    digitGridPane.add(blBar, 1, 4);
    digitGridPane.add(brBar, 3, 4);
    digitGridPane.add(bottomBar, 2, 5);
  }

  public String getVElOnStyle() {
    return this.elementOn;
  }

  public String getHElOnStyle() {
    return this.elementOn;
  }

  public String getVElOffStyle() {
    return this.elementOff;
  }

  public String getHElOffStyle() {
    return this.elementOff;
  }

  public GridPane InitDigitCharacter() {
    GridPane digitGridPane = new GridPane();

    digitGridPane.setAlignment(Pos.BASELINE_CENTER);

    ColumnConstraints col1 = new ColumnConstraints();
    col1.setPercentWidth(DIGIT_COL_PAD_PERCENT_WIDTH);
    ColumnConstraints col2 = new ColumnConstraints();
    col2.setPercentWidth(DIGIT_COL_EL_PERCENT_WIDTH);
    ColumnConstraints col3 = new ColumnConstraints();
    col3.setPercentWidth(DIGIT_COL_SPACE_PERCENT_WIDTH);
    ColumnConstraints col4 = new ColumnConstraints();
    col4.setPercentWidth(DIGIT_COL_EL_PERCENT_WIDTH);
    ColumnConstraints col5 = new ColumnConstraints();
    col5.setPercentWidth(DIGIT_COL_PAD_PERCENT_WIDTH);
    digitGridPane.getColumnConstraints().addAll(col1, col2, col3, col4, col5);

    RowConstraints row1 = new RowConstraints();
    row1.setPercentHeight(DIGIT_ROW_PAD_PERCENT_HEIGHT);
    RowConstraints row2 = new RowConstraints();
    row2.setPercentHeight(DIGIT_ROW_HEL_PERCENT_HEIGHT);
    RowConstraints row3 = new RowConstraints();
    row3.setPercentHeight(DIGIT_ROW_VEL_PERCENT_HEIGHT);
    RowConstraints row4 = new RowConstraints();
    row4.setPercentHeight(DIGIT_ROW_HEL_PERCENT_HEIGHT);
    RowConstraints row5 = new RowConstraints();
    row5.setPercentHeight(DIGIT_ROW_VEL_PERCENT_HEIGHT);
    RowConstraints row6 = new RowConstraints();
    row6.setPercentHeight(DIGIT_ROW_HEL_PERCENT_HEIGHT);
    RowConstraints row7 = new RowConstraints();
    row7.setPercentHeight(DIGIT_ROW_PAD_PERCENT_HEIGHT);
    digitGridPane.getRowConstraints().addAll(row1, row2, row3, row4, row5, row6, row7);

    return digitGridPane;
  }
}
