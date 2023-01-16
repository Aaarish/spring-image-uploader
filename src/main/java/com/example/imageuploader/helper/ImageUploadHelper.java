package com.example.imageuploader.helper;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Component
public class ImageUploadHelper {
    private final String IMAGES_DIR = "C:\\Users\\dell\\eclipse-workspace\\IntelliJ Projects\\Spring Boot Projects\\spring-image-uploader\\src\\main\\resources\\static\\images";

    public boolean uploadImage(MultipartFile file){
        boolean isUploaded = false;

        try {
            //converting file to byte stream
            InputStream is = file.getInputStream();

            //converting byte stream to array of bytes
            byte[] data = new byte[is.available()];

            //creating a output stream point at a place where we want to upload files
            FileOutputStream os = new FileOutputStream(IMAGES_DIR + "//" + file.getOriginalFilename());

            //uploading files
            os.write(data);

            isUploaded = true;

            os.flush();
            os.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return isUploaded;
    }
}
