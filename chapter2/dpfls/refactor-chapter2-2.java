private static String replaceZtoPercent(String str) {
    StringBuilder sb = new StringBuilder(str);

    for (int i = 0; i < sb.length(); i++) {
        if (sb.charAt(i) == 'Z') {
            sb.setCharAt(i, '%');
        }
    }
    return sb.toString();
}

str = replaceZtoPercent(str);