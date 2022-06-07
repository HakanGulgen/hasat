/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.hasat.card;

/**
 *
 * @author hakan
 */
public enum CardType {
    
    NORMAL("Normal Kart"),
    STUDENT("Öğrenci Kartı"),
    MALFORMED("Engelli Kartı");
    
    private String name;
    
    CardType(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}
