package com.Ecommerse.Ecommerse.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
    public class AdminKompTmplate {

    private long id;



    private String kompName;

    private BigDecimal cost;

    private long protId;

    private String protName;



    private long compId;

    private long texId;

    private long fileId;

    private String hashId;

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
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

    public long getProtId() {
        return protId;
    }

    public void setProtId(long protId) {
        this.protId = protId;
    }

    public long getCompId() {
        return compId;
    }

    public void setCompId(long compId) {
        this.compId = compId;
    }

    public long getTexId() {
        return texId;
    }

    public void setTexId(long texId) {
        this.texId = texId;
    }

    public long getFileId() {
        return fileId;
    }

    public void setFileId(long fileId) {
        this.fileId = fileId;
    }

    public String getProtName() {
        return protName;
    }

    public void setProtName(String protName) {
        this.protName = protName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
