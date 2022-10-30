import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test implements ActionListener {
    JButton button = new JButton();
    JLabel firsTimeLable = new JLabel();
    JLabel secondTimeLable = new JLabel();
    int firstElapsed = 0;
    int firstSecond;
    Timer firstTimer = new Timer(1, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            firstElapsed++;
            firstSecond = (firstElapsed / 1000) % 60;
            firsTimeLable.setText(String.valueOf(firstSecond));
        }
    });
    int secondElapsed = 0;
    Timer secondTimer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            secondElapsed++;
            secondTimeLable.setText(String.valueOf(secondElapsed));
        }
    });
    Test() {
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        button.setText("START");
        frame.add(button);
        frame.add(firsTimeLable);
        frame.add(secondTimeLable);
        firsTimeLable.setText("1111111111111");
        secondTimeLable.setText("2222222222222");



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }
    public static void main(String[] args) {
        Test test = new Test();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            firstTimer.start();
            secondTimer.start();
        }
    }
}