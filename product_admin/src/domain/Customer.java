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
    public string username;
    public string name;
    public integer credit_card;
    public string password;

    public string getUsername() {
        return username;
    }

    public void setUsername(string username) {
        this.username = username;
    }

    public string getName() {
        return name;
    }

    public void setName(string name) {
        this.name = name;
    }

    public integer getCredit_card() {
        return credit_card;
    }

    public void setCredit_card(integer credit_card) {
        this.credit_card = credit_card;
    }

    public string getPassword() {
        return password;
    }

    public void setPassword(string password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer{" + "username=" + username + ", name=" + name + '}';
    }
    
    
    
    
}
