import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayAreo {
    public JPanel panel1;
    public JButton pressToStartButton;
    public JLabel elapsedTimeLabel;
    public JButton goBackButton;
    public JLabel topLabel;

    public int elapsedTime = 0;
    //? The thing is: 1 milisecond delay is too little for the java thread.
    //? Maybe a seperate thread just for the timer could be helpful but I think the guaranteed solution is
    //? to increase the delay by 15 or 20 and add the delay amount of elapsedTime to the variable.
    //? I'm sad that 1 milisecond delay doesn't work :(     -X
    Timer firstTimer = new Timer(35, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            elapsedTime += 35;
            int milisecs = (elapsedTime / 10) % 100;
            int seconds = (elapsedTime / 1000) % 60;
            int minutes = (elapsedTime / 60000) % 60;
            elapsedTimeLabel.setText(minutes + " : " + seconds + " : " + milisecs);
        }
    });
    //! NOLUYO AMK
}
