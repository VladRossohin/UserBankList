package Entity;

public class Account {
    private Long accountId;
    private Long account;
    private Long userId;

    public Account() {
    }

    public Account(Long accountId, Long account, Long userId) {
        this.accountId = accountId;
        this.account = account;
        this.userId = userId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccount() {
        return account;
    }

    public void setAccount(Long account) {
        this.account = account;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
