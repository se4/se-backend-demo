package nju.se4.demo.controller;

import nju.se4.demo.util.LinkUtil;
import nju.se4.demo.util.Response;
import nju.se4.demo.util.innerData.Abilities;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/api/v1/util/")
public class FileUploadController {
    private static String UPLOADED_FOLDER = "";
    //save file
    @RequestMapping(value="upload",method = RequestMethod.POST)
    @ResponseBody
    public Response<String> fileUpload(MultipartFile file){
        String name = "";
        try {
            saveUploadedFiles(Arrays.asList(file));
            Abilities abilities = new Abilities();
            abilities.setUpdate(true);
            String link = LinkUtil.getShareLink();
            return new Response<>(abilities, link);
        } catch (IOException ex) {
            ex.printStackTrace();
            Abilities abilities = new Abilities();
            abilities.setUpdate(false);
            return new Response<>(abilities, "");
        }

    }


    private void saveUploadedFiles(List<MultipartFile> files) throws IOException {
        StringBuilder pathSum = new StringBuilder();
        String fileName = "";
        for (MultipartFile file : files) {

            if (file.isEmpty()) {
                continue; //next pls
            }
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            System.out.println(path);
            Files.write(path, bytes);
            pathSum.append(file.getOriginalFilename());
        }
        System.out.println(pathSum);
        fileName = pathSum.toString();
    }

}
