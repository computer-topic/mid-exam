function hashIt(data) {
  let hash = 0;
  const length = data.length;

  for (let i = 0; i < length ; i++) {
    const char = data.charCodeAt(i);
    hash = makeHash(hash, char);
    hash = convertTo32BitInteger(hash);
  }
}

function makeHash(hash, char) {
    return (hash << 5) - hash + char;
}

function convertTo32BitInteger(hash) {
    return hash & hash;
}