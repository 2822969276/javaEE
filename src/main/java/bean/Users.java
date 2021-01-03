package bean;

public class Users {
    private String email;
    private String username;
    private String password;
    private String identity;

    public Users() {
    }

    public Users(String email, String username, String password, String identity) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.identity = identity;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    @Override
    public String toString() {
        return "user{" +
                "邮箱='" + email + '\'' +
                ", 用户名='" + username + '\'' +
                ", 密码='" + password + '\'' +
                ", 身份='" + identity + '\'' +
                '}';
    }
}
