package mvcdemo.controller.sampleObj;

import java.util.List;

public class VO {
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "VO{" + "userList=" + userList + '}';
    }

    private List<User> userList;
}
