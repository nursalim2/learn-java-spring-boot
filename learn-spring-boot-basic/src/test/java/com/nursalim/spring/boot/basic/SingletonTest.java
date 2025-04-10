package com.nursalim.spring.boot.basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SingletonTest {
    @Test
    void testDatabase() {
        Database database1 = Database.getInstance();
        Database database2 = Database.getInstance();

        Assertions.assertEquals(database1, database2);
    }
}
