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

public class Controller extends Calculator {
    public void setOpskrift(Tab opskrift) {
        Opskrift = opskrift;
    }

    @FXML
    Tab Opskrift;
    @FXML
    Tab Logs;
    @FXML
    Tab Kogebog;
    @FXML
    Tab Introduktion;
    @FXML
    TabPane tabPane;
    @FXML
    ImageView imageViewFried;
    @FXML
    ImageView imageViewCake;
    @FXML
    Button chicken;
    @FXML
    TextField FriedChicken;
    @FXML
    TextArea TestIngredients;
    @FXML
    TextArea testTutorial;
    @FXML
    Button chickenSave;
    @FXML
    Button soupSave;
    @FXML
    Button steakSave;
    @FXML
    Button burgerSave;
    @FXML
    Button lasagnaSave;
    @FXML
    Button riceSave;
    @FXML
    TextArea saveIngredients;
    @FXML
    TextArea saveTutorial;
    @FXML
    TextField logsSave;
    @FXML
    TextField saveDocument;
    @FXML
    Button randomizeDish;

    @FXML
    Button buttonAdd;
    @FXML
    Button buttonSubtract;
    @FXML
    Button buttonDivide;
    @FXML
    Button buttonMultiply;

    ArrayList<String> readLines = new ArrayList<String>();
    // TODO: Add an arbitrary recipe/ingredientslist from google at last.
    public void chickenTransfer() {
        FriedChicken.clear();
        TestIngredients.clear();

        tabPane.getSelectionModel().select(Opskrift);
        FriedChicken.appendText("Ingredients for a good fried chicken recipe");

    }

    public void soupTransfer() throws NumberFormatException {
        FriedChicken.clear();
        TestIngredients.clear();
        tabPane.getSelectionModel().select(Opskrift);
        FriedChicken.appendText("Ingredients for a good soup recipe");


        File file = new File("Soup.txt");
        File file1 = new File("SoupTutorial.txt");
        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine()) {
                TestIngredients.appendText(input.nextLine() + "\n");
                // TODO: Add tutorial on how to cook on the side too. Do with the rest.
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        try (Scanner inputtwo = new Scanner(file1)) {
            while (inputtwo.hasNextLine()) {
                testTutorial.appendText(inputtwo.nextLine() + "\n");
                // TODO: Tutorial is done for this, but do the rest of the slavework on the day, just in case im doing it wrong.
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

    }
    // TODO: Add an arbitrary recipe/ingredientslist from google at last.

    public void steakTransfer() {
        FriedChicken.clear();
        TestIngredients.clear();

        tabPane.getSelectionModel().select(Opskrift);
        FriedChicken.appendText("Ingredients for a good steak recipe");

        File file = new File("Steak.txt");
        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine()) {
                TestIngredients.appendText(input.nextLine() + "\n");
                // TODO: Add tutorial on how to cook on the side too. Do with the rest.
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    // TODO: Add an arbitrary recipe/ingredientslist from google at last.

    public void riceTransfer() {
        FriedChicken.clear();
        TestIngredients.clear();

        tabPane.getSelectionModel().select(Opskrift);
        FriedChicken.appendText("Ingredients for a good rice recipe");
        File file = new File("Soup.txt");
        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine()) {
                TestIngredients.appendText(input.nextLine() + "\n");
                // TODO: Add tutorial on how to cook on the side too. Do with the rest.
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

    }
    // TODO: Add an arbitrary recipe/ingredientslist from google at last.

    public void burgerTransfer() {
        FriedChicken.clear();
        TestIngredients.clear();
        tabPane.getSelectionModel().select(Opskrift);
        FriedChicken.appendText("Ingredients for a good burger recipe");
        File file = new File("Soup.txt");
        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine()) {
                TestIngredients.appendText(input.nextLine() + "\n");
                // TODO: Add tutorial on how to cook on the side too. Do with the rest.
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

    }
    // TODO: Add an arbitrary recipe/ingredientslist from google at last.

    public void lasagnaTransfer() {
        FriedChicken.clear();
        TestIngredients.clear();
        tabPane.getSelectionModel().select(Opskrift);
        FriedChicken.appendText("Ingredients for a good lasagna recipe");
        File file = new File("Soup.txt");
        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine()) {
                TestIngredients.appendText(input.nextLine() + "\n");
                // TODO: Add tutorial on how to cook on the side too. Do with the rest.
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

    }

    // Logs - let's the user choose a specific recipe and save it on their own.
    public void logs() throws IOException {


        File soupIngredients = new File("Soup.txt");
        File soupTutorial = new File("SoupTutorial.txt");
        // For every time our file has a readable line, it appends that line and does a space so that it becomes readable.
        try (Scanner soupIngredient = new Scanner(soupIngredients)) {
            while (soupIngredient.hasNextLine()) {
                saveIngredients.appendText(soupIngredient.nextLine() + "\n");
                // TODO: Add tutorial on how to cook on the side too. Do with the rest.
            }
        } // Just in case that this can fail, as i'm working with files.
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        try (Scanner soupTutorials = new Scanner(soupTutorial)) {
            while (soupTutorials.hasNextLine()) {
                saveTutorial.appendText(soupTutorials.nextLine() + "\n");
                // TODO: Tutorial is done for this, but do the rest of the slavework on the day, just in case im doing it wrong.
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        File file = new File(saveDocument.getText() + ".txt");
        // Creating a new thread so that the prompted error-messages gets deleted over a few seconds.
        try {
            if (saveDocument.getText().equals("")) {
                try {
                    new Thread(() -> {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        Platform.runLater(() -> {
                            logsSave.clear();
                            saveDocument.clear();
                            saveIngredients.clear();
                            saveTutorial.clear();
                        });
                    }).start();

                    logsSave.appendText("Error: no document-title found");
                    // Insert platform.run thread to clear both logsSave and the ingredients/tutorial.
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            } else {
                logsSave.appendText("File created - shutting down");
                FileWriter fileWriter = new FileWriter(file, true);
                BufferedWriter outStream = new BufferedWriter(fileWriter);
                outStream.append(saveIngredients.getText()).append("\n").append("").append(saveTutorial.getText());
                outStream.close();
                fileWriter.close();

            }
        } catch (NullPointerException e) {
            logsSave.appendText("Error: no document-title found");
            logsSave.setOpacity(1);
        }
    }
    // Just a quick randomizedDish that if the user is incapable of chosing a dish on their own, they may
    // be offered a randomized one with a switch-case
    public void randomizeDish() {
        Random rand = new Random();
        int roll = rand.nextInt((6 - 1) + 1) + 1;

        switch (roll) {

            case 1 -> {
                chickenTransfer();
            }
            case 2 -> {
                soupTransfer();
            }
            case 3 -> {
                steakTransfer();

            }
            case 4 -> {
                riceTransfer();
            }
            case 5 -> {
                burgerTransfer();
            }
            case 6 -> {
                lasagnaTransfer();
            }
            default -> {
            }
        }
    }
}
