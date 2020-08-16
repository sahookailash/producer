package contractproducer.springcloudcontractproducer;

import contractproducer.springcloudcontractproducer.controller.EvenOddController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@ExtendWith(SpringExtension.class)
@DirtiesContext
@AutoConfigureMessageVerifier
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ContactproducerApplicationTests {

	@Autowired
	EvenOddController evenOddController;

	@BeforeAll
	public void before() {
		StandaloneMockMvcBuilder standaloneMockMvcBuilder = MockMvcBuilders.standaloneSetup(evenOddController);
		RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
	}
}
