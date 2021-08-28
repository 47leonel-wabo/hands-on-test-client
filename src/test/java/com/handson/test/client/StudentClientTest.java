package com.handson.test.client;

import com.handson.test.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest
//@AutoConfigureWireMock
@AutoConfigureStubRunner(
        ids = {"com.handson.test:handson-test:+:8080"},
        stubsMode = StubRunnerProperties.StubsMode.LOCAL
)
public class StudentClientTest {

    @Autowired
    private StudentClient mStudentClient;

    @Test
    void getStudentForGivenStudentReturned() {
        // given
        Long dummyId = 1L;
        // Mock the API calls response object
//        stubFor(WireMock
//                .get("/api/student/" + dummyId)
//                .willReturn(WireMock.okJson(
//                        """
//                                {
//                                    "id": 1,
//                                    "username": "assa",
//                                    "grade": 17
//                                }
//                                """
//                ))
//        );

        // when
        Student student = mStudentClient.getStudent(dummyId);

        // then
        then(student.getId()).isNotNull();
        then(student.getName()).isEqualTo("assa");
        then(student.getGrade()).isEqualTo(17);
    }

}
