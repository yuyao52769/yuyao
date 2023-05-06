package demo;

import java.util.HashMap;
import java.util.Map;

public class UserDao {

    public UserDao(){}

    private static Map<String, String> hashMap = new HashMap<String, String>();

    static {
        hashMap.put("10001", "10001");
        hashMap.put("10002", "10002");
        hashMap.put("10003", "10003");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
