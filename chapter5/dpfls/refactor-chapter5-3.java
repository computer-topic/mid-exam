public class PreferencesHandler {
    private static InputStream inputReader = null;

    public static void readPreferences() {
        try {
            inputReader = new FileInputStream(getPreferencesFile());
            setPreferences(new Properties(getPreferences()));
            getPreferences().load(inputReader);
        } catch (IOException e) {
            closeInputReader();
        }
    }

    private static void closeInputReader() {
        try {
            if (inputReader != null) {
                inputReader.close();
            }
        } catch (IOException e1) {
        }
    }
}