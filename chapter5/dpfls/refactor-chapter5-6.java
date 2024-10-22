public class TestSuite implements Test {
    private String fName;
    private Vector<Test> fTests = new Vector<Test>(10);

    static public Test createTest(Class<? extends TestCase> theClass, String name) {
        ...
    }

    public static Test warning(final String message) {
        ...
    }

    private static String exceptionToString(Throwable t) {
        ...
    }

    public TestSuite() {
    }

    public TestSuite(final Class<? extends TestCase> theClass) {
        ...
    }

    public TestSuite(Class<? extends TestCase> theClass, String name) {
        ...
    }
    ...
}