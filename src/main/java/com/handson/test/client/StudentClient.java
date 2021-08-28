package com.handson.test.client;

import com.handson.test.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class StudentClient {

    @Autowired
    private final WebClient mWebClient;

    public Student getStudent(Long dummyId) {
        return mWebClient
                .get()
                .uri("/api/student/{id}", dummyId)
                .retrieve()
                .bodyToMono(Student.class)
                .block();
    }
}
