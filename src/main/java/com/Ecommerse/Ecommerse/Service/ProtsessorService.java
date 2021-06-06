package com.Ecommerse.Ecommerse.Service;

import com.Ecommerse.Ecommerse.Converter.Converters;
import com.Ecommerse.Ecommerse.Domains.Protsessor;
import com.Ecommerse.Ecommerse.Dto.ProtsessorDto;
import com.Ecommerse.Ecommerse.Repositories.ProtsessorRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProtsessorService {
    @Autowired
    ProtsessorRepository protsessorRepository;

    Converters converters=new Converters();

    public Protsessor saveProtsessor(ProtsessorDto protsessorDto)
    {
        Protsessor protsessor=converters.dtoToEntityProtsessor(protsessorDto);
        return protsessorRepository.save(protsessor);
    }

    public List<Protsessor> getAllProtsessor()
    {
        return protsessorRepository.findAll();
    }
}
