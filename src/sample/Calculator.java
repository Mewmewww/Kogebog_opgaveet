package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;

import javax.swing.text.html.ImageView;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;



public class Calculator {
        @FXML
        TextField valueA;
        @FXML
        TextField valueB;
        @FXML
        TextField resultField;


    // To avoid consistent duplicate code, we utilize a new method that can take the error-message and delete it
    // over a few seconds.
    public void errorMessage() {
            try {
                new Thread(() -> {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    Platform.runLater(() -> {
                        valueA.clear();
                        valueB.clear();
                    });
                }).start();

                valueA.appendText("Error: no values found");
                valueB.appendText("Error: no values found");
                // Insert platform.run thread to clear both logsSave and the ingredients/tutorial.
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
        // Simple calculator with its assigned uses (+ - / *) if a person wants to calculate how much extra they need
        // if they want to make a larger portion.
    public void calculator() {
        if (valueA.getText() == null || valueA.getText().trim().isEmpty() || valueB.getText() == null || valueB.getText().trim().isEmpty()) {
            errorMessage();
        } else {
            double number1 = Double.parseDouble(valueA.getText());
            double number2 = Double.parseDouble(valueB.getText());

            double sum = number1 + number2;
            int intSum = (int) sum;

            if (sum > intSum) {
                resultField.clear();
                System.out.println("Calculating...");
                resultField.appendText(String.valueOf(sum));
            } else {
                resultField.clear();
                System.out.println("Calculating...");
                resultField.appendText(String.valueOf((int) sum));
            }

        }
    }

    public void calculatorSubtraction() {
        if (valueA.getText() == null || valueA.getText().trim().isEmpty() || valueB.getText() == null || valueB.getText().trim().isEmpty()) {
            errorMessage();
        } else {

            double number1 = Double.parseDouble(valueA.getText());
            double number2 = Double.parseDouble(valueB.getText());

            double sumtwo = (int) (number1 - number2);
            int intSum = (int) sumtwo;

            if (sumtwo < intSum) {
                resultField.clear();
                System.out.println("Calculating...");
                resultField.appendText(String.valueOf(sumtwo));
            } else {
                resultField.clear();
                System.out.println("Calculating...");
                resultField.appendText(String.valueOf((int) sumtwo));
            }
        }
    }

    public void calculatorDivision() {
        if (valueA.getText() == null || valueA.getText().trim().isEmpty() || valueB.getText() == null || valueB.getText().trim().isEmpty()) {
            errorMessage();
        } else {
            double number1 = Double.parseDouble(valueA.getText());
            double number2 = Double.parseDouble(valueB.getText());

            double sumthree = (int) (number1 / number2);
            int intSum = (int) sumthree;

            if (sumthree < intSum) {
                resultField.clear();
                System.out.println("Calculating...");
                resultField.appendText(String.valueOf(sumthree));
            } else {
                resultField.clear();
                System.out.println("Calculating...");
                resultField.appendText(String.valueOf((int) sumthree));
            }

        }
    }

    public void calculatorMultiplication() {
        if (valueA.getText() == null || valueA.getText().trim().isEmpty() || valueB.getText() == null || valueB.getText().trim().isEmpty()) {
            errorMessage();
        } else {

            double number1 = Double.parseDouble(valueA.getText());
            double number2 = Double.parseDouble(valueB.getText());

            double sumfour = (int) (number1 * number2);
            int intSum = (int) sumfour;

            if (sumfour > intSum) {
                resultField.clear();
                System.out.println("Calculating...");
                resultField.appendText(String.valueOf(sumfour));
            } else {
                resultField.clear();
                System.out.println("Calculating...");
                resultField.appendText(String.valueOf((int) sumfour));
            }

        }
    }

}
