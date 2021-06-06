package com.Ecommerse.Ecommerse.Domains;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Komputer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String kompName;

    private BigDecimal cost;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Protsessor protsessor;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Company company;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Texnika texnika;

    @ManyToOne(cascade = CascadeType.MERGE)
    private FileStorage fileStorage;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKompName() {
        return kompName;
    }

    public void setKompName(String kompName) {
        this.kompName = kompName;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Protsessor getProtsessor() {
        return protsessor;
    }

    public void setProtsessor(Protsessor protsessor) {
        this.protsessor = protsessor;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Texnika getTexnika() {
        return texnika;
    }

    public void setTexnika(Texnika texnika) {
        this.texnika = texnika;
    }

    public FileStorage getFileStorage() {
        return fileStorage;
    }

    public void setFileStorage(FileStorage fileStorage) {
        this.fileStorage = fileStorage;
    }
}
