package com.bryan.controller;

import com.bryan.domain.Animal;
import com.bryan.domain.GirlProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;


@RestController
@RequestMapping("/api")
public class HelloController {


    private Logger logger= LoggerFactory.getLogger(HelloController.class);

    @Value("${cupSize}")
    private String cupSize;

    @Value("${age}")
    private Integer age;

    @Value("${content}")
    private String content;



    /**
     * 使用@ConfigurationProperties明显优于 @Value
     */
    @Autowired
    private GirlProperties girlProperties;


    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(){
        return  "Hello Spring Boot!";
    }


    @GetMapping("/info")
    //@PostMapping("/info")
    public String info(){
        return  girlProperties.getCupSize();
    }

    @GetMapping("/girl/{id}")
    //    /girl/2
    public String getId(@PathVariable("id") Integer myId){
        return "id:"+myId;
    }

   @RequestMapping("/girl")
   // /girl?id=2&cupSize=E
   //参数名和变量名相同可以不写@RequestParam注解
    public String getGirl(@RequestParam("id") Integer id,@RequestParam(value = "cupSize",required = false) String cupSize){
        return  "id:"+id+";cupSize:"+cupSize;
    }


    @PostMapping("/anim2")
    // 请求体为 text/plain
    public void getAnim(@RequestBody String anim, HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println(req+";"+res);
        res.setContentType("application/json;charset=utf-8");
        res.getWriter().write(anim);
    }


    @PostMapping("/anim3")
    public Animal getAnim2(Animal anim){
        return anim;
    }

    @PostMapping("/requestJson")
    // 请求体为application/json    {"legs":4,"weight":23,"color":"red"}
    public Animal requestJson(@RequestBody Animal anim){
        return anim;
    }

    @PostMapping("/responseJson")
    public Animal responseJson(Animal anim){
        return anim;
    }

    // 多文件上传
    @RequestMapping("/upload")
    public String upload(Animal anim, HttpServletRequest request) throws Exception {

        logger.info(anim.toString());
        MultipartHttpServletRequest ms = (MultipartHttpServletRequest) request;
        //字段名称要为file
        List<MultipartFile> files=ms.getFiles("file");
        for(MultipartFile f:files){
            SimpleDateFormat sf = new SimpleDateFormat(
                    "yyyyMMddHHmmssSSS");
            String fname = sf.format(new Date());
            Random random = new Random();
            fname = fname + random.nextInt(9) + random.nextInt(9)
                    + random.nextInt(9);
            // 获得原始文件名
            String origFileName = f.getOriginalFilename();
            logger.info(origFileName);
            // 获得扩展名
            fname += origFileName.substring(origFileName
                    .lastIndexOf("."));
            String realPath = request.getSession().getServletContext()
                    .getRealPath("/upload/"+fname);
            logger.info(realPath);
            File dest=new File(realPath);
            if(!dest.getParentFile().exists()){
                dest.getParentFile().mkdirs();
            }
            f.transferTo(dest);
        }

        return "upload success";
    }



}
