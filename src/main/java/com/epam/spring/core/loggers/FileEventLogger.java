package com.epam.spring.core.loggers;

import com.epam.spring.core.beans.Event;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileEventLogger implements EventLogger {

    private String filename;
    private String directory;
    private File file;

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }


    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void init() throws IOException {
        checkDirectory();
        checkFile();
    }

    private void checkFile() throws IOException {
        file = new File(directory + filename);
        if (!file.exists())
            file.createNewFile();
        if (!file.canWrite()) {
            throw new IOException("can't get access to file");
        }
    }

    private void checkDirectory() throws IOException {
        File directoryFile = new File(directory);
        if (!directoryFile.exists()) {
            if (!directoryFile.mkdir()) {
                throw new IOException("can't create directory");
            }
        }
    }

    @Override public void logEvent(Event msg) {
        try {
            FileUtils.writeStringToFile(this.file, new Date() + " - " + msg + "\r" + "\n", true);
        } catch (IOException e) {
            throw new RuntimeException("can't write message to file");
        }
    }
}
