package com.epam.spring.core.loggers;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {

    private String filename="C:\\123\\123.txt";
    private File file;


    public String getFilename() {
        return filename = "";
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
        this.file = new File(filename);
        if (!file.canWrite())
            throw new IOException("can't get access to file");
    }

    @Override public void logEvent(String msg) {
        try {
                    FileUtils.writeStringToFile(this.file, msg + "\r" + "\n", true);
        } catch (IOException e) {
            throw new RuntimeException("can't write message to file");
        }
    }
}
