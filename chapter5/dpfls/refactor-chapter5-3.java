private static void readPreferences() {
    private static InputStream inputReader = null;

    try {
        inputReader = new FileInputStream(getPreferencesFile());
        setPreferences(new Properties(getPreferences()));
        getPreferences().load(is);
    } catch (IOException e) {
        closeInputReader()
    }
}

private void closeInputReader() {
    try {
        if (inputReader != null)
        inputReader.close();
    } catch (IOException e1) {
    }
}