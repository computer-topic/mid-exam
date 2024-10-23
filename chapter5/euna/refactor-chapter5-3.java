private static void readPreferences() {
  InputStream is = new FileInputStream(getPreferencesFile());

  try {
    setPreferences(new Properties(getPreferences()));
    getPreferences().load(is);
  } catch (IOException e) {
    closedInputStream();
  }
}

private void closedInputStream(InputStream is) {
  try {
    if (is != null) {
      is.close();
    }
  } catch (IOException e) {
  }
}

// 교재에서는 함수를 짧게하고 모든 지역 변수는 위에 배치하도록 함
// 이에 따라 InputStream을 함수 상단에 위치시키고, closedInputStream에 InputStream을 파라미터로 넘기도록 수정함