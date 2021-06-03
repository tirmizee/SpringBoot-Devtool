package com.tirmizee.component.file;

import java.io.File;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.devtools.filewatch.ChangedFile;
import org.springframework.boot.devtools.filewatch.ChangedFiles;
import org.springframework.boot.devtools.filewatch.FileChangeListener;
import org.springframework.stereotype.Component;

@Component
public class TestFileChangeListener implements FileChangeListener {
	
	public final Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public void onChange(Set<ChangedFiles> changeSet) {
		for (ChangedFiles changedFiles : changeSet) {
			for (ChangedFile changedFile : changedFiles) {
				switch (changedFile.getType()) {
					case ADD: 
						handleFileAdd(changedFile.getFile());
						break;
					case MODIFY:
						handleFileModify(changedFile.getFile());
						break;
					case DELETE: 				
						handleFileDelete(changedFile.getFile());
						break;
					default:
						break;
				}
			}
		}
	}

	private void handleFileDelete(File file) {
		log.debug("handle delete  -> {}", file.getName());
	}

	private void handleFileModify(File file) {
		log.debug("handle file modify -> {}", file.getName());
	}

	private void handleFileAdd(File file) {
		log.debug("handle file add -> {}", file.getName());
	}

}
