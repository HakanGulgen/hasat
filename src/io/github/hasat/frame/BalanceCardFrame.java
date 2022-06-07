/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package io.github.hasat.frame;

import io.github.hasat.card.Card;
import io.github.hasat.database.MySQL;
import io.github.hasat.user.User;
import io.github.hasat.user.UserManager;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.List;
import javax.swing.Timer;

/**
 *
 * @author hakan
 */
public class BalanceCardFrame extends javax.swing.JFrame {
    
    /**
     * Creates new form RegisterFrame
     */
    public BalanceCardFrame() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        if (!UserManager.isUserExists()) {
            dispose();
            
            new LoginFrame().setVisible(true);
            
            return;
        }
        
        User user = UserManager.getUser();
        
        List<Card> cards = user.getCards();
        
        if (cards.isEmpty()) {
            return;
        }
        
        for (Card card : cards) {
            cardTypes.addItem(card.getCardID());
        }
        
        currentBalance.setText(currentBalance.getText().replace("<balance>", user.getCardByID(cardTypes.getItemAt(0)).getBalance() + ""));
        
        cardNameText.setText(user.getCardByID(cardTypes.getItemAt(0)).getCardName());
        
        cardTypes.addItemListener((ItemEvent item) -> {
            if (item.getStateChange() == ItemEvent.SELECTED) {
                cardNameText.setText(user.getCardByID(item.getItem().toString()).getCardName());
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        hundredButton = new javax.swing.JButton();
        warningLabel = new javax.swing.JLabel();
        balanceUpdateButton = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        cardNumberLabel = new javax.swing.JLabel();
        tlLabel = new javax.swing.JLabel();
        cardTypes = new javax.swing.JComboBox<>();
        balanceAmount = new javax.swing.JTextField();
        cardNameText = new javax.swing.JTextField();
        currentBalance = new javax.swing.JLabel();
        backButton1 = new javax.swing.JButton();
        fiveButton = new javax.swing.JButton();
        tenButton = new javax.swing.JButton();
        fiftyButton = new javax.swing.JButton();
        balanceLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HASAT Ulaşım");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/io/github/hasat/images/bus.png")).getImage());
        setResizable(false);

