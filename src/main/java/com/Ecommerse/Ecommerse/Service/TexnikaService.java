package com.Ecommerse.Ecommerse.Service;

import com.Ecommerse.Ecommerse.Converter.Converters;
import com.Ecommerse.Ecommerse.Domains.Texnika;
import com.Ecommerse.Ecommerse.Dto.TexnikaDto;
import com.Ecommerse.Ecommerse.Repositories.TexnikaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TexnikaService {
    @Autowired
    TexnikaRepository texnikaRepository;


    Converters converters= new Converters();

    public Texnika saveTexnika(TexnikaDto texnikaDto)
    {
        Texnika texnika=converters.dtoToEntityTexnika(texnikaDto);
        return texnikaRepository.save(texnika);
    }

    public List<Texnika> getAllTexnika()
    {
        return texnikaRepository.findAll();
    }
}
