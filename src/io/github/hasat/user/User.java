package io.github.hasat.user;

import io.github.hasat.card.Card;
import java.util.ArrayList;
import java.util.List;

public class User {
    
    private int id;
    
    private String name, surname, mail, phone, password, registerTime;
    
    private List<Card> cards = new ArrayList<>();
    
    public User(String name, String surname, String mail, String phone, String password, String registerTime) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.phone = phone;
        this.password = password;
        this.registerTime = registerTime;
    }
    
    public Card getCardByID(String cardID) {
        for (Card card : cards) {
            if (card.getCardID().equals(cardID)) {
                return card;
            }
        }
        
        return null;
    }
    
    public int getID() {
        return id;
    }
    
    public void setID(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getSurname() {
        return surname;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public String getMail() {
        return mail;
    }
    
    public void setMail(String mail) {
        this.mail = mail;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getRegisterTime() {
        return registerTime;
    }
    
    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }
    
    public List<Card> getCards() {
        return cards;
    }
    
    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
