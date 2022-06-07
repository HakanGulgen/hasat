package io.github.hasat;

import io.github.hasat.database.MySQL;
import io.github.hasat.frame.LoginFrame;

public class Hasat {
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            MySQL.connect();
            
            new LoginFrame().setVisible(true);
        });
    }
}
