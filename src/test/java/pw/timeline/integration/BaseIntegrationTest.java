package pw.timeline.integration;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

public abstract class BaseIntegrationTest {

    protected static final PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>("postgres:16.1-alpine")
            .withDatabaseName("testdb")
            .withUsername("testuser")
            .withPassword("testpass");

    @DynamicPropertySource
    static void setPostgresProperties(DynamicPropertyRegistry registry) {
        // Set the dynamic properties for the test environment
        registry.add("spring.datasource.url", postgresContainer::getJdbcUrl);
        registry.add("spring.datasource.username", postgresContainer::getUsername);
        registry.add("spring.datasource.password", postgresContainer::getPassword);
    }

    @BeforeAll
    static void startContainers() {
        postgresContainer.start();
        // You can print the JDBC URL for debugging
        // System.out.println("JDBC URL: " + postgresContainer.getJdbcUrl());
    }

}
