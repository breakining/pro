package com.ghw.system.controller;

import com.ghw.base.core.domain.ResultBean;
import com.ghw.system.properties.FtpProperties;
import com.ghw.system.util.FtpUtil;
import com.ghw.system.util.FileUploadUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @description: ???
 * @author: ghwei
 * @version: 1.0 2020/9/11 15:46
 */
@RestController
@Api("文件上传")
public class FileUploadController {

    @Autowired
    private FtpProperties ftpProperties;

    @PostMapping("/ftpUploadFiles")
    @ApiOperation(value = "ftp上传文件", notes = "ftp上传文件")
    public ResultBean uploadFiles(MultipartFile file) {
        try {
            String oldName = file.getOriginalFilename();
            //通过工具类产生新图片名称，防止重名
            String picNewName = FileUploadUtils.generateRandonFileName(oldName);
            //通过工具类把图片目录分级
            String picSavePath = FileUploadUtils.generateRandomDir(picNewName);
            //上传到图片服务器的操作
            String str = FtpUtil.pictureUploadByConfig(ftpProperties, picNewName, picSavePath, file.getInputStream());
            //设置图片的url--》就是存储到数据库的字符串url
            return ResultBean.ok("").setResultObject(str);
        } catch (IOException e) {
            return ResultBean.error("网络异常");
        }
    }
}