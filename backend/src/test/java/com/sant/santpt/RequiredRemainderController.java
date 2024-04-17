package com.sant.santpt;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RequiredRemainderController {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGetGivenNoXParamThenShouldThrowErr() {
        Assertions.assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/required_remainder", String.class)).contains("Required parameter 'x' is not present.");
    }

    @Test
    void testGetGivenNoYParamThenShouldThrowErr() {
        Assertions.assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/required_remainder?x=1", String.class))
                  .contains("Required parameter 'y' is not present.");
    }

    @Test
    void testGetGivenNoNParamThenShouldThrowErr() {
        Assertions.assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/required_remainder?x=1&y=0", String.class))
                  .contains("Required parameter 'n' is not present.");
    }

    @Test
    void testGetGivenNoAllParamThenShouldCalculateBasicCase() {
        Assertions.assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/required_remainder?x=7&y=5&n=12345", String.class))
                  .contains("{\"x\":7,\"y\":5,\"n\":12345,\"result\":12339}");
    }

    @Test
    void testGetGivenInvalidNumsThenShouldThrowErr() {
        Assertions.assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/required_remainder?x=7.5&y=5.5&n=abcd", String.class)).contains("Failed to convert");
    }

    @Test
    void testGetGivenBigNumsThenShouldCompute() {
        Assertions.assertThat(
                          this.restTemplate.getForObject("http://localhost:" + port + "/required_remainder?x=187463728192938475869192&y=20&n=987463728192938475869192", String.class))
                  .contains("{\"x\":187463728192938475869192,\"y\":20,\"n\":987463728192938475869192,\"result\":937318640964692379345980}");
    }

    @Test
    void testGetGivenNegativeNumsThenShouldThrowErr() {
        Assertions.assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/required_remainder?x=-1&y=20&n=987463728192938475869192", String.class))
                  .contains("x, y and n must be positive.");
    }
}