        panel.setBackground(new java.awt.Color(2, 44, 74));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 24)); // NOI18N
        logoLabel.setForeground(new java.awt.Color(255, 255, 255));
        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/io/github/hasat/images/newbus.png"))); // NOI18N
        logoLabel.setText("HASAT Ulaşım");
        logoLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        logoLabel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        panel.add(logoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));
        panel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 430, 11));

        hundredButton.setBackground(new java.awt.Color(2, 44, 74));
        hundredButton.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        hundredButton.setForeground(new java.awt.Color(255, 255, 255));
        hundredButton.setText("100");
        hundredButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        hundredButton.setFocusPainted(false);
        hundredButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hundredButtonMouseEntered(evt);
            }
        });
        hundredButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hundredButtonActionPerformed(evt);
            }
        });
        panel.add(hundredButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, 60, 50));

        warningLabel.setBackground(new java.awt.Color(2, 44, 74));
        warningLabel.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        warningLabel.setForeground(new java.awt.Color(255, 255, 255));
        warningLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        warningLabel.setOpaque(true);
        panel.add(warningLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 196, 200, 170));

        balanceUpdateButton.setBackground(new java.awt.Color(2, 44, 74));
        balanceUpdateButton.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        balanceUpdateButton.setForeground(new java.awt.Color(255, 255, 255));
        balanceUpdateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/io/github/hasat/images/money.png"))); // NOI18N
        balanceUpdateButton.setText("Bakiye Yükle");
        balanceUpdateButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        balanceUpdateButton.setFocusPainted(false);
        balanceUpdateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                balanceUpdateButtonMouseEntered(evt);
            }
        });
        balanceUpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                balanceUpdateButtonActionPerformed(evt);
            }
        });
        panel.add(balanceUpdateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 390, 430, 80));

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        panel.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 10, 470));

        cardNumberLabel.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        cardNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        cardNumberLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/io/github/hasat/images/card.png"))); // NOI18N
        cardNumberLabel.setText("Kart:");
        panel.add(cardNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        tlLabel.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        tlLabel.setForeground(new java.awt.Color(255, 255, 255));
        tlLabel.setText("Türk Lirası");
        panel.add(tlLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 260, -1, -1));

        cardTypes.setBackground(new java.awt.Color(2, 44, 74));
        cardTypes.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        cardTypes.setForeground(new java.awt.Color(255, 255, 255));
        cardTypes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        panel.add(cardTypes, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 430, 40));

        balanceAmount.setBackground(new java.awt.Color(2, 44, 74));
        balanceAmount.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        balanceAmount.setForeground(new java.awt.Color(255, 255, 255));
        balanceAmount.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        balanceAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                balanceAmountKeyTyped(evt);
            }
        });
        panel.add(balanceAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 300, 38));

        cardNameText.setBackground(new java.awt.Color(2, 44, 74));
        cardNameText.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        cardNameText.setForeground(new java.awt.Color(255, 255, 255));
        cardNameText.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        panel.add(cardNameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 430, 38));

        currentBalance.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        currentBalance.setForeground(new java.awt.Color(255, 255, 255));
        currentBalance.setText("Güncel Bakiye: <balance> Türk Lirası");
        panel.add(currentBalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 430, -1));

        backButton1.setBackground(new java.awt.Color(2, 44, 74));
        backButton1.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        backButton1.setForeground(new java.awt.Color(255, 255, 255));
        backButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/io/github/hasat/images/back.png"))); // NOI18N
        backButton1.setText("Geri Dön");
        backButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        backButton1.setFocusPainted(false);
        backButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backButton1MouseEntered(evt);
            }
        });
        backButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton1ActionPerformed(evt);
            }
        });
        panel.add(backButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 200, 80));

        fiveButton.setBackground(new java.awt.Color(2, 44, 74));
        fiveButton.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        fiveButton.setForeground(new java.awt.Color(255, 255, 255));
        fiveButton.setText("5");
        fiveButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        fiveButton.setFocusPainted(false);
        fiveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fiveButtonMouseEntered(evt);
            }
        });
        fiveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveButtonActionPerformed(evt);
            }
        });
        panel.add(fiveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 60, 50));

        tenButton.setBackground(new java.awt.Color(2, 44, 74));
        tenButton.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        tenButton.setForeground(new java.awt.Color(255, 255, 255));
        tenButton.setText("10");
        tenButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tenButton.setFocusPainted(false);
        tenButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tenButtonMouseEntered(evt);
            }
        });
        tenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenButtonActionPerformed(evt);
            }
        });
        panel.add(tenButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 320, 60, 50));

        fiftyButton.setBackground(new java.awt.Color(2, 44, 74));
        fiftyButton.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        fiftyButton.setForeground(new java.awt.Color(255, 255, 255));
        fiftyButton.setText("50");
        fiftyButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        fiftyButton.setFocusPainted(false);
        fiftyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fiftyButtonMouseEntered(evt);
            }
        });
        fiftyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiftyButtonActionPerformed(evt);
            }
        });
        panel.add(fiftyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, 60, 50));

        balanceLabel.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        balanceLabel.setForeground(new java.awt.Color(255, 255, 255));
        balanceLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/io/github/hasat/images/money.png"))); // NOI18N
        balanceLabel.setText("Yükleme Tutarı:");
        panel.add(balanceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hundredButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hundredButtonMouseEntered
        hundredButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_hundredButtonMouseEntered

    private void balanceUpdateButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_balanceUpdateButtonMouseEntered
        balanceUpdateButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_balanceUpdateButtonMouseEntered

    private void balanceAmountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_balanceAmountKeyTyped
        String key = String.valueOf(evt.getKeyChar());
        
        try {
            Integer.parseInt(key);
        } catch (NumberFormatException e) {
            evt.consume();
            return;
        }
        
        if (balanceAmount.getText().length() > 3) {
            evt.consume();
            return;
        }

        balanceAmount.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
    }//GEN-LAST:event_balanceAmountKeyTyped

    private void backButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButton1MouseEntered
        backButton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_backButton1MouseEntered

    private void fiveButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fiveButtonMouseEntered
        fiveButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_fiveButtonMouseEntered

    private void tenButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tenButtonMouseEntered
        tenButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_tenButtonMouseEntered

    private void fiftyButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fiftyButtonMouseEntered
        fiftyButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_fiftyButtonMouseEntered

    private void fiveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveButtonActionPerformed
        balanceAmount.setText("5");
    }//GEN-LAST:event_fiveButtonActionPerformed

    private void tenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenButtonActionPerformed
        balanceAmount.setText("10");
    }//GEN-LAST:event_tenButtonActionPerformed

    private void fiftyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiftyButtonActionPerformed
        balanceAmount.setText("50");
    }//GEN-LAST:event_fiftyButtonActionPerformed

    private void hundredButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hundredButtonActionPerformed
        balanceAmount.setText("100");
    }//GEN-LAST:event_hundredButtonActionPerformed

    private void balanceUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_balanceUpdateButtonActionPerformed
        String balanceAmountText = balanceAmount.getText();
        
        if (balanceAmountText.isEmpty()) {
            balanceAmount.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(250, 49, 74)));
            warningLabel.setBackground(new Color(99,16,1));
            warningLabel.setText("<html>&nbsp;● Bakiye miktarını<br>&nbsp;girmelisiniz!</html>");
            return;
        }
        
        int amount = Integer.parseInt(balanceAmountText);
        
        if (amount <= 0 || amount > 1000) {
            balanceAmount.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(250, 49, 74)));
            warningLabel.setBackground(new Color(99,16,1));
            warningLabel.setText("<html>&nbsp;● Bakiye miktarı 0 ve<br>&nbsp;1000 TL arasında olmalıdır!</html>");
            return;
        }
        
        User user = UserManager.getUser();
        
        if (user == null) {
            dispose();
            
            new LoginFrame().setVisible(true);
            
            return;
        }
        
        String cardID = cardTypes.getItemAt(cardTypes.getSelectedIndex());
        
        Card card = user.getCardByID(cardID);
        
        card.setBalance(card.getBalance() + amount);
        
        MySQL.updateCard(card);
        
        warningLabel.setBackground(new Color(1,95,24));
        warningLabel.setText("<html>&nbsp;● Bakiyeniz<br>&nbsp;başarıyla güncellendi!<br><br>&nbsp;&nbsp;Yönlendiriliyorsunuz...</html>");
        
        ActionListener action = (ActionEvent ae) -> {
            dispose();

            new CardsFrame().setVisible(true);
        };

        Timer t = new Timer(3000, action);

        t.setRepeats(false);
        t.start();
    }//GEN-LAST:event_balanceUpdateButtonActionPerformed

    private void backButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton1ActionPerformed
        dispose();
        
        new ProfileFrame().setVisible(true);
    }//GEN-LAST:event_backButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton1;
    private javax.swing.JTextField balanceAmount;
    private javax.swing.JLabel balanceLabel;
    private javax.swing.JButton balanceUpdateButton;
    private javax.swing.JTextField cardNameText;
    private javax.swing.JLabel cardNumberLabel;
    private javax.swing.JComboBox<String> cardTypes;
    private javax.swing.JLabel currentBalance;
    private javax.swing.JButton fiftyButton;
    private javax.swing.JButton fiveButton;
    private javax.swing.JButton hundredButton;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JPanel panel;
    private javax.swing.JButton tenButton;
    private javax.swing.JLabel tlLabel;
    private javax.swing.JLabel warningLabel;
    // End of variables declaration//GEN-END:variables
}
