package Entity;

public class User {
    private Long userId;
    private String name;
    private String surName;

    public User() {
    }

    public User(Long userId, String name, String surName) {
        this.userId = userId;
        this.name = name;
        this.surName = surName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }
}
