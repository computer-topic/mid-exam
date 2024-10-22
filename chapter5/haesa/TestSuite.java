public class TestSuite implements Test {
    private Vector<Test> tests = new Vector<Test>(10);
    private String name;

    public TestSuite() {
    }

    public TestSuite(final Class<? extends TestCase> classWithTestCase) {
        ...
    }

    public TestSuite(Class<? extends TestCase> classWithTestCase, String name) {
        ...
    }

    private static String exceptionToString(Throwable isThrowable) {
        ...
    }

    public static Test createTest(Class<?extends TestCase> classWithTestCase, String name) {
        ...
    }

    public static Test warning(final String message) {
        ...
    }
    ...
}