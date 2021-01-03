package bean;

public class Student {
    private String email;
    private String username;
    private String password;
    private String college;
    private String reward;

    public Student() {
    }

    public Student(String email, String username, String password, String college, String reward) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.college = college;
        this.reward = reward;
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

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    @Override
    public String toString() {
        return "Student{" +
                "邮箱='" + email + '\'' +
                ", 用户名='" + username + '\'' +
                ", 密码='" + password + '\'' +
                ", 学院='" + college + '\'' +
                ", 奖罚情况='" + reward + '\'' +
                '}';
    }
}
