package com.vr.controller;//package com.vr.controller;
//
//import com.vr.utils.R;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
//import java.util.*;
//
//// FileUploadController.java
//@Slf4j
//@RestController
//@RequestMapping("/api")
//public class FileUploadController {
//
//    private static final Set<String> ALLOWED_TYPES = Set.of("image/jpeg", "image/png");
//    private static final long MAX_SIZE = 5 * 1024 * 1024;
//
//    @Value("${file.upload-dir}")
//    private String uploadDir;
//
//    @PostMapping("/upload")
//    public R uploadFiles(@RequestParam("files") MultipartFile[] files) {
//        log.info("收到上传请求，文件数量：{}", files.length);
//
//        try {
//            List<Map<String, String>> result = new ArrayList<>();
//            Path uploadPath = Paths.get(uploadDir).toAbsolutePath().normalize();
//
//            if (!Files.exists(uploadPath)) {
//                Files.createDirectories(uploadPath);
//            }
//
//            for (MultipartFile file : files) {
//                // 安全验证
//                if (file.isEmpty()) continue;
//                if (!ALLOWED_TYPES.contains(file.getContentType())) {
//                    return R.error("非法文件类型");
//                }
//                if (file.getSize() > MAX_SIZE) {
//                    return R.error("文件大小超过限制");
//                }
//
//                // 生成安全文件名
//                String originalName = StringUtils.cleanPath(file.getOriginalFilename());
//                String extension = originalName.substring(originalName.lastIndexOf("."));
//                String newFilename = UUID.randomUUID() + extension;
//
//                // 存储文件
//                Path targetPath = uploadPath.resolve(newFilename);
//                try (InputStream inputStream = file.getInputStream()) {
//                    Files.copy(inputStream, targetPath, StandardCopyOption.REPLACE_EXISTING);
//                }
//
//                // 记录文件存储成功日志
//                log.info("文件存储成功：{}", newFilename);
//
//                // 返回相对路径
//                result.add(Map.of(
//                        "filePath", "/uploads/" + newFilename,
//                        "originalName", originalName
//                ));
//            }
//            return R.ok().put("data", result);
//        } catch (IOException e) {
//            return R.error("上传失败: " + e.getMessage());
//        } catch (Exception e) {
//            return R.error("系统错误");
//        }
//    }
//}