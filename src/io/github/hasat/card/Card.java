/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.hasat.card;

/**
 *
 * @author hakan
 */
public class Card {
    
    private int cardOwnerID, balance;
    
    private String cardID, cardName, createTime;
    
    private CardType cardType;
    
    public Card(int cardOwnerID, String cardID, String cardName, int balance, String createTime, CardType cardType) {
        this.cardOwnerID = cardOwnerID;
        this.cardName = cardName;
        this.cardID = cardID;
        this.balance = balance;
        this.createTime = createTime;
        this.cardType = cardType;
    }
    
    public int getCardOwnerID() {
        return cardOwnerID;
    }
    
    public String getCardName() {
        return cardName;
    }
    
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
    
    public int getBalance() {
        return balance;
    }
    
    public void setBalance(int balance) {
        this.balance = balance;
    }
    
    public String getCardID() {
        return cardID;
    }
    
    public String getCreateTime() {
        return createTime;
    }
    
    public CardType getCardType() {
        return cardType;
    }
}
