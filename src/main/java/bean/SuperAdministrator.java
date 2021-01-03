package bean;

public class SuperAdministrator {
    private String email;
    private String username;
    private String password;
    private String phone;

    public SuperAdministrator() {
    }

    public SuperAdministrator(String email, String username, String password, String phone) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "SuperAdministrator{" +
                "邮箱='" + email + '\'' +
                ", 用户名='" + username + '\'' +
                ", 密码='" + password + '\'' +
                ", 电话='" + phone + '\'' +
                '}';
    }
}
