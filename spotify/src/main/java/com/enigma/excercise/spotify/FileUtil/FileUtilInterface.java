package com.enigma.excercise.spotify.FileUtil;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileUtilInterface {
    public String store(MultipartFile file, String destination) throws IOException;
    public Resource read(String filename) throws FileNotFoundException;
}
