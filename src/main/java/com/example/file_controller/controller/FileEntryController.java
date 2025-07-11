package com.example.file_controller.controller;

import com.example.file_controller.service.FileRequest;
import com.example.file_controller.entity.FileEntry;
import com.example.file_controller.service.FileEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/file")
public class FileEntryController {

    @Autowired
    private FileEntryService fileEntryService;

    @PostMapping("/upload")
    public FileEntry upload(@RequestBody FileRequest request) {
        return fileEntryService.upload(request);
    }

    @GetMapping("/find")
    public FileEntry findByPath(@RequestParam String path) {
        return fileEntryService.findByPath(path);
    }

    @GetMapping("/search")
    public List<FileEntry> searchByName(@RequestParam String keyword) {
        return fileEntryService.findByName(keyword);
    }
}

