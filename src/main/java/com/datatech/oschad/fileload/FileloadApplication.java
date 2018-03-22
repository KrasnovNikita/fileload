package com.datatech.oschad.fileload;

import com.datatech.oschad.fileload.service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FileloadApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileloadApplication.class, args);
	}


    /**
     * deletes and re-creates folder (to which files are stored) at startup
     * @param storageService
     * @return CommandLineRunner
     */
    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }
}
