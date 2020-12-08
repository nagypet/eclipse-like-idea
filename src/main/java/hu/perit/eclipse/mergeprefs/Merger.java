package hu.perit.eclipse.mergeprefs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map.Entry;
import java.util.Properties;

import hu.perit.spvitamin.core.StackTracer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class Merger {

	private final File sourceFolder;
	private final File targetFolder;

	public void merge() {
		log.debug(String.format("'%s' => '%s'", this.sourceFolder.getAbsolutePath(), this.targetFolder.getAbsolutePath()));
		
		try {
			Files.walk(new File(this.sourceFolder, ".metadata").toPath())
				.forEach(p -> this.mergeFile(this.sourceFolder.toPath().relativize(p)));
		} catch (Exception ex) {
			log.error(StackTracer.toString(ex));
		}
	}
	
	
	private void mergeFile(Path relativePath) {
		try {
			File sourceFile = new File(this.sourceFolder, relativePath.toString());
			File targetFile = new File(this.targetFolder, relativePath.toString());
			if (sourceFile.isFile() && sourceFile.exists()) {
				if (!targetFile.exists()) {
					log.warn(String.format("'%s' does not exist!", targetFile.getAbsolutePath()));
				} else {
					this.mergeFiles(sourceFile, targetFile);
				}
			}
		} catch (Exception ex) {
			log.error(StackTracer.toString(ex));
		}
	}
	
	
	private void mergeFiles(File sourceFile, File targetFile) throws FileNotFoundException, IOException {
		log.debug(String.format("Processing file '%s'", targetFile.getAbsolutePath()));
		Properties sourceProperties = new Properties();
		sourceProperties.load(new FileInputStream(sourceFile));
		
		Properties targetProperties = new Properties();
		targetProperties.load(new FileInputStream(targetFile));
		
		boolean changed = false;
		for (Entry<Object, Object> sourceEntry : sourceProperties.entrySet()) {
			if (targetProperties.containsKey(sourceEntry.getKey())) {
				if (!targetProperties.get(sourceEntry.getKey()).equals(sourceEntry.getValue())) {
					log.info("Replacing '{}'", sourceEntry.getKey());
					targetProperties.put(sourceEntry.getKey(), sourceEntry.getValue());
					changed = true;
				} else {
					//log.debug("No change '{}'", sourceEntry.getKey());
				}
			} else {
				log.info("Adding '{}'", sourceEntry.getKey());
				targetProperties.put(sourceEntry.getKey(), sourceEntry.getValue());
				changed = true;
			}
		}

		if (changed) {
			log.debug(String.format("Saving file '%s'", targetFile.getAbsolutePath()));
			targetProperties.store(new FileOutputStream(targetFile), "changed by the tool merge-prefs");
		}
	}
}
