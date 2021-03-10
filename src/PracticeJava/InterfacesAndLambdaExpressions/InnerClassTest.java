package PracticeJava.InterfacesAndLambdaExpressions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

public class InnerClassTest {

    public static void main(String args[]){
            TalkingClock clock = new TalkingClock(1000, true);
            clock.start();
            JOptionPane.showMessageDialog(null, "Quit program?");
            System.exit(0);
    }
}
class TalkingClock {
    private int interval;
    private boolean beep;

    /**
     * Constructs a talking clock
     *
     * @param interval the interval between messages (in milliseconds)
     * @param beep     true if the clock should beep
     */
    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    /**
     * Starts the clock.
     */
    public void start() {
        /**
         * local innder class are classes that are placed inside the method that is using that class.
         * and that class is being used only once in its life time.
         * See here TimePrinter class is used only once in this start method so we are
         * adding te class TimePrinter in this start method only
         * and this is called local inner class.
         */
        class TimePrinter implements ActionListener {
            public void actionPerformed(ActionEvent event) {
                System.out.println("At the tone, the time is "
                        + Instant.ofEpochMilli(event.getWhen()));
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        }
        TimePrinter listener = new TimePrinter();
        Timer timer = new Timer(interval, listener);
        timer.start();
    }

    /**
     * 6.3.5 Accessing variables from outer methods.
     *
     */


}
