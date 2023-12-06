package backendportafolio.config.s3Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;




@Configuration
public class S3Config {

    @Value("${aws.acces.key.id}")
    private String accesKey;

    @Value("${aws.secrect.key}")
    private String secrectKey;

    @Bean
    public S3Client s3Client(){

        return S3Client.builder()
                .region(Region.US_EAST_2)
                .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(accesKey,secrectKey)))
                .build();

    }

}
