package Sudoku;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class test {
    JFrame window;
    JLabel counterLabel;
    Font font1 = new Font("pixellet", Font.PLAIN, 30);

    Timer timer;
    int second, minute;
    String ddSecond, ddMiunte;

    DecimalFormat dFormat = new DecimalFormat("00");

    public static void main(String[] args) {
        new test();
    }

    public test() {
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);

        counterLabel = new JLabel("");
        counterLabel.setBounds(300, 230, 200, 100);
        counterLabel.setHorizontalAlignment(JLabel.CENTER);
        counterLabel.setFont(font1);

        window.add(counterLabel);
        window.setVisible(true);

        counterLabel.setText("00:00");
        second = 0;
        minute = 0;
        Timer();
        timer.start();

    }

    // public void Timer() {
    // timer = new Timer(1000, new ActionListener() {

    // @Override
    // public void actionPerformed(ActionEvent e) {
    // second++;

    // counterLabel.setText("" + second);
    // }
    // });
    // }

    public void Timer() {
        timer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                second++;

                ddSecond = dFormat.format(second);
                ddMiunte = dFormat.format(minute);

                counterLabel.setText(ddMiunte + ":" + ddSecond);

                if (second == 60) {
                    second = 0;
                    minute++;

                    ddSecond = dFormat.format(second);
                    ddMiunte = dFormat.format(minute);
                    counterLabel.setText(ddMiunte + ":" + ddSecond);
                }
            }

        });
    }

}
