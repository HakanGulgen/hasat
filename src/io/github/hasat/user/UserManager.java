/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.hasat.user;

/**
 *
 * @author hakan
 */
public class UserManager {
    
    private static User user;
    
    public static void setUser(User newUser) {
        user = newUser;
    }
    
    public static User getUser() {
        return user;
    }
    
    public static boolean isUserExists() {
        return user != null;
    }
}
