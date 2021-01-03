package bean;

public class Administrator {
    private String email;
    private String username;
    private String password;

    public Administrator() {
    }

    public Administrator(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
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

    @Override
    public String toString() {
        return "Administrator{" +
                "邮箱='" + email + '\'' +
                ", 用户名='" + username + '\'' +
                ", 密码='" + password + '\'' +
                '}';
    }
}
