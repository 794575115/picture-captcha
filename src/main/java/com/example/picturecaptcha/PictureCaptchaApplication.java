package com.example.picturecaptcha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.example.picturecaptcha")
public class PictureCaptchaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PictureCaptchaApplication.class, args);
    }

}
