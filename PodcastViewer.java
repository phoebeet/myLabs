import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

class PodcastViewer {
	static String xmlBody;
	static ArrayList<String> titles;
	static ArrayList<String> summaries;

	public static void main(String[] args) throws Exception {
		titles = new ArrayList<String>();
		summaries = new ArrayList<String>();
		httpGetRequest();
		parseXml();

		for (int i = 0; i < titles.size(); i++)
			System.out.println((i + 1) + ") " + titles.get(i));

		System.out.println("What would you like to know more about?");
		Scanner in = new Scanner(System.in);
		int num = 1;
		while (num !=0) {
			num = in.nextInt();
			if (num > 0 && num <= summaries.size())
				System.out.println(summaries.get(num - 1));
			else if (num > summaries.size())
				System.out.println("number out of range");
		}
	}

	public static void parseXml() {
		String line;
		int beginPos, endPos;
		int i = 0;
		boolean bStart = false;

		Scanner scanner = new Scanner(xmlBody);
		while (scanner.hasNextLine() && i < 5) {
			line = scanner.nextLine();
			if (bStart) {
				beginPos = line.indexOf("</item>");
				if (beginPos != -1) {
					bStart = false;
					continue;
				}
				beginPos = line.indexOf("<title>");
				if (beginPos != -1) {
					String t = line.substring(beginPos);
					t = t.replace("<title>", "");
					endPos = t.indexOf("</title>");
					if (endPos == -1)
						continue;
					titles.add(t.substring(0, endPos));
					continue;
				} else {
					beginPos = line.indexOf("<description>");
					if (beginPos != -1) {
						String s = line.substring(beginPos);
						s = s.replace("<description>", "");
						endPos = s.indexOf("</description>");
						if (endPos == -1)
							continue;
						summaries.add(s.substring(0, endPos));
						i++;
						continue;
					} else
						continue;
				}
			}
			beginPos = line.indexOf("<item>");
			if (beginPos != -1) {
				bStart = true;
				continue;
			}
		}
		System.out.println("titles:" + titles.size() + ", summaries:" + summaries.size());
	}

	public static void httpGetRequest() throws URISyntaxException, IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
			.version(HttpClient.Version.HTTP_2)
			.uri(URI.create("https://feeds.npr.org/510282/podcast.xml"))
			.headers("Accept-Enconding", "gzip, deflate")
			.build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		
		xmlBody = response.body();

		System.out.println("httpGetRequest status code: " + response.statusCode());
	}
}
