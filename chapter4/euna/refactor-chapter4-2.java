function hashIt(data) {
  let hash = 0;
  const length = data.length;

  for (let i = 0; i < length ; i++) {
    const charactorCode = data.charCodeAt(i);

    hash = makeHash(hash, charactorCode);
  }
}

function makeHash(hash, charactorCode) {
  hash = (hash << 5) - hash + charactorCode;
  // Convert to 32-bit integer
  return hash & hash;
}