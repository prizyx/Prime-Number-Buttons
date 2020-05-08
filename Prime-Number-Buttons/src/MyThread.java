
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

public class MyThread extends Thread {

    int number;
    JButton button;
    int counter = 0;
    int remainder;

    MyThread(int number, JButton button) {
        this.number = number;
        this.button = button;
    }

    public void run() {

        while (true) {

            for (int i = 1; i <= number; i++) {
                remainder = number % i;
                if (remainder == 0) {
                    counter++;
                }
            }
            if (counter == 2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(JFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                yield();
                button.setText(String.valueOf(number));
            }
            counter = 0;
            number++;
        }
    }
}
