/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 * @author LebedenkoN
 */
public class GameFrame extends JFrame {

    private static final int APP_WIDTH = 1000;
    private static final int APP_HEIGHT = 800;

    public GameFrame(String title) {
        super(title);
        this.setSize(APP_WIDTH, APP_HEIGHT);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
