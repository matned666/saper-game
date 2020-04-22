package eu.mrndesign.matned.jFrame;

import eu.mrndesign.matned.gameLogic.FieldObj;

import javax.swing.*;

class JField {

    private static final String FILE_PATH = "src\\main\\resources\\saper\\";
    private static final String SAPER_BUTTON_FIELD_imagePATH = FILE_PATH + "saperButtonField.png";
    private static final String SAPER_BOMB_FIELD_imagePATH = FILE_PATH + "saperBombField.png";
    private static final String SAPER_CHECKED_BOMB_FIELD__imagePATH = FILE_PATH + "saperCheckedBombField.png";
    private static final String SAPER_BLOWN_BOMB_FIELD__imagePATH = FILE_PATH + "saperBlownBombField.png";
    private static final String SAPER_EMPTY_FIELD__imagePATH = FILE_PATH + "saperEmptyField.png";
    private JButton button;
    private JLabel label;
    private FieldObj fieldData;


    JField(FieldObj fieldData, int col, int row) {
        this.fieldData = fieldData;
        draw();
        label.setBounds(col, row, 20, 20);
        button = new JButton(new ImageIcon(SAPER_BUTTON_FIELD_imagePATH));
        button.setBounds(col, row, 20, 20);
    }

    JButton getButton() {
        return button;
    }

    JLabel getLabel() {
        return label;
    }

    private void draw() {
        if (fieldData.isBomb() && !fieldData.isChecked() && !fieldData.isBlownBomb())
            label = new JLabel(new ImageIcon(SAPER_BOMB_FIELD_imagePATH));
        else if (fieldData.isBomb() && fieldData.isChecked() && !fieldData.isBlownBomb())
            label = new JLabel(new ImageIcon(SAPER_CHECKED_BOMB_FIELD__imagePATH));
        else if (fieldData.isBomb() && fieldData.isBlownBomb())
            label = new JLabel(new ImageIcon(SAPER_BLOWN_BOMB_FIELD__imagePATH));
        else {
            if (fieldData.getNumberOfBombsInSurround() == 0)
                label = new JLabel(new ImageIcon(SAPER_EMPTY_FIELD__imagePATH));
            else {
                label = new JLabel(new ImageIcon(JField.SAPER_EMPTY_FIELD__imagePATH));
                label.setText(String.valueOf(fieldData.getNumberOfBombsInSurround()));
                label.setHorizontalTextPosition(JLabel.CENTER);
                label.setVerticalTextPosition(JLabel.CENTER);
            }
        }
    }

}
