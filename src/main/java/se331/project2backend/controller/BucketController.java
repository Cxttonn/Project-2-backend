//package se331.project2backend.controller;
//
//
//import jakarta.servlet.ServletException;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestPart;
//import org.springframework.web.multipart.MultipartFile;
//import se331.project2backend.util.CloudStorageHelper;
//
//
//import java.io.IOException;
//
//@Controller
//@RequiredArgsConstructor
//public class BucketController {
//    final CloudStorageHelper cloudStorageHelper;
//    @PostMapping("/uploadFile")
//    public ResponseEntity<?> uploadFile(@RequestPart(value = "file")MultipartFile file) throws IOException, ServletException {
//        return ResponseEntity.ok(this.cloudStorageHelper.getImageUrl(file,"imageupload-fc24d.appspot.com"));
//    }
//
//    @PostMapping("/uploadImage")
//    public ResponseEntity<?> uploadFileComponent(@RequestPart(value = "image")MultipartFile file) throws IOException, ServletException {
//        return ResponseEntity.ok(this.cloudStorageHelper.getStorageFileDTO(file,"imageupload-fc24d.appspot.com"));
//    }
//}
