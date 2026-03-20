
/*
 *  Project: TestingElementalMaster
 *  Author: Dash 
 *  Date: Mar 20, 2026
 */
package game.ui.battle.engine;

import javax.swing.JTextArea;

public class CombatLog {
    private JTextArea textArea;
    private final int WIDTH = 25;

    public CombatLog(JTextArea textArea) {
        this.textArea = textArea;
    }

    public void log(String text) {
        int padding = Math.max(0, (WIDTH - text.length()) / 2);
        StringBuilder centeredText = new StringBuilder();
        for (int i = 0; i < padding; i++) centeredText.append(" ");
        
        textArea.append(centeredText.toString() + text + "\n");
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
    
    public void clear() {
        textArea.setText("");
    }
}
