private static void readPreferences() {
  InputStream inputStream = new FileInputStream(getPreferencesFile());

  try {
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