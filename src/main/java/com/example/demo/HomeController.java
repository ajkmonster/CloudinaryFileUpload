package com.example.demo;


import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    CloudinaryConfig cloudinary;

    @RequestMapping("/")
    public String homePage(Model model) throws IOException {
        model.addAttribute("myvar","Say hello to the people.");

            FileWriter fileWriter = new FileWriter("file.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print("Some String");
            printWriter.printf("Product name is %s and its price is %d $", "iPhone", 1000);
            printWriter.close();
            File f = new File("file.txt");
        Map options = ObjectUtils.asMap(
                "public_id", "file",
                "resource_type", "raw"
        );
        Map uploadResult =
                cloudinary.upload(f, options);
        return "hometemplate";
    }

}
