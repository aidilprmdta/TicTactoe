package TicTacToe;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel tittlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] button = new JButton[9];
    boolean pemain1;

    TicTacToe() {
        //Fitur
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        //Background & Border
        textField.setBackground(new Color(25, 225, 0));
        textField.setFont(new Font("Ink Free", Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("TicTacToe");
        textField.setOpaque(true);

        tittlePanel.setLayout(new BorderLayout());
        tittlePanel.setBounds(10, 10, 700, 100);

        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < 9; i++) {
            button[i] = new JButton();
            buttonPanel.add(button[i]);
            button[i].setFont( new Font("MV Boli", Font.BOLD, 120));
            button[i].setFocusable(false);
            button[i].addActionListener(this);
        }

        //Penambahan
        tittlePanel.add(textField);
        frame.add(tittlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel);

        giliran();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        for (int i = 0; i < 9; i++) {
            if (event.getSource() == button[i]) {
                if (pemain1) {
                    if (button[i].getText().equals("")) {
                        button[i].setForeground(new Color(225, 0, 0));
                        button[i].setText("X");
                        pemain1 = false;
                        textField.setText("O Turn");
                    }
                } else {
                    if (button[i].getText().equals("")) {
                        button[i].setForeground(new Color(0, 0, 225));
                        button[i].setText("O");
                        pemain1 = true;
                        textField.setText("X Turn");
                    }
                }
                check();
            }
        }
    }

        public void giliran () {

            try {
                Thread.sleep(2000);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }

            if (random.nextInt(2) == 0) {
                pemain1 = true;
                textField.setText("X turn");
            } else {
                pemain1 = true;
                textField.setText("O turn");
            }
        }
        public void check() {
            //Pemain1
            if (    (button[0].getText().equals("X")) &&
                    (button[1].getText().equals("X")) &&
                    (button[2].getText().equals("X"))) {
                xWins(0, 1, 2);
            }
            if (    (button[3].getText().equals("X")) &&
                    (button[4].getText().equals("X")) &&
                    (button[5].getText().equals("X"))) {
                xWins(3, 4, 5);
            }
            if (    (button[6].getText().equals("X")) &&
                    (button[7].getText().equals("X")) &&
                    (button[8].getText().equals("X"))) {
                xWins(6, 7, 8);
            }
            if (    (button[0].getText().equals("X")) &&
                    (button[3].getText().equals("X")) &&
                    (button[6].getText().equals("X"))) {
                xWins(0, 3, 6);
            }
            if (    (button[1].getText().equals("X")) &&
                    (button[4].getText().equals("X")) &&
                    (button[7].getText().equals("X"))) {
                xWins(1, 4, 7);
            }
            if (    (button[2].getText().equals("X")) &&
                    (button[5].getText().equals("X")) &&
                    (button[8].getText().equals("X"))) {
                xWins(2, 5, 8);
            }
            if (    (button[0].getText().equals("X")) &&
                    (button[4].getText().equals("X")) &&
                    (button[8].getText().equals("X"))) {
                xWins(0, 4, 8);
            }
            if (    (button[2].getText().equals("X")) &&
                    (button[4].getText().equals("X")) &&
                    (button[6].getText().equals("X"))) {
                xWins(2, 4, 6);
            }
            //Pemain2
            if (    (button[0].getText().equals("O")) &&
                    (button[1].getText().equals("O")) &&
                    (button[2].getText().equals("O"))) {
                oWins(0, 1, 2);
            }
            if (    (button[3].getText().equals("O")) &&
                    (button[4].getText().equals("O")) &&
                    (button[5].getText().equals("O"))) {
                oWins(3, 4, 5);
            }
            if (    (button[6].getText().equals("O")) &&
                    (button[7].getText().equals("O")) &&
                    (button[8].getText().equals("O"))) {
                oWins(6, 7, 8);
            }
            if (    (button[0].getText().equals("O")) &&
                    (button[3].getText().equals("O")) &&
                    (button[6].getText().equals("O"))) {
                oWins(0, 3, 6);
            }
            if (    (button[1].getText().equals("O")) &&
                    (button[4].getText().equals("O")) &&
                    (button[7].getText().equals("O"))) {
                oWins(1, 4, 7);
            }
            if (    (button[2].getText().equals("O")) &&
                    (button[5].getText().equals("O")) &&
                    (button[8].getText().equals("O"))) {
                oWins(2, 5, 8);
            }
            if (    (button[0].getText().equals("O")) &&
                    (button[4].getText().equals("O")) &&
                    (button[8].getText().equals("O"))) {
                oWins(0, 4, 8);
            }
            if (    (button[2].getText().equals("O")) &&
                    (button[4].getText().equals("O")) &&
                    (button[6].getText().equals("O"))) {
                oWins(2, 4, 6);
            }
    }

    public void xWins(int a, int b, int c) {
        button[a].setBackground(Color.GREEN);
        button[b].setBackground(Color.GREEN);
        button[c].setBackground(Color.GREEN);

        for (int i = 0; i <9; i++) {
            button[i].setEnabled(false);
        }
        textField.setText("X Win");
        }

    public  void  oWins(int a, int b, int c) {
        button[a].setBackground(Color.GREEN);
        button[b].setBackground(Color.GREEN);
        button[c].setBackground(Color.GREEN);

        for (int i = 0; i <9; i++) {
            button[i].setEnabled(false);
        }
        textField.setText("O Win");
    }
}

