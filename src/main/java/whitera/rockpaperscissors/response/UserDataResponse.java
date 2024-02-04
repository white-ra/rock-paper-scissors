package whitera.rockpaperscissors.response;

public class UserDataResponse {
    private String username;

    public UserDataResponse(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
