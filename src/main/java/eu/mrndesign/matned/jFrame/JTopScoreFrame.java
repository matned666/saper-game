package eu.mrndesign.matned.jFrame;

import eu.mrndesign.matned.fileOperations.ScoreTop100List;

import javax.swing.*;

class JTopScoreFrame {

    private static final String HTML_OFF = "</html>";
    private static final String HTML_ON = "<html>";
    private static final String P_OFF = "</p>";
    private static final String P_ON = "<p>";
    private static final String SAPER_TOP_SCORE_TITLE = "Saper TOP SCORE";

    private ScoreTop100List list;
    private JLabel resultLabel;

    JTopScoreFrame() {
        list = new ScoreTop100List();
        resultLabel = new JLabel();
        init();
    }

    private void init() {
        JFrame firstWindow = new JFrame();
        firstWindow.setTitle(SAPER_TOP_SCORE_TITLE);
        firstWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        firstWindow.setSize(535,740);
        firstWindow.setResizable(false);
        firstWindow.add(resultLabel());
        addText();
        firstWindow.setLayout(null);
        firstWindow.setVisible(true);
    }

    private JScrollPane resultLabel() {
        resultLabel.setBounds(20, 20, 480, 660);
        resultLabel.setVerticalAlignment(SwingConstants.TOP);
        resultLabel.setText("");
        JScrollPane scroller = new JScrollPane(resultLabel);
        scroller.setBounds(20, 20, 480, 660);
        return scroller;
    }

    private void addText(){
        StringBuilder tempStr = new StringBuilder();
        list.read();
        tempStr.append(HTML_ON);
        for(int i = 0; i < list.get().size(); i++){
            tempStr.append(P_ON).append((list.get().get(i)).toString()).append(P_OFF);
        }
        tempStr.append(HTML_OFF);
        resultLabel.setText(tempStr.toString());

    }

}
