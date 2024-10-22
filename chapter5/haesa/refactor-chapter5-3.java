private static void readPreferences() {
  try {
    InputStream inputStream = new FileInputStream(getPreferencesFile());
    setPreferences(new Properties(getPreferences()));
    getPreferences().load(inputStream);
  } catch (IOException e) {
    closeInputStream();
  }
}

private static void closeInputStream() {
  try {
    InputStream inputStream = new FileInputStream(getPreferencesFile());
    if (inputStream != null)
      inputStream.close();
  } catch (IOException e) {
  }
}