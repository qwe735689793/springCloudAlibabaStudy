package com.mhj.demo.util.uuid;

import java.util.UUID;

public class CommonToolkit {
    /**
     * 取得随机产生的UUID
     *
     * @return
     */
    public static String getUuid() {
        UUID uuid = UUID.randomUUID();
        String uuid_s = uuid.toString();
        uuid_s = uuid_s.replace("-", "").toUpperCase();
        return uuid_s;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String uuid = CommonToolkit.getUuid();
            System.out.println(uuid);
        }
    }
}
