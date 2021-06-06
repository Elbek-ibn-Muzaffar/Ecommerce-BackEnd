package com.Ecommerse.Ecommerse.Converter;

import com.Ecommerse.Ecommerse.Domains.Company;
import com.Ecommerse.Ecommerse.Domains.Komputer;
import com.Ecommerse.Ecommerse.Domains.Protsessor;
import com.Ecommerse.Ecommerse.Domains.Texnika;
import com.Ecommerse.Ecommerse.Dto.CompanyDto;
import com.Ecommerse.Ecommerse.Dto.KomputerDto;
import com.Ecommerse.Ecommerse.Dto.ProtsessorDto;
import com.Ecommerse.Ecommerse.Dto.TexnikaDto;
import org.modelmapper.ModelMapper;

public class Converters {
    ModelMapper mapper=new ModelMapper();

    public Texnika dtoToEntityTexnika(TexnikaDto texnikaDto)
    {
        Texnika texnika=mapper.map(texnikaDto,Texnika.class);
        return texnika;
    }

//    Converter for company

    public Company dtoToEntityCompany(CompanyDto companyDto)
    {
        Company company=mapper.map(companyDto,Company.class);
        return company;
    }

//    Converter for protsessor

    public Protsessor  dtoToEntityProtsessor(ProtsessorDto protsessorDto)
    {
        Protsessor protsessor=mapper.map(protsessorDto,Protsessor.class);
        return protsessor;
    }

//    converter for Komputer

    public Komputer  dtoToEntityKomputer(KomputerDto komputerDto)
    {
        Komputer komputer=mapper.map(komputerDto,Komputer.class);
        return komputer;
    }
}
