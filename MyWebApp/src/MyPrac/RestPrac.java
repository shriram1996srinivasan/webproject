package MyPrac;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
//import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class RestPrac {
	@Test(enabled = false)
	public void getExample() {
		// RestAssured.baseURI = "https://reqres.in/api/users/2";
		RestAssured.baseURI = "https://rahulshettyacademy.com/maps/api/place/get/json";
		RequestSpecification httpRequest = RestAssured.given();
		// Response response = httpRequest.request(Method.GET,"/2");
		HashMap<String, String> newmap = new HashMap<>();
		newmap.put("key", "qaclick123");
		newmap.put("place_id", "469fe07ee7de70a0fb795f5106131345");
		httpRequest.queryParams(newmap);
//		httpRequest.log().all();
		Response response = httpRequest.get();
		// response.
//		ValidatableResponse s = response.then().log().all();
		System.out.println(response.then().extract());
//		System.out.println(response.getContentType());
//		System.out.println(response.getBody().asString());
//		System.out.println(response.getStatusLine());
//		System.out.println(response.getStatusCode());
//		System.out.println(response.headers());
//
//		JsonPath jpath = response.jsonPath();
//		System.out.println(response.getBody().asString());
//		HashMap<String, Object> email = jpath.get("data");
//		for (String key : email.keySet()) {
//			System.out.println(key + " : " + email.get(key));
//		}
//		HashMap<String, Object> email1 = jpath.get("support");
//		for (String key : email1.keySet()) {
//			System.out.println(key + " : " + email1.get(key));
//		}

	}

	@SuppressWarnings("unchecked")
	@Test(enabled = true)
	public void postExample() throws IOException {
		RestAssured.baseURI = "https://reqres.in/api/users";
		RequestSpecification httpRequest = RestAssured.given();
		// Response response = httpRequest.request(Method.GET,"/2");
		httpRequest.header("Content-Type", "application/json");
		JSONObject params = new JSONObject();
		params.put("name", "shriram");
		params.put("job", "Test Engineer");
		System.out.println(params.toString());
		File te = new File("src/MyPrac/template.json");
//		String in = FileUtils.readFileToString(te, StandardCharsets.UTF_8);
		String in = String.valueOf(Files.readAllBytes(Paths.get("src/MyPrac/template.json")));
		// httpRequest.body(params.toString());
		System.out.println(in);
		httpRequest.body(in);
//		org.json.JSONObject params1 = new org.json.JSONObject(in);
		Response response = httpRequest.post();
		response.then().log().all();
//		System.out.println(response.getContentType());
//		System.out.println(response.getStatusLine());
//		System.out.println(response.getBody().asString());
//		System.out.println(response.header("Server"));
//		JsonPath jpath = response.jsonPath();
//		System.out.println(response.getBody().asString());
//		HashMap<String, Object> email = jpath.get("$");
//
//		for (String key : email.keySet()) {
//			System.out.println(email.get(key).toString());
//		}
	}

	public static void main(String[] args) {
//		Scanner s = new Scanner(System.in);
//		int i = s.nextInt();
//
//		for (int j = 1; j <= i; j++) {
//			for (int k = 1; k <= j; k++) {
//				System.out.print(j);
//			}
//			System.out.print("\n");
//		}
		
		String s = "{\r\n" + 
				"	\"data\": \"kkk\",\r\n" + 
				"	\"gate\": [\r\n" + 
				"		{\r\n" + 
				"			\"id\": \"123\",\r\n" + 
				"			\"name\": \"abc\"\r\n" + 
				"		}\r\n" + 
				"	]\r\n" + 
				"}";
		
//		org.json.JSONObject jj = new org.json.JSONObject(s);
//		System.out.println(jj.getJSONObject("gata").has("id"));
//		jj.getJSONObject("gata").put("id", "aaa");
		
		JsonPath j = new JsonPath(s);
		System.out.println(j.get("gate.id"));
		
	}
}
