package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.text.html.ImageView;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Controller extends Calculator {
    //<editor-fold-desc = "FXML-List">
    @FXML
    ChoiceBox choiceBox;
    @FXML
    Tab Opskrift;
    @FXML
    Tab Logs;
    @FXML
    Tab Kogebog;
    @FXML
    Tab Introduktion;
    @FXML
    Tab NutritionsValues;
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
    @FXML
    TextArea nutritionValues;
    @FXML
    Button nutritionBurger;
    @FXML
    Button nutritionSoup;
    @FXML
    Button nutritionLasagna;
    @FXML
    Button nutritionSteak;
    @FXML
    Button nutritionChicken;
    @FXML
    Button nutritionRice;
    //</editor-fold>
    public void choiceBoxes() {
        //TODO: Work in progress - most likely won't be done by deadline.
    }
    public void chickenTransfer() {
        // Method is called when the button correlated to chicken is pressed.
        FriedChicken.clear();
        TestIngredients.clear();
        testTutorial.clear();

        tabPane.getSelectionModel().select(Opskrift);
        FriedChicken.appendText("Ingredients for a good Chicken recipe");
        // Instantiated the files I want specifically when chicken is called.
        File file = new File("Chicken.txt");
        File file1 = new File("ChickenTutorial.txt");
        stealCode(file, file1);

    }

    private void stealCode(File file, File file1) {
        // Overall method that allows us to rip this method and use it on each individual method above and below.
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

    public void soupTransfer() throws NumberFormatException {
        // Method is called when the button correlated to Soup is pressed.
        FriedChicken.clear();
        TestIngredients.clear();
        testTutorial.clear();

        tabPane.getSelectionModel().select(Opskrift);
        FriedChicken.appendText("Ingredients for a good soup recipe");
        // Instantiated the files I want specifically when Soup is called.

        File file = new File("Soup.txt");
        File file1 = new File("SoupTutorial.txt");
        stealCode(file, file1);

    }
    // TODO: Add an arbitrary recipe/ingredientslist from google at last.

    public void steakTransfer() {
        // Method is called when the button correlated to Steak is pressed.

        FriedChicken.clear();
        TestIngredients.clear();
        testTutorial.clear();

        tabPane.getSelectionModel().select(Opskrift);
        FriedChicken.appendText("Ingredients for a good Steak recipe");
        // Instantiated the files I want specifically when Steak is called.

        File file = new File("Steak.txt");
        File file1 = new File("SteakTutorial.txt");
        stealCode(file, file1);
    }
    // TODO: Add an arbitrary recipe/ingredientslist from google at last.

    public void riceTransfer() {
        // Method is called when the button correlated to Rice is pressed.

        FriedChicken.clear();
        TestIngredients.clear();
        testTutorial.clear();
        tabPane.getSelectionModel().select(Opskrift);
        FriedChicken.appendText("Ingredients for a good Rice recipe");
        // Instantiated the files I want specifically when Rice is called.

        File file = new File("Rice.txt");
        File file1 = new File("RiceTutorial.txt");
        stealCode(file, file1);

    }

    public void burgerTransfer() {
        // Method is called when the button correlated to Burger is pressed.

        FriedChicken.clear();
        TestIngredients.clear();
        testTutorial.clear();
        tabPane.getSelectionModel().select(Opskrift);
        FriedChicken.appendText("Ingredients for a good Burger recipe");
        // Instantiated the files I want specifically when Burger is called.

        File file = new File("Burger.txt");
        File file1 = new File("BurgerTutorial.txt");
        stealCode(file, file1);
    }

    public void lasagnaTransfer() {
        // Method is called when the button correlated to Lasagna is pressed.

        FriedChicken.clear();
        TestIngredients.clear();
        testTutorial.clear();
        tabPane.getSelectionModel().select(Opskrift);
        FriedChicken.appendText("Ingredients for a good Lasagna recipe");
        // Instantiated the files I want specifically when Lasagna is called.

        File file = new File("Lasagna.txt");
        File file1 = new File("LasagnaTutorial.txt");
        stealCode(file, file1);

    }

    public void setLogsButtonOnAction() {
        // When the tab has been pressed, it will instantiate all the buttons included in the pane.
        // This will allow the program to, once a specific button is pressed - to append the texts of the
        // textfiles into the textAreas.
        soupSave.setOnAction(e -> {
            try {
                logs(new File("Soup.txt"), new File("SoupTutorial.txt"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        steakSave.setOnAction(e -> {
            try {
                logs(new File("Steak.txt"), new File("SteakTutorial.txt"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        burgerSave.setOnAction(e -> {
            try {
                logs(new File("Burger.txt"), new File("BurgerTutorial.txt"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        lasagnaSave.setOnAction(e -> {
            try {
                logs(new File("Lasagna.txt"), new File("LasagnaTutorial.txt"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        riceSave.setOnAction(e -> {
            try {
                logs(new File("Rice.txt"), new File("RiceTutorial.txt"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        chickenSave.setOnAction(e -> {
            try {
                logs(new File("Chicken.txt"), new File("ChickenTutorial.txt"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
    }


    // Logs - let's the user choose a specific recipe and save it on their own.
    public void logs(File file1, File file2) throws IOException {

        // For every time our file has a readable line, it appends that line and does a space so that it becomes readable.
        try (Scanner soupIngredient = new Scanner(file1)) {
            while (soupIngredient.hasNextLine()) {
                saveIngredients.appendText(soupIngredient.nextLine() + "\n");
                // TODO: Add tutorial on how to cook on the side too. Do with the rest.
            }
        } // Just in case that this can fail, as i'm working with files.
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        // Reads the second file.
        try (Scanner soupTutorials = new Scanner(file2)) {
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
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            } else {
                // All will be saved/created/exited.
                logsSave.appendText("File created - document is saved on exit.");
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

    public void setOnButtonIndhold() {
        /* Kunne også anvende klassevariabler for at opfylde opgave-kravet, men jeg synes at klassevariabler
        passer ret elendigt ind i min udvalgte kogebog.
        */
        // Defining specific nutritionvalues in a seperate method, so when the tab is executed -
        // all these values will be instantiated.
        nutritionBurger.setOnAction(e -> {
            naeringsIndhold(10, 10, 10);
        });
        nutritionLasagna.setOnAction(e -> {
            naeringsIndhold(500, 30, 100);
        });
        nutritionSoup.setOnAction(e -> {
            naeringsIndhold(130, 12, 200);
        });
        nutritionRice.setOnAction(e -> {
            naeringsIndhold(160, 12, 105);
        });
        nutritionSteak.setOnAction(e -> {
            naeringsIndhold(200, 50, 90);
        });
        nutritionChicken.setOnAction(e -> {
            naeringsIndhold(500, 20, 12);
        });
    }

    public void naeringsIndhold(int Calories, int Salt, int Protein) {
        // Calling the values here from the above-mentioned method.
        nutritionValues.clear();
        nutritionValues.appendText("Calories: " + Calories + "\nSalt: " + Salt + "\nProtein: " + Protein);
    }

    // TODO: Overall missing features!: Test/Algorithm/Array-ArrayList/Enum.
}
