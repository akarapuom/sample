package sample;

import static org.junit.jupiter.api.Assertions.*;

class CommonAPITest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }
// positive scenario
    @org.junit.jupiter.api.Test
    void getValueFromAPI() {
        String url = "https://restcountries.com/v3.1/capital/ma";
     String capitalCity = CommonAPI.getValueFromAPI(url,"capital");
     assertEquals("[\"Panama City\"]",capitalCity, "expected and actual are doesn't match");
    }
    // negative scenario
    @org.junit.jupiter.api.Test
    void getNoValueFromAPI() {
        String url = "https://restcountries.com/v3.1/capital/mkjh";
        String capitalCity = CommonAPI.getValueFromAPI(url,"capital");
        assertEquals("City Not Found",capitalCity);
    }
}