package backendportafolio.integrations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;

@Component
@Slf4j
public class S3DocumentManage {

    private final S3Client s3Client;

    @Autowired
    public S3DocumentManage(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    public void uploadFile(MultipartFile file, String bucketName) throws IOException {
        try {
            log.info("Insert a new file to S3");
            s3Client.putObject(PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(file.getOriginalFilename())
                    .build(), RequestBody.fromBytes(file.getBytes()));

            log.info("Finish add a new file to S3 bucket : {}", bucketName);
        }catch (IOException e){
            throw new IOException(e.getMessage());

        }
    }
}
