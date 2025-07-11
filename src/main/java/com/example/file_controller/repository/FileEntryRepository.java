package com.example.file_controller.repository;

import com.example.file_controller.entity.FileEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FileEntryRepository extends JpaRepository<FileEntry, Long> {
    FileEntry findByPath(String path);
    List<FileEntry> findByPathLike(String path);
    List<FileEntry> findByPathNotLike(String path);
    List<FileEntry> findByPathStartingWith(String path);
    List<FileEntry> findByPathContaining(String path);
    List<FileEntry> findByPathEndingWith(String path);
    List<FileEntry> findByNameContaining(String name);
}
