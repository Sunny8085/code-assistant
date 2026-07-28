package com.sunny.code_assistant.workspace;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ZipExtractor {
	
    public Path extract(MultipartFile zipFile) throws IOException {
        Path workspace = Files.createTempDirectory("workspace");
		String proDir = unzip(zipFile.getInputStream(), workspace);
		return workspace.resolve(proDir);
    }
	
    private String unzip(InputStream inputStream, Path targetDir) throws IOException {
		try (ZipInputStream zis = new ZipInputStream(inputStream)) {
			 ZipEntry entry;
			 String proDir = zis.getNextEntry().getName().toString();
			 while ((entry = zis.getNextEntry()) != null) {
			     Path file = targetDir.resolve(entry.getName());
			     if (entry.isDirectory()) {
			         Files.createDirectories(file);
			     } else {
			         Files.createDirectories(file.getParent());
			         Files.copy(zis, file, StandardCopyOption.REPLACE_EXISTING );
			     }
			     zis.closeEntry();
			 }
			 return proDir;
		}
	}
    
}
