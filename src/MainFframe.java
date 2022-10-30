import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;

public class MainFframe extends JFrame implements ActionListener{
    MenuTest mt = new MenuTest();
    PlayAreo pa = new PlayAreo();
    MainFframe() {
        mt.pressToStartButton.addActionListener(this);
        pa.goBackButton.addActionListener(this);
        pa.pressToStartButton.addActionListener(this);

        add(mt.panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mt.pressToStartButton) {
            boolean oneOne = false;
            boolean oneTwo = false;
            boolean twoOne = false;
            boolean twoTwo = false;
            try {
                firstFirst = Integer.parseInt(mt.firstFirstNumber.getText());
            } catch (NumberFormatException exception) {
                if (!mt.firstFirstNumber.getText().isEmpty()) {
                    System.out.println("Invalid1.1");
                    oneOne = true;
                } else {
                    firstFirst = 1;
                }
            }
            try {
                firstSecond = Integer.parseInt(mt.firstSecondNumber.getText());
            } catch (NumberFormatException exception) {
                if (!mt.firstSecondNumber.getText().isEmpty()) {
                    System.out.println("Invalid1.2");
                    oneTwo = true;
                } else {
                    firstSecond = 100;
                }
            }
            try {
                secondFirst = Integer.parseInt(mt.secondFirstNumber.getText());
            } catch (NumberFormatException exception) {
                if (!mt.secondFirstNumber.getText().isEmpty()) {
                    System.out.println("Invalid2.1");
                    twoOne = true;
                } else {
                    secondFirst = 1;
                }
            }
            try {
                secondSecond = Integer.parseInt(mt.secondSecondNumber.getText());
            } catch (NumberFormatException exception) {
                if (!mt.secondSecondNumber.getText().isEmpty()) {
                    System.out.println("Invalid2.2");
                    twoTwo = true;
                } else {
                    secondSecond = 100;
                }
            }
            if (oneOne || oneTwo || twoOne || twoTwo) {
                JOptionPane.showMessageDialog(this, "The number ranges must contain Integer values", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                if ((firstFirst >= firstSecond) || (secondFirst >= secondSecond)) {
                    JOptionPane.showMessageDialog(this, "The first number cannot be equal to or larger than the second number", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    pa.topLabel.setText("Press the Start Button or Space to Start The Timer");
                    remove(mt.panel);
                    add(pa.panel1);
                    validate();
                    repaint();
                    pack();
                }
            }
        } else if (e.getSource() == pa.goBackButton) {
            stopGame();
            remove(pa.panel1);
            add(mt.panel);
            validate();
            repaint();
            pack();
        } else if (e.getSource() == pa.pressToStartButton) {
            if (!started) {
                startGame();
                started = true;
            } else {
                stopGame();
                started = false;
            }
        }
    }
    int firstFirst;
    int firstSecond;
    int secondFirst;
    int secondSecond;

    boolean started;
    int answer;
    private void startGame() {
        Random random = new Random();
        int firstNumber = random.nextInt(firstFirst, firstSecond);
        int secondNubmer = random.nextInt(secondFirst, secondSecond);
        String operator;
        if (Objects.equals(mt.operatorBox.getSelectedItem(), "Random")) {
            String[] operators = {"+", "-", "*", "/"};
            operator = operators[random.nextInt(0, 4)];
        } else operator = String.valueOf(mt.operatorBox.getSelectedItem());

        switch (operator) {
            case "+" -> answer = firstNumber + secondNubmer;
            case "-" -> answer = firstNumber - secondNubmer;
            case "*" -> answer = firstNumber * secondNubmer;
            case "/" -> answer = firstNumber / secondNubmer;
        }

        pa.firstTimer.start();
        pa.topLabel.setText("The question is : " + firstNumber + operator + secondNubmer + " ?");
//        pack();
    }

    private void stopGame() {
        pa.topLabel.setText("The answer was: " + answer);
//        pa.elapsedTimeLabel.setText("Took " + pa.seconds + (pa.seconds == 1 ? " second" : " seconds"));
//        pack();
        pa.firstTimer.stop();
        pa.elapsedTime = 0;
    }
}
