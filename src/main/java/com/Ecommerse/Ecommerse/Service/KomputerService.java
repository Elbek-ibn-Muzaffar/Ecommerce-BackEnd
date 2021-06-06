package com.Ecommerse.Ecommerse.Service;

import com.Ecommerse.Ecommerse.Converter.Converters;
import com.Ecommerse.Ecommerse.Domains.Komputer;
import com.Ecommerse.Ecommerse.Dto.AdminKompTmplate;
import com.Ecommerse.Ecommerse.Dto.KompTemplate;
import com.Ecommerse.Ecommerse.Dto.KomputerDto;
import com.Ecommerse.Ecommerse.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KomputerService {
    @Autowired
    KomputerRepository komputerRepository;

    @Autowired
    ProtsessorRepository protsessorRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    TexnikaRepository texnikaRepository;

    @Autowired
    FileStorageRepository fileStorageRepository;

    Converters converters=new Converters();

    public Komputer saveKomputer(KomputerDto komputerDto)
    {
        Komputer komputer=converters.dtoToEntityKomputer(komputerDto);
        return komputerRepository.save(komputer);
    }

    public List<Komputer> getInfoByName(String name)
    {
        return komputerRepository.getInformationByName(name);
    }

    public List<KompTemplate> getAllProduct()
    {
        return komputerRepository.getAllProduct();
    }

    public List<KompTemplate> getAllNotebooks(){ return komputerRepository.getAllProductNote();}

    public List<AdminKompTmplate> getAllNoteAdmin(){return komputerRepository.getAllNoteAdmin();}

    public List<AdminKompTmplate> getAllDesctopAdmin(){return komputerRepository.getAllDesctopAdmin();}

    public void deleteNote(long id)
    {
        komputerRepository.deleteById(id);
    }

    public Komputer updateInformation(AdminKompTmplate adminKompTmplate)
    {
        Komputer komputer=new Komputer();
        komputer.setId(adminKompTmplate.getId());
        komputer.setKompName(adminKompTmplate.getKompName());
        komputer.setCost(adminKompTmplate.getCost());
        komputer.setProtsessor(protsessorRepository.findById(adminKompTmplate.getProtId()));
        komputer.setCompany(companyRepository.findById(adminKompTmplate.getCompId()));
        komputer.setTexnika(texnikaRepository.findById(adminKompTmplate.getTexId()));
        komputer.setFileStorage(fileStorageRepository.findByhashid(adminKompTmplate.getHashId()));

        return komputerRepository.save(komputer);
    }
}
