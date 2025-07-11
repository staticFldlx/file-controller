package com.example.file_controller.service;

import lombok.Data;

@Data
public class FileRequest {
    private String name;
    private String path;
    private boolean isDirectory;
    private Long size;

    public boolean isDirectory() {
        return isDirectory;
    }

    public void setDirectory(boolean isDirectory) {
        this.isDirectory = isDirectory;
    }
}
