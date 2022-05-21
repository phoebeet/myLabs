import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;


class PodcastViewer {
	public static void main(String[] args) throws Exception {
		httpGetRequest();
	}

	public static void httpGetRequest() throws URISyntaxException, IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
			.version(HttpClient.Version.HTTP_2)
			.uri(URI.create("https://feeds.npr.org/510282/podcast.xml"))
			.headers("Accept-Enconding", "gzip, deflate")
			.build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		
		String responseBody = response.body();
		int responseStatusCode = response.statusCode();
		
		System.out.println("httpGetRequest: " + responseBody);
		System.out.println("httpGetRequest status code: " + responseStatusCode);
	}
}
