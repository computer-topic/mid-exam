public class Assert {
    static public void assertTrue(String message, boolean condition) {
        if (!condition) fail(message);
    }

    static public void assertTrue(boolean condition) {
        assertTrue(null, condition);
    }

    static public void assertFalse(String message, boolean condition) {
        assertTrue(message, !condition);
    }

    static public void assertFalse(boolean condition) {
        assertFalse(null, condition);
    }
    ...
}

// 교재 내용: 비슷한 기능을 하는 함수는 한 곳에 모아두는 것이 가독성에 좋다 응집성을 높이자