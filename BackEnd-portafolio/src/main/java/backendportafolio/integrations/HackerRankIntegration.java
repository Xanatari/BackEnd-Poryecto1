package backendportafolio.integrations;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

public class HackerRankIntegration {

    @PostMapping("/evaluate")
    public String evaluateCode(@RequestBody String code) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.hackerrank.com/api/checker/submission.json";
        String apiKey = "your_api_key_here";
        String language = "java";
        String source = code;
        String testCases = "test case 1\ninput1\nexpected_output1\n" +
                "test case 2\ninput2\nexpected_output2\n";
        String data = "{'source': '"+source+"'," +
                "'lang': '"+language+"'," +
                "'testcases': '"+testCases+"'," +
                "'api_key': '"+apiKey+"'}";
        String response = restTemplate.postForObject(url, data, String.class);
        return response;
    }
}
