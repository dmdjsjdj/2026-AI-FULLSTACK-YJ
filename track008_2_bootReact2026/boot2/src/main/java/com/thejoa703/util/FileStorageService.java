package com.thejoa703.util;

import java.io.IOException;
import java.nio.file.*;
import java.util.UUID; 
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

 
@Service  
public class FileStorageService {
   
    private final Path root = Paths.get("uploads");  

    public String upload(MultipartFile file) {
    	 System.out.println("===== upload 시작 =====");
         System.out.println("저장 위치 : " + root.toAbsolutePath());
         System.out.println("파일명 : " + file.getOriginalFilename());
        try {
            if (!Files.exists(root)) {  
                Files.createDirectories(root);  
            }
            String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();  
            Path target = root.resolve(filename);   
            Files.copy(file.getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);  
            
            System.out.println("저장 위치 = " + target.toAbsolutePath());

            return "uploads/" + filename;   
        } catch (IOException e) {
            throw new RuntimeException("파일 업로드 실패", e);
        }
    }
}
