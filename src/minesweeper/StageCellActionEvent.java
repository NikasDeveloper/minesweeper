/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.awt.event.ActionEvent;

/**
 *
 * @author LebedenkoN
 */
public class StageCellActionEvent extends ActionEvent{
    
    public StageCellActionEvent(Object source, int id, String command) {
        super(source, id, command);
    }
    
}
