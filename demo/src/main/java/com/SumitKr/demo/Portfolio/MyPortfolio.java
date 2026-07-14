package com.SumitKr.demo.Portfolio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyPortfolio {

    @GetMapping("/portfolio")
    public String portfolio() {
        return """
        <h1>My Portfolio</h1>

        <h2>Myself</h2>
        <p>Hello! I am Sumit Kumar, a Computer Science student.</p>

        <h2>Skills</h2>
        <ul>
            <li>Java</li>
            <li>Spring Boot</li>
            <li>HTML</li>
            <li>Git & GitHub</li>
        </ul>

        <h2>Education</h2>
        <p>B.Tech in Computer Science and Engineering</p>

        <h2>Projects</h2>
        <ul>
            <li>Hospital Management System</li>
            <li>Myntra Price Prediction</li>
        </ul>
        """;
    }
}