private static void readPreferences() {
  InputStream inputStream = null;

  try {
    inputStream = new FileInputStream(getPreferencesFile());
    setPreferences(new Properties(getPreferences()));
    getPreferences().load(inputStream);
  } catch (IOException e) {
    closeInputStream(inputStream);
  }
}

private static void closeInputStream(InputStream inputStream) {
  try {
    if (inputStream != null)
      inputStream.close();
  } catch (IOException e) {
  }
}