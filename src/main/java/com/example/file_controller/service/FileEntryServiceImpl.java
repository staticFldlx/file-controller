package com.example.file_controller.service;

import com.example.file_controller.entity.FileEntry;
import com.example.file_controller.repository.FileEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FileEntryServiceImpl implements FileEntryService {

    @Autowired
    private FileEntryRepository repository;

    @Override
    public FileEntry upload(FileRequest request) {
        FileEntry entry = new FileEntry();
        entry.setName(request.getName());
        entry.setPath(request.getPath());
        entry.setDirectory(request.isDirectory());
        entry.setSize(request.getSize());
        entry.setCreatedAt(LocalDateTime.now());
        entry.setUpdatedAt(LocalDateTime.now());

        try {
            return repository.save(entry);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("文件路径已存在，上传失败: " + request.getPath());
        }
    }

    @Override
    public FileEntry findByPath(String path) {
        return repository.findByPath(path);
    }

    @Override
    public List<FileEntry> findByName(String keyword) {
        return repository.findByNameContaining(keyword);
    }
}
