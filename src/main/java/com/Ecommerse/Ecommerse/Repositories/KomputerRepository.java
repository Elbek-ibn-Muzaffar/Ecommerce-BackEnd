package com.Ecommerse.Ecommerse.Repositories;

import com.Ecommerse.Ecommerse.Domains.Komputer;
import com.Ecommerse.Ecommerse.Dto.AdminKompTmplate;
import com.Ecommerse.Ecommerse.Dto.KompTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.List;

@Repository
public interface KomputerRepository extends JpaRepository<Komputer,Long> {
    @Query(value = "select * from komputer k where k.komp_name= :name",nativeQuery = true)
    List<Komputer> getInformationByName(@Param("name") String name);

    @Modifying
    @Query("select new com.Ecommerse.Ecommerse.Dto.KompTemplate(k.kompName,k.cost,p.protName,c.compName,t.texName,f.fileName,f.uploadPath) from Komputer k " +
            "inner join k.protsessor p " +
            "inner join k.company c " +
            "inner join k.texnika t " +
            "inner join k.fileStorage f " +
            "where t.id=1")
    List<KompTemplate> getAllProduct();

    @Modifying
    @Query("select new com.Ecommerse.Ecommerse.Dto.KompTemplate(k.kompName,k.cost,p.protName,c.compName,t.texName,f.fileName,f.uploadPath) from Komputer k " +
            "inner join k.protsessor p " +
            "inner join k.company c " +
            "inner join k.texnika t " +
            "inner join k.fileStorage f " +
            "where t.id=2")
    List<KompTemplate>getAllProductNote();

    @Modifying
    @Query("select new com.Ecommerse.Ecommerse.Dto.AdminKompTmplate(k.id,k.kompName,k.cost,p.id,p.protName,c.id,t.id,f.id,f.hashId) from Komputer k " +
            "inner join k.protsessor p " +
            "inner join k.company c " +
            "inner join k.texnika t " +
            "inner join k.fileStorage f " +
            "where t.id=2")
    List<AdminKompTmplate> getAllNoteAdmin();

    @Modifying
    @Query("select new com.Ecommerse.Ecommerse.Dto.AdminKompTmplate(k.id,k.kompName,k.cost,p.id,p.protName,c.id,t.id,f.id,f.hashId) from Komputer k " +
            "inner join k.protsessor p " +
            "inner join k.company c " +
            "inner join k.texnika t " +
            "inner join k.fileStorage f " +
            "where t.id=1")
    List<AdminKompTmplate> getAllDesctopAdmin();
}
