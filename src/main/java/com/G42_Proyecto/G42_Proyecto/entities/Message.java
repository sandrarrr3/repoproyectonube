package com.G42_Proyecto.G42_Proyecto.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "message")
public class Message {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;
   
    
    @ManyToOne
    @JoinColumn(name ="cloudId")
    @JsonIgnoreProperties("message")
    private Product cloud;
    
    /*producto
    @ManyToOne
    @JoinColumn(name ="categoryId")
    @JsonIgnoreProperties("cloud")
    private Category category;
    */

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Product getCloud() {
        return cloud;
    }

    public void setClouds(Product cloud) {
        this.cloud = cloud;
    }

    

 
    
    
}
