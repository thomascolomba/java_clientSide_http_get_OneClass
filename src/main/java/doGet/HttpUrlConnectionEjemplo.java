package doGet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUrlConnectionEjemplo {
	private final String USER_AGENT = "Mozilla/5.0";
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		HttpUrlConnectionEjemplo http = new HttpUrlConnectionEjemplo();
//		System.setProperty("http.proxyHost", "alca.proxy.corp.sopra");
//		System.setProperty("http.proxyPort", "8080");
		System.out.println("Testing 1 - Send Http GET request");
		http.sendGet();
		
		//segun Willem eso puede funcionar tmb :
		//  Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("ptx.proxy.corp.sopra", 8080));
        	//  HttpURLConnection connection = (HttpURLConnection) serverAddress.openConnection(proxy);
	}
	
	private void sendGet() throws Exception {

//		String url = "http://www.google.com/search?q=willem";
		String url = "http://localhost:8080/mywebsite/";
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());
		System.out.println("End of response");

	}

}
