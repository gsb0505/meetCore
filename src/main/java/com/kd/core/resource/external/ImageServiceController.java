package com.kd.core.resource.external;

import com.kd.core.dto.MessageDto;
import com.kd.core.enumerate.MessageCodeEnum;
import com.kd.core.enumerate.PathTypeEnum;
import com.kd.core.util.ReturnUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/** 图片上传Controller
 * @author: latham
 * @Date: 2019/12/29 18:28
 **/

//@CrossOrigin(origins = {"http://127.0.0.1:8081", "null"})
@CrossOrigin
@Controller
@RequestMapping
public class ImageServiceController {

    @ResponseBody
    @RequestMapping(value = "/test",method = {RequestMethod.GET,RequestMethod.OPTIONS,RequestMethod.POST})
    public String test(){
        return "test;";
    }

    /**
     * 文件上传
     * @param pathTypeEnum 文件类型
     * @param photoFile  文件对象
     * @param request
     * @return 成功：返回文件webapp下的路径
     */
    @PostMapping("/uploadImage")
    @ResponseBody
    public MessageDto imageUpload(@RequestParam(value = "type", required = false) PathTypeEnum pathTypeEnum,
                                  @RequestParam(value = "photoFile", required = false) MultipartFile photoFile,
                                  HttpServletRequest request){
        if(pathTypeEnum == null){
            return ReturnUtil.returnJson(MessageCodeEnum.ERROR.getCode(),"文件类型不能为空");
        }
        if(photoFile == null || photoFile.isEmpty()){
            return ReturnUtil.returnJson(MessageCodeEnum.ERROR.getCode(),"文件不能为空");
        }
        String prefix = pathTypeEnum.getPath();
        String path = null;
        try {
            path = savePhoto(photoFile, request,prefix);
            if(path == null){
                return ReturnUtil.returnJson(MessageCodeEnum.FAIL.getCode(),"文件上传失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ReturnUtil.returnJson(MessageCodeEnum.SUCCESS.getCode(), path);
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
                mark.mkdirs();
            }
            File localFile = new File(path + filePath);
            photoUrl.transferTo(localFile);
            return prefix + filePath;
        }
        return null;
    }

}
