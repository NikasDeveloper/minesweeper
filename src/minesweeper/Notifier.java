package minesweeper;

import javax.swing.*;

public class Notifier {

    public static void win() {
        JOptionPane.showMessageDialog(null, "You won!");
    }

    public static void loose() {
        JOptionPane.showMessageDialog(null, "You lost!");
    }

}
