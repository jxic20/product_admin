/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import net.sf.oval.constraint.*;

/**
 *
 * @author monvi967
 */
public class Customer implements Comparable<Customer>{
    @NotNull(message="Username is mandatory")
    @NotBlank(message="Username is mandatory")
    public String username;
    @NotNull(message="Name is mandatory")
    @NotBlank(message="Name is mandatory")
    @Length(min=2, message="Name must contain at least two characters.")
    public String name;
    @NotBlank(message="Credit card is mandatory")
    @NotNull(message="Credit card is mandatory")
    @Length(min=16, max=16, message="Credit card must contain at least two characters.")
    public Integer credit_card;
    @NotNull(message="Password is mandatory")
    public String password;
    @NotNull(message="Email is mandatory")
    public String email;
    @NotNull(message="Address is mandatory")
    public String address;
    
    
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    

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

    @Override
    public int compareTo(Customer ctr) {
        String a = this.username;
        String b = ctr.getUsername();
        return a.compareTo(b);
    }



 
    
    
}
