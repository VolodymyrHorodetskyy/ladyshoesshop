package ua.com.ladyshoes.service;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URL;

@Service
public class TextService {

    @Value("${resources.path}")
    private String path;

    public String getItemDescription(String language) {
        String urlPath = this.path;
        if (language.equals("ru")) {
            urlPath += "text/rus_itemdescription.txt";
        } else {
            urlPath += "text/itemdescription.txt";
        }

        try {
            File file = new File("description");
            FileUtils.copyURLToFile(new URL(urlPath), file);

            return FileUtils.readFileToString(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
