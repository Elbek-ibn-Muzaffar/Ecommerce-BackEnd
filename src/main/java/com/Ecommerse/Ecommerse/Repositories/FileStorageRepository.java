package com.Ecommerse.Ecommerse.Repositories;


import com.Ecommerse.Ecommerse.Domains.FileStorage;
import com.Ecommerse.Ecommerse.Dto.FileStorageTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileStorageRepository extends JpaRepository<FileStorage,Long> {
    @Query("select f from FileStorage f where f.hashId= :hashid")
    FileStorage findByhashid(@Param("hashid") String hashId);

    @Query(value = "select * from file_storage f where f.file_storage_status= :status",nativeQuery = true)
    List<FileStorage> findAllByFileStorageStatus(@Param("status") String status);

//    @Query("select f from FileStorage f where f.fileName= :name")
    List<FileStorage> findByFileName(String name);

    @Query("select new com.Ecommerse.Ecommerse.Dto.FileStorageTemplate(f.id,f.fileName) from FileStorage f")
    List<FileStorageTemplate> getAllIdAndFileName();
}
