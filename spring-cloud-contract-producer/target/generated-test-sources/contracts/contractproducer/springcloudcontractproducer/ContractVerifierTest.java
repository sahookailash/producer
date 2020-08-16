package contractproducer.springcloudcontractproducer;

import contractproducer.springcloudcontractproducer.ContactproducerApplicationTests;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import io.restassured.module.mockmvc.specification.MockMvcRequestSpecification;
import io.restassured.response.ResponseOptions;

import static org.springframework.cloud.contract.verifier.assertion.SpringCloudContractAssertions.assertThat;
import static org.springframework.cloud.contract.verifier.util.ContractVerifierUtil.*;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

@SuppressWarnings("rawtypes")
public class ContractVerifierTest extends ContactproducerApplicationTests {

	@Test
	public void validate_shouldReturnEvenWhenRequestParamIsEven() throws Exception {
		// given:
			MockMvcRequestSpecification request = given();


		// when:
			ResponseOptions response = given().spec(request)
					.queryParam("number","2")
					.get("/validate/prime-number");

		// then:
			assertThat(response.statusCode()).isEqualTo(200);

		// and:
			String responseBody = response.getBody().asString();
			assertThat(responseBody).isEqualTo("Even");
	}

	@Test
	public void validate_shouldReturnOddWhenRequestParamIsOdd() throws Exception {
		// given:
			MockMvcRequestSpecification request = given();


		// when:
			ResponseOptions response = given().spec(request)
					.queryParam("number","1")
					.get("/validate/prime-number");

		// then:
			assertThat(response.statusCode()).isEqualTo(200);

		// and:
			String responseBody = response.getBody().asString();
			assertThat(responseBody).isEqualTo("Odd");
	}

}
