package backendportafolio.integrations.service;


import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class HackerRankApiService {

    private final OkHttpClient httpClient = new OkHttpClient();

    public String getQuestions(String topic, int level, int limit) throws IOException {
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://www.hackerrank.com/api/questions").newBuilder();
        urlBuilder.addQueryParameter("limit", String.valueOf(limit));
        urlBuilder.addQueryParameter("level", String.valueOf(level));
        urlBuilder.addQueryParameter("offset", "0");
        urlBuilder.addQueryParameter("lang", "java");
        urlBuilder.addQueryParameter("include_practice", "true");
        urlBuilder.addQueryParameter("include_contests", "false");
        urlBuilder.addQueryParameter("include_quizzes", "false");
        urlBuilder.addQueryParameter("filter", topic);

        String url = urlBuilder.build().toString();
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            return response.body().string();
        }
    }
}