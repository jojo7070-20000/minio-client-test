package org.jojo7070.cmd;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;

import org.xmlpull.v1.XmlPullParserException;

import io.minio.MinioClient;
import io.minio.errors.MinioException;


/**
 * https://play.min.io  local-minio.com
 * https://docs.min.io/cn/java-client-quickstart-guide.html
 */
public class FileUploader {

    public static void run() throws NoSuchAlgorithmException, IOException, InvalidKeyException, XmlPullParserException {

        String endpoint = "http://local-minio.com:9002"; // 没有设置加密传输
        String accessKey = "12345678";
        String secretKey = "12345678";

        // 存储buz
        String bucketName = "java-upload";
        String objectName = "test.txt";
        String fileName = "/Users/apple/Desktop/" + objectName;

        try {
            // 使用MinIO服务的URL，端口，Access key和Secret key创建一个MinioClient对象
            MinioClient minioClient = new MinioClient(endpoint, accessKey, secretKey);

            // 检查存储桶是否已经存在
            boolean isExist = minioClient.bucketExists(bucketName);
            if (isExist) {
                System.out.println("Bucket already exists.");
            } else {
                // 创建一个名为 bucketName 的存储桶，用于存储照片的zip文件。
                minioClient.makeBucket(bucketName);
            }

            // 使用putObject上传一个文件到存储桶中。
            minioClient.putObject(bucketName, objectName, fileName);
            System.out.println(fileName + " is successfully uploaded as" + objectName + " to " + bucketName + " bucket.");
        } catch (MinioException e) {
            System.out.println("Error occurred: " + e);
        }
    }
}
