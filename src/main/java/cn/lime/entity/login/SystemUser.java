package cn.lime.entity.login;

/**
 * 管理员用户实体类
 */
public class SystemUser {
    private String id;

    private String username;

    private String password;

    private String locked;

    /**
     * 验证码添加项,非管理员必须属性
     */
    private String randomcode;

    public String getRandomcode()
    {
        return randomcode;
    }

    public void setRandomcode(String randomcode)
    {
        this.randomcode = randomcode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked == null ? null : locked.trim();
    }
}