package com.Ecommerse.Ecommerse.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class KompTemplate {
    private String kompName;

    private BigDecimal cost;



    private String protName;

    private String compName;

    private String texName;

    private String fileName;

    private String uploadPath;

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public String getKompName() {
        return kompName;
    }

    public void setKompName(String kompName) {
        this.kompName = kompName;
    }

    public String getProtName() {
        return protName;
    }

    public void setProtName(String protName) {
        this.protName = protName;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getTexName() {
        return texName;
    }

    public void setTexName(String texName) {
        this.texName = texName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
