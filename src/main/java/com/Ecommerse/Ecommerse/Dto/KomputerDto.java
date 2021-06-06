package com.Ecommerse.Ecommerse.Dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class KomputerDto {
    private long id;

    private String kompName;

    private BigDecimal cost;

    private ProtsessorDto protsessorDto;

    private CompanyDto companyDto;

    private TexnikaDto texnikaDto;

    private FileStorageDto fileStorageDto;
}