package com.RestAssured;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Utility.Library;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;



public class PostRequestCreateUserInGoRest extends Library{
	@Test()
	public void PostRequest() throws FileNotFoundException {	
	FileInputStream objFileInput = new FileInputStream(new String(System.getProperty("user.dir") + "//src//test//resources//PayloadsForRest//CreateUserInGoRest.txt"));
	Response Res= RestAssured
			.given()
			.header("Content-type", "application/json")
			.and()
			.body(objFileInput)
			.when()
			.auth().oauth2(objProp.getProperty("TokenOfGoRestAPI"))
			.post(objProp.getProperty("PostRequestURI"));
	Assert.assertEquals(Res.getStatusCode(), Integer.parseInt(objProp.getProperty("SuccessResponseCodeCreateUser")));
	ResponseBody resBody = Res.getBody();
	String ResponseFromPost_APIcall = resBody.asString();
	System.out.println("ResponseFromPost_APIcall:"+ResponseFromPost_APIcall);
	
	JsonPath jsnPath = Res.jsonPath();
	String Name = jsnPath.get("name");
	String Gender = jsnPath.get("gender");
	System.out.println("Name:"+Name);
	System.out.println("Gender:"+Gender);
	Assert.assertEquals(Name, objProp.getProperty("PostRequestUserNameCreated"), "User not created Successfully with expected name");
	}
	

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("inside beforeMethod");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("inside afterMethod");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("inside beforeClass");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("inside afterClass");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("inside beforeTest");
	//	LaunchBrowser();
	}

	@AfterTest
	public void afterTest() {
		System.out.println("inside afterTest");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("inside beforeSuite");
		try {
			ReadPropertiesFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("inside afterSuite");
	}
	
}
