package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	Faker faker;
	User userPayLoad;
	public Logger logger;
	@BeforeClass
	public void setup()
	{
		faker= new Faker();
		userPayLoad= new User();
		userPayLoad.setId(faker.idNumber().hashCode());
		userPayLoad.setUsername(faker.name().username());
		userPayLoad.setFirstName(faker.name().firstName());
		userPayLoad.setLastName(faker.name().lastName());
		userPayLoad.setEmail(faker.internet().emailAddress());
		userPayLoad.setPassword(faker.internet().password(5,10));
		userPayLoad.setPhone(faker.phoneNumber().cellPhone());
		
		//for logs
		logger=LogManager.getLogger(this.getClass());
	}
	
	@Test(priority= 1)
	public void testPostUser()
	{
		logger.info("********Creating user*******");
		Response createUser = UserEndPoints.createUser(userPayLoad);
		createUser.then().log().all();
		Assert.assertEquals(createUser.getStatusCode(),200);
		logger.info("********User Created*******");
	}
	
	@Test(priority= 2)
	public void testGetUserByName()
	{
		logger.info("******** Reading user details*******");
		Response userByName = UserEndPoints.getUserByName(userPayLoad.getUsername());
		userByName.then().log().all();
		Assert.assertEquals(userByName.getStatusCode(),200);
		logger.info("********User details read by username*******");
	}

}
