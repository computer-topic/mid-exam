private static void readPreferences() {
    try {
        InputStream is = new FileInputStream(getPreferencesFile());
        setPreferences(new Properties(getPreferences()));
        getPreferences().load(is);
    } catch (IOException e) {
        try {
            InputStream is = new FileInputStream(getPreferencesFile());
            if (is != null)
                is.close();
        } catch (IOException e1) {
        }
    }
}