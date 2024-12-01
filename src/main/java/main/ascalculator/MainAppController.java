package main.ascalculator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.lang.reflect.Array;

public class MainAppController  {
    @FXML
    private Pane titlePane;
    private double x,y;
    private String userinput = "0";
    private int num1;
    private String prevoperation = "";
    private boolean running = true;
    @FXML
    private Label calcInput;
    @FXML
    private Label calcOutput;

    @FXML
   private ImageView minimise, close;

    public void init(Stage stage) {
        titlePane.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });
        titlePane.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX()-x);
            stage.setY(mouseEvent.getScreenY()-y);
        });
    close.setOnMouseClicked(mouseEvent -> stage.close());
    minimise.setOnMouseClicked(mouseEvent -> stage.setIconified(true));
    }

    public void numBtnPrsd(MouseEvent e) {
        if (running) {
            int value = Integer.parseInt(((Pane) e.getSource()).getId().replace("btn", ""));
            String valueString = String.valueOf(value);

            if (userinput.equals("0")) {
                userinput = valueString;
            } else {
                userinput = userinput + valueString;
            }

            if (calcInput.getText().equals("0")) {
                calcInput.setText(valueString);
            } else {
                calcInput.setText(calcInput.getText() + valueString);
            }
        }
    }
    public void symBtnPrsd(MouseEvent e) {
        String operator = ((Pane)e.getSource()).getId().replace("btn","");

        if (operator.equals("equals")) {
            if(!userinput.equals("0") && !prevoperation.equals("")) {
                int num2 = Integer.parseInt(userinput);
                switch (prevoperation) {
                    case "add":
                        calcOutput.setText(String.valueOf((double) num1+num2));
                        break;
                    case "sub":
                        calcOutput.setText(String.valueOf((double) num1-num2));
                        break;
                    case "mul":
                        calcOutput.setText(String.valueOf((double) num1*num2));
                        break;
                    case "div":
                        calcOutput.setText(String.valueOf((double) num1/num2));
                        break;
                    default:
                        System.out.println("Error");
                        break;
                }
                running = false;
            }
        }
        else {
            if (!userinput.equals("0") && prevoperation.equals("")) {
                num1 = Integer.parseInt(calcInput.getText());
                userinput = "0";
                switch (operator) {
                    case "add":
                        calcInput.setText(calcInput.getText() + "+");
                        break;
                    case "sub":
                        calcInput.setText(calcInput.getText() + "-");
                        break;
                    case "mul":
                        calcInput.setText(calcInput.getText() + "×");
                        break;
                    case "div":
                        calcInput.setText(calcInput.getText() + "÷");
                        break;
                }
                prevoperation = operator;
            }
        }
    }
    public void clear(MouseEvent e) {
        calcInput.setText("0");
        calcOutput.setText("");
        userinput = "0";
        prevoperation = "";
        running = true;
    }
}