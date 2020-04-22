package eu.mrndesign.matned.jFrame;

import eu.mrndesign.matned.exceptions.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class JFrameController {

    private static final String IMAGE_PATH = "src\\main\\resources\\saper\\";
    private static final String MINE_FIELD_FIRST_imagePATH = IMAGE_PATH + "mine_field_first.png";
    private static final String ACCEPT_BUTTON_imagePATH = IMAGE_PATH + "buttonAccept.png";
    private static final String MORE_BOMBS_THAN_FIELDS_MSG = "More bombs than fields, try again:";
    private static final String TOO_LARGE_FIELD_MSG = "Too large field, try to fit in 70 columns and 35 rows:";
    private static final String INPUT_CORRECT_PARAMETERS_MSG = "Input CORRECT parameters of your game:";
    private static final String TOP_100_BUTTON_TEXT = "TOP 100";
    private static final String FIELDS_TXT = "fields";
    private static final String BOMBS_TXT = "bombs";
    private static final String ACCEPT_GAME_BUTTON_TEXT = "ACCEPT GAME";
    private static final String WRITE_NAME_LABEL = "You can write your name:";
    private static final String COLUMNS_NO_LABEL = "Columns no.(max 70):";
    private static final String ROWS_NO_LABEL = "Rows no.(max 35):";
    private static final String NUMBER_OF_BOMBS_LABEL = "Number of bombs:";

    private JLabel firstWindowMessage = new JLabel();
    private JTextField chooseXSizeField;
    private JTextField chooseYSizeField;
    private JTextField chooseNumberOfBombs;
    private String name;
    private JTextField writeYourName;


    public JFrameController() {

    }

    public void initialize() {
        firstWindowMessage.setBounds(10, 5, 400, 30);
        firstWindowMessage.setText("Input parameters of your game:");
        firstWindow();
    }

    private void firstWindow() {
        JFrame firstWindow = new JFrame();
        firstWindow.setTitle("Super Retro Saper v.1.0");
        firstWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        firstWindow.setSize(540, 250);
        firstWindow.setResizable(false);
        firstWindow.add(acceptButton());
        firstWindow.add(chooseXSizeField());
        firstWindow.add(chooseYSizeField());
        firstWindow.add(chooseNumberOfBombs());
        firstWindow.add(chooseXSizeFieldJLabel());
        firstWindow.add(chooseYSizeFieldJLabel());
        firstWindow.add(chooseNumberOfBombsJLabel());
        firstWindow.add(firstWindowMessage);
        firstWindow.add(firstWindowImageLabel());
        firstWindow.add(topScoreButton());
        firstWindow.add(writeYourName());
        firstWindow.add(writeYourNameJLabel());
        firstWindow.setLayout(null);
        firstWindow.setVisible(true);
    }

    private Component chooseXSizeFieldJLabel() {
        JLabel chooseXSizeFieldJLabel = new JLabel();
        chooseXSizeFieldJLabel.setBounds(10, 25, 120, 30);
        chooseXSizeFieldJLabel.setText(COLUMNS_NO_LABEL);
        return chooseXSizeFieldJLabel;
    }

   private Component chooseYSizeFieldJLabel() {
       JLabel chooseYSizeFieldJLabel = new JLabel();
       chooseYSizeFieldJLabel.setBounds(150, 25, 120, 30);
       chooseYSizeFieldJLabel.setText(ROWS_NO_LABEL);
        return chooseYSizeFieldJLabel;
    }

   private Component chooseNumberOfBombsJLabel() {
       JLabel chooseNumberOfBombsJLabel = new JLabel();
       chooseNumberOfBombsJLabel.setBounds(290, 25, 120, 30);
       chooseNumberOfBombsJLabel.setText(NUMBER_OF_BOMBS_LABEL);
        return chooseNumberOfBombsJLabel;
    }

    private JTextField chooseXSizeField() {
        chooseXSizeField = new JTextField();
        addOnEnterKeyListener(chooseXSizeField);
        chooseXSizeField.setBounds(10, 50, 120, 40);
        return chooseXSizeField;
    }

    private JTextField chooseYSizeField() {
        chooseYSizeField = new JTextField();
        addOnEnterKeyListener(chooseYSizeField);
        chooseYSizeField.setBounds(150, 50, 120, 40);
        return chooseYSizeField;
    }

    private JTextField chooseNumberOfBombs() {
        chooseNumberOfBombs = new JTextField();
        addOnEnterKeyListener(chooseNumberOfBombs);
        chooseNumberOfBombs.setBounds(290, 50, 120, 40);
        return chooseNumberOfBombs;
    }


    private Component writeYourNameJLabel() {
        JLabel writeYourNameJLabel = new JLabel();
        writeYourNameJLabel.setBounds(10, 135, 400, 40);
        writeYourNameJLabel.setText(WRITE_NAME_LABEL);
        return writeYourNameJLabel;
    }
    private JTextField writeYourName() {
        writeYourName = new JTextField();
        addOnEnterKeyListener(writeYourName);
        writeYourName.setBounds(10, 165, 400, 40);
        return writeYourName;
    }

    private JButton acceptButton(){
        JButton acceptButton = new JButton(new ImageIcon(ACCEPT_BUTTON_imagePATH));
        acceptButton.setBounds(10, 100, 400, 40);
        acceptButton.setText(ACCEPT_GAME_BUTTON_TEXT);
        acceptButton.setHorizontalTextPosition(JLabel.CENTER);
        acceptButton.setVerticalTextPosition(JLabel.CENTER);
        acceptButton.addActionListener(actionEvent -> {
            try {

                if((Integer.parseInt(chooseXSizeField.getText())*Integer.parseInt(chooseYSizeField.getText())) <= Integer.parseInt(chooseNumberOfBombs.getText())){
                    System.out.println(FIELDS_TXT+":"+Integer.parseInt(chooseXSizeField.getText())*Integer.parseInt(chooseYSizeField.getText()));
                    System.out.println(BOMBS_TXT+":"+Integer.parseInt(chooseNumberOfBombs.getText()));
                    throw new TooMuchBombsException();
                }
                if(Integer.parseInt(chooseXSizeField.getText()) > 70 || Integer.parseInt(chooseYSizeField.getText()) > 35){
                    throw new TooBigFieldException();
                }

                JMatrix matrix = new JMatrix(Integer.parseInt(chooseXSizeField.getText()), Integer.parseInt(chooseYSizeField.getText()), Integer.parseInt(chooseNumberOfBombs.getText()));
                name = writeYourName.getText();
                matrix.getMatrix().setPlayerRandomName(name);




            } catch (TooMuchBombsException ex2){
                firstWindowMessage.setText(MORE_BOMBS_THAN_FIELDS_MSG);

        }  catch (TooBigFieldException ex2){
                firstWindowMessage.setText(TOO_LARGE_FIELD_MSG);

        } catch (Exception ex) {
                firstWindowMessage.setText(INPUT_CORRECT_PARAMETERS_MSG);
            }
        });
        return acceptButton;
    }

private JButton topScoreButton(){
    JButton topScoreButton = new JButton(new ImageIcon(ACCEPT_BUTTON_imagePATH));
    topScoreButton.setBounds(420, 165, 100, 40);
    topScoreButton.setText(TOP_100_BUTTON_TEXT);
    topScoreButton.setHorizontalTextPosition(JLabel.CENTER);
    topScoreButton.setVerticalTextPosition(JLabel.CENTER);
    topScoreButton.addActionListener(actionEvent -> new JTopScoreFrame());
        return topScoreButton;
    }

    private void addOnEnterKeyListener(JTextField textField){
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == 10) {
                    try {

                        if((Integer.parseInt(chooseXSizeField.getText())*Integer.parseInt(chooseYSizeField.getText())) <= Integer.parseInt(chooseNumberOfBombs.getText())){
                            System.out.println(FIELDS_TXT +":"+Integer.parseInt(chooseXSizeField.getText())*Integer.parseInt(chooseYSizeField.getText()));
                            System.out.println(BOMBS_TXT +":"+Integer.parseInt(chooseNumberOfBombs.getText()));
                            throw new TooMuchBombsException();
                        }
                        if(Integer.parseInt(chooseXSizeField.getText()) > 70 || Integer.parseInt(chooseYSizeField.getText()) > 35){
                            throw new TooBigFieldException();
                        }

                        JMatrix matrix = new JMatrix(Integer.parseInt(chooseXSizeField.getText()), Integer.parseInt(chooseYSizeField.getText()), Integer.parseInt(chooseNumberOfBombs.getText()));
                        name = writeYourName.getText();
                        matrix.getMatrix().setPlayerRandomName(name);



                    } catch (TooMuchBombsException ex2){
                        firstWindowMessage.setText(MORE_BOMBS_THAN_FIELDS_MSG);
                    }  catch (TooBigFieldException ex2){
                        firstWindowMessage.setText(TOO_LARGE_FIELD_MSG);

                    } catch (Exception ex) {
                        firstWindowMessage.setText(INPUT_CORRECT_PARAMETERS_MSG);
                    }
                }
            }
            @Override
            public void keyPressed(KeyEvent e) { }
            @Override
            public void keyReleased(KeyEvent e) { }  });
    }

    private JLabel firstWindowImageLabel() {
        JLabel imageLabel = new JLabel(new ImageIcon(MINE_FIELD_FIRST_imagePATH));
        imageLabel.setBounds(420, 10, 100, 150);
        return imageLabel;
    }

}
