function hashIt(data) {
  let hash = 0;
  const length = data.length;

  for (let i = 0; i < length ; i++) {
    const char = data.charCodeAt(i);
    hash = makeHash(hash, char);
  }
}

function makeHash(hash, char) {
    hash = (hash << 5) - hash + char;
    return convertTo32BitInteger(hash);
}

function convertTo32BitInteger(hash) {
    return hash & hash;
}