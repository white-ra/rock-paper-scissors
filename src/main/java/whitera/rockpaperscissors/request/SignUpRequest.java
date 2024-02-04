package whitera.rockpaperscissors.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SignUpRequest {
    @Size(min = 3, max = 20, message = "The username must contain from 5 to 50 characters")
    @NotBlank()
    private String username;

    @Size(min = 5, max = 50, message = "The password must contain from 5 to 50 characters")
    @NotBlank()
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
