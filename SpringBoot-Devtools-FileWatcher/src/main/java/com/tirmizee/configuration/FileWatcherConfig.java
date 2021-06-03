package com.tirmizee.configuration;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.devtools.filewatch.FileSystemWatcher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tirmizee.component.file.TestFileChangeListener;

@Configuration
public class FileWatcherConfig {
	
	@Autowired
	private TestFileChangeListener fileChangeListener;
	
	@Bean
    public FileSystemWatcher fileSystemWatcher() {
        FileSystemWatcher fileSystemWatcher = new FileSystemWatcher();
        fileSystemWatcher.addSourceDirectory(new File("D:\\Directory"));
        fileSystemWatcher.addListener(fileChangeListener);
        fileSystemWatcher.start();
        return fileSystemWatcher;
    }

}
