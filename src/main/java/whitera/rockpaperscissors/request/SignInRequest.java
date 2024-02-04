package whitera.rockpaperscissors.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description = "Sign in request")
public class SignInRequest {
    @Schema(description = "Username", example = "white-ra")
    @Size(min = 3, max = 20, message = "The username must contain from 5 to 50 characters")
    @NotBlank()
    private String username;

    @Schema(description = "Password", example = "P@s$w0rD")
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
