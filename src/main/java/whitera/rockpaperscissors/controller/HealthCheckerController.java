package whitera.rockpaperscissors.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Tag(name = "Server available")
public class HealthCheckerController {
    @Operation(summary = "Check server available")
    @GetMapping("/health-check")
    public void healthCheck() {

    }
}
