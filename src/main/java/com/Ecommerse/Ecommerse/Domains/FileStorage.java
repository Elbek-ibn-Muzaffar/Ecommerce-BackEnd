package com.Ecommerse.Ecommerse.Domains;

import com.Ecommerse.Ecommerse.Domains.Enurmations.FileStorageStatus;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class FileStorage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String fileName;

    private String extension;

    private long fileSize;

    private String uploadPath;

    private String contentType;

    @Enumerated(EnumType.STRING)
    private FileStorageStatus fileStorageStatus;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public FileStorageStatus getFileStorageStatus() {
        return fileStorageStatus;
    }

    public void setFileStorageStatus(FileStorageStatus fileStorageStatus) {
        this.fileStorageStatus = fileStorageStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private String hashId;


}
