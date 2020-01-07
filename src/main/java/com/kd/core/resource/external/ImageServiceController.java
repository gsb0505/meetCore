package com.kd.core.resource.external;

import com.kd.core.enumerate.PathTypeEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/** 图片上传Controller
 * @author: latham
 * @Date: 2019/12/29 18:28
 **/

@CrossOrigin(origins = {"http://127.0.0.1:8081", "null"})
@RequestMapping
@Controller
public class ImageServiceController {
    private final String reusltFail = "fail";

    @PostMapping("uploadImage.do")
    public String imageUpload(@RequestParam(value = "type") PathTypeEnum pathTypeEnum,
            @RequestParam(value = "photoFile", required = false) MultipartFile photoFile,
                              HttpServletRequest request){
        if(pathTypeEnum == null){
            return reusltFail;
        }
        String prefix = pathTypeEnum.getPath();

        try {
            String path = savePhoto(photoFile, request,prefix);
            if(path == null){
                return reusltFail;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reusltFail;
    }

    //保存头像图片
    protected String savePhoto(MultipartFile photoUrl, HttpServletRequest request, String prefix) throws IOException {
        //保存头像图片
        if (photoUrl != null && photoUrl.getSize() > 0 && photoUrl.getName() != null) {
            String name = photoUrl.getOriginalFilename();
            String subffix = name.substring(name.lastIndexOf("."), name.length());
            String filePath = UUID.randomUUID().toString() + subffix;
            String path = request.getSession().getServletContext().getRealPath(prefix);

            File mark = new File(path);
            if(!mark.exists()){
                mark.mkdir();
            }
            File localFile = new File(path + filePath);
            photoUrl.transferTo(localFile);
            return prefix + filePath;
        }
        return null;
    }

}
