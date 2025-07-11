package com.example.file_controller.service;

import com.example.file_controller.entity.FileEntry;

import java.util.List;

public interface FileEntryService {
    FileEntry upload(FileRequest request);
    FileEntry findByPath(String path);
    List<FileEntry> findByName(String keyword);
}