package bean;

public class Teacher {
    private String email;
    private String username;
    private String password;
    private String college;

    public Teacher() {
    }

    public Teacher(String email, String username, String password, String college) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.college = college;
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

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "邮箱='" + email + '\'' +
                ", 用户名='" + username + '\'' +
                ", 密码='" + password + '\'' +
                ", 学院='" + college + '\'' +
                '}';
    }
}
