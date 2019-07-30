package org.senolab.openapijavasample;

import com.akamai.edgegrid.signer.ClientCredential;
import com.akamai.edgegrid.signer.exceptions.RequestSigningException;
import com.akamai.edgegrid.signer.googlehttpclient.GoogleHttpClientEdgeGridRequestSigner;
import com.google.api.client.http.*;
import com.google.api.client.http.apache.ApacheHttpTransport;
import org.apache.http.conn.ssl.SSLSocketFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;

public class Main {
    private static String clientToken = "<client_token>";
    private static String accessToken = "<access_token>";
    private static String clientSecret = "<client_secret>";
    private static String host = "<host>";
    private static String path = "/diagnostic-tools/v2/ghost-locations/available";

    public static void main(String[] args) {
        ClientCredential credential = ClientCredential.builder()
                .accessToken(accessToken)
                .clientToken(clientToken)
                .clientSecret(clientSecret)
                .host(host)
                .build();

        try {
            HttpTransport httpTransport = new ApacheHttpTransport.Builder()
                    .setSocketFactory(SSLSocketFactory.getSocketFactory())
                    .build();
            StringBuilder sb = new StringBuilder("https://");
            sb.append(host);
            sb.append(path);
            HttpRequestFactory requestFactory = httpTransport.createRequestFactory();
            URI uri = URI.create(sb.toString());
            HttpRequest request = requestFactory.buildGetRequest(new GenericUrl(uri));
            HttpResponse response = null;
            GoogleHttpClientEdgeGridRequestSigner requestSigner = new GoogleHttpClientEdgeGridRequestSigner(credential);
            requestSigner.sign(request);
            System.out.println("Making HTTP call to: "+sb.toString());
            System.out.println("HTTP Request headers: \n"+request.getHeaders());
            response = request.execute();
            System.out.println("HTTP Status Code: "+response.getStatusCode());
            System.out.println("HTTP Response Header: "+response.getHeaders());
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getContent(), "UTF-8"));
            String json = reader.readLine();
            System.out.println("HTTP Response Body: ");
            while (json != null) {
                System.out.println(json);
                json = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (RequestSigningException rse) {
            rse.printStackTrace();
        }

    }
}
