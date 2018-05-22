package com.graduate.bsms.controller;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.graduate.bsms.pojo.Result;
import com.graduate.bsms.util.UUIDFactory;

@Controller
@RequestMapping("upload")
public class UploadControler {

    @RequestMapping("index")
    public String index(Model model) {
        System.out.println("diaoyong index");
        return "upload/index";
    }

    @RequestMapping(value = "uploadImage", method = RequestMethod.POST)
    public @ResponseBody
    Result uploadImage(Model model,
                       @RequestParam("file") MultipartFile file) {
        String file1name = uploadFile(file);
        System.out.println(file1name);
        return new Result(200, file1name);
    }

    public String uploadFile(MultipartFile file) {
        String path = null;
        String type = file.getContentType().replace('/', '.');
        if (!file.equals(null) && !file.isEmpty()) {
            CommonsMultipartFile file2 = (CommonsMultipartFile) file;
            DiskFileItem fi = (DiskFileItem) file2.getFileItem();
            File file3 = fi.getStoreLocation();
            String name = UUIDFactory.getUUID();
            path = "E:\\programs\\apacher server\\htdocs\\bsms-Image\\book\\" + name + type;
            file3.renameTo(new File(path));
            return name + type;
        }
        return null;
    }
}