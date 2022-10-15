package com.G42_Proyecto.G42_Proyecto.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")

public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    private Date startDate;
    private Date devolutionDate;
    private Date created;
    private String status;
    

    @ManyToOne
    @JoinColumn(name ="idCloud")
    @JsonIgnoreProperties("reservations")
    private Product cloud;
    

    @ManyToOne
    @JoinColumn(name ="idClient")
    @JsonIgnoreProperties("reservations")
    private Client client;
    

    
/* 
    @ManyToOne
    @JoinColumn(name ="cloud")
    @JsonIgnoreProperties("reservation")
    private List<Product> products;
*/

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Product getCloud() {
        return cloud;
    }

    public void setCloud(Product cloud) {
        this.cloud = cloud;
    }



}
