package whitera.rockpaperscissors.request;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description = "Create game session")
public class CreateGameSessionRequest {
    @Schema(description = "Game name", example = "EDICK SUDAAA")
    @Size(min = 3, max = 20)
    @NotBlank()
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
