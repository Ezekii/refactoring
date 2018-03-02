package br.com.dxc.util;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class BatchUtils {

    public static String storeFile(final String prefix, final MultipartFile file) throws IOException {
        String suffix = ".json";
        if (file.getOriginalFilename().endsWith(".zip")) {
            suffix = ".zip";
        } else if (file.getOriginalFilename().endsWith(".tar.gz")) {
            suffix = ".tar.gz";
        } else if (file.getOriginalFilename().endsWith(".gz")) {
            suffix = ".gz";
        }
        final File newFile = File.createTempFile(prefix, suffix);
        file.transferTo(newFile);
        return newFile.getAbsolutePath();
    }

    public static String storeFile(final String prefix, final String data) throws IOException {
        final File newFile = File.createTempFile(prefix, ".json");
        FileUtils.write(newFile, data);
        return newFile.getAbsolutePath();
    }
}
