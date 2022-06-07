/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.hasat.database;

import io.github.hasat.card.Card;
import io.github.hasat.card.CardType;
import io.github.hasat.user.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author hakan
 */
public class MySQL {
    
    private static Connection connection;
    
    private final static String host = "localhost";

    private final static int port = 3306;

    private final static String database = "hasat_database", user = "root", password = "";
    
    public static void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, user, password);
        } catch (Exception e) {
            System.out.println("MYSQL BAGLANTISI KURULAMADI!");
        }
    }

    public static boolean createUser(User user) {
        String time = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date(System.currentTimeMillis()));

        try {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate("INSERT INTO users (name, surname, mail, phone, password, registerTime) VALUES ('" + user.getName() + "', '" + user.getSurname() + "', '" + user.getMail() + "', '" + user.getPhone() + "', '" + user.getPassword() + "', '" + time + "')");
            }

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            
            return false;
        }
    }
    
    public static int getIDOfMail(String mail) {
        int id = -1;
        
        try {
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("SELECT id FROM users WHERE mail = '" + mail + "' LIMIT 1");
                
                if (resultSet.next()) {
                    id = resultSet.getInt("id");
                }  
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return id;
    }

    public static boolean updateUser(User user) {
        String time = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date(System.currentTimeMillis()));

        try {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate("UPDATE users SET name = '" + user.getName() + "', surname = '" + user.getSurname() + "', mail = '" + user.getMail() + "', phone = '" + user.getPhone() + "', password = '" + user.getPassword() + "', cards = '" + user.getCards().toString() + "' WHERE id = '" + user.getID() + "'");
            }

            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean deleteUser(User user) {
        try {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate("DELETE FROM users WHERE id = '" + user.getID() + "'");
            }

            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean isUserExists(String mail) {
        boolean isExists = false;

        try {
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("SELECT mail FROM users WHERE mail = '" + mail + "'");
                
                isExists = resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isExists;
    }
    
    public static String getPasswordOfMail(String mail) {
        String password = "null";
        
        try {
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("SELECT password FROM users WHERE mail = '" + mail + "'");
                
                if (resultSet.next()) {
                    password = resultSet.getString("password");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return password;
    }
    
    public static User getUserFromMail(String mail) {
        User currentUser = null;
        
        try {
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE mail = '" + mail + "' LIMIT 1");
                
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String surname = resultSet.getString("surname");
                    String phone = resultSet.getString("phone");
                    String userPassword = resultSet.getString("password");
                    String registerTime = resultSet.getString("registerTime");
                                        
                    currentUser = new User(name, surname, mail, phone, userPassword, registerTime);
                    
                    currentUser.setID(id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return currentUser;
    }
    
    public static boolean changeMail(String currentMail, String newMail) {
        try {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate("UPDATE users SET mail = '" + newMail + "' WHERE mail = '" + currentMail + "'");
            }
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean changePhone(String mail, String newPhone) {
        try {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate("UPDATE users SET phone = '" + newPhone + "' WHERE mail = '" + mail + "'");
            }
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean changePassword(String mail, String newPassword) {
        try {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate("UPDATE users SET password = '" + newPassword + "' WHERE mail = '" + mail + "'");
            }
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static Card getCardByCardID(String cardID) {
        Card card = null;
        
        try {
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM cards WHERE cardID = '" + cardID + "' LIMIT 1");
                
                if (resultSet.next()) {
                    int cardOwnerID = resultSet.getInt("cardOwnerID");
                    String cardName = resultSet.getString("cardName");
                    int balance = resultSet.getInt("balance");
                    String createTime = resultSet.getString("createTime");
                    CardType cardType = CardType.valueOf(resultSet.getString("cardType"));
                    
                    card = new Card(cardOwnerID, cardID, cardName, balance, createTime, cardType);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return card;
    }
    
    public static List<Card> getUserCards(int cardOwnerID) {
        List<Card> cards = new ArrayList<>();
        
        try {
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM cards WHERE cardOwnerID = '" + cardOwnerID + "' LIMIT 4");
            
                while (resultSet.next()) {
                    String cardID = resultSet.getString("cardID");
                    String cardName = resultSet.getString("cardName");
                    int balance = resultSet.getInt("balance");
                    String createTime = resultSet.getString("createTime");
                    CardType cardType = CardType.valueOf(resultSet.getString("cardType"));
                    
                    cards.add(new Card(cardOwnerID, cardID, cardName, balance, createTime, cardType));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return cards;
    }
    
    public static boolean createCard(Card card) {
        String time = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date(System.currentTimeMillis()));

        try {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate("INSERT INTO cards (cardID, cardOwnerID, balance, createTime, cardType, cardName) VALUES ('" + card.getCardID() + "', '" + card.getCardOwnerID() + "', '" + card.getBalance() + "', '" + time + "', '" + card.getCardType().name() + "', '" + card.getCardName() + "')");
            }

            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public static boolean updateCard(Card card) {        
        try {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate("UPDATE cards SET cardName = '" + card.getCardName() + "', balance = '" + card.getBalance() + "', cardType = '" + card.getCardType().name() + "' WHERE cardID = '" + card.getCardID() + "'");
            }
            
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public static boolean deleteCard(Card card) {
        try {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate("DELETE FROM cards WHERE cardID = '" + card.getCardID() + "'");
            }

            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
