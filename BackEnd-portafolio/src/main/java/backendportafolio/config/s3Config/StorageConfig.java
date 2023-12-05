package backendportafolio.config.s3Config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StorageConfig  implements  AWSCredentialsProvider {

    @Value("${aws.region}")
    private String region;

    @Value("${aws.accessKeyId}")
    private String accessKeyId;

    @Value("${aws.secretAccessKey}")
    private String secretAccessKey;

    public StorageConfig(String accessKeyId, String secretAccessKey) {
        this.accessKeyId = accessKeyId;
        this.secretAccessKey = secretAccessKey;
    }

    @Override
    public AWSCredentials getCredentials() {
        return new BasicAWSCredentials(accessKeyId, secretAccessKey);
    }

    @Override
    public void refresh() {

    }


    @Bean
    public AmazonS3 amazonS3() {
        return AmazonS3ClientBuilder.standard()
                .withRegion(region)
                .withCredentials(new StorageConfig(accessKeyId, secretAccessKey))
                .build();
    }
}