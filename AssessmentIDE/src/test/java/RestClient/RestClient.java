package RestClient;


import Utilitis.ApplicationSpecific;

import com.google.gson.JsonObject;
import org.apache.http.client.ClientProtocolException;

import org.apache.http.client.methods.CloseableHttpResponse;

import org.apache.http.client.methods.HttpGet;

import org.apache.http.impl.client.CloseableHttpClient;

import org.apache.http.impl.client.HttpClients;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;


public class RestClient {
    private WebDriver driver;
    private int statusCode;
    ApplicationSpecific AppSp = new ApplicationSpecific(driver);


    public int get(String url) throws ClientProtocolException, IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet httpget = new HttpGet(url);

        CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpget);

        statusCode = closeableHttpResponse.getStatusLine().getStatusCode();

       //  String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");

       //  JsonObject responseJson = new JsonObject(responseString);

        return statusCode;

//Assert.assertEquals("200",statusCode);


    }

   /* public void validateResponse(){
        Assert.assertEquals(200, statusCode);
    }*/
}