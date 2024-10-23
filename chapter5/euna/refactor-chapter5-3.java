private static void readPreferences() {
  try {
    InputStream is = new FileInputStream(getPreferencesFile());
    setPreferences(new Properties(getPreferences()));
    getPreferences().load(is);
  } catch (IOException e) {
    closedInputStream();
  }
}

private void closedInputStream() {
  try {
    InputStream is = new FileInputStream(getPreferencesFile());
    if (is != null) {
      is.close();
    }
  } catch (IOException e) {
  }
}