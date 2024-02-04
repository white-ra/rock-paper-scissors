package whitera.rockpaperscissors.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HealthCheckerController {
    @GetMapping(value = "/health-check")
    public void healthCheck() {

    }
}
