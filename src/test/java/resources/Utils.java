package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {

	static RequestSpecification req;

	public RequestSpecification requestSpecification() throws IOException {
		if (req==null) {
			PrintStream ps = new PrintStream(new FileOutputStream("logging.txt"));
			req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).setContentType(ContentType.JSON)
					.addQueryParam("key", getGlobalValue("key")).addFilter(RequestLoggingFilter.logRequestTo(ps)).addFilter(ResponseLoggingFilter.logResponseTo(ps)).log(LogDetail.ALL).build();
			return req;
		}
		return req;
}
	
	public static String getGlobalValue(String key) throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream("D:\\web-services\\apiframework\\src\\test\\java\\resources\\global.properties"));
		System.out.println(prop.getProperty(key).trim());
		return prop.getProperty(key).trim();
	}
}
