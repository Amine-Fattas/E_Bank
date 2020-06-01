package com.admin.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Operation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numOperation;
    private Date date;
    private String description;
    private String type;
    private String status;
    @ManyToOne
  //  @JoinColumn(name = "compte_bancaire_rib")
    private CompteBancaire compte;


    public Long getNumOperation() {
        return numOperation;
    }

    public void setNumOperation(Long numOperation) {
        this.numOperation = numOperation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
