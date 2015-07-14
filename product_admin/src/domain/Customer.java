/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author monvi967
 */
public class Customer {
    public String username;
    public String name;
    public Integer credit_card;
    public String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCredit_card() {
        return credit_card;
    }

    public void setCredit_card(Integer credit_card) {
        this.credit_card = credit_card;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer{" + "username=" + username + ", name=" + name + '}';
    }

 
    
    
}
