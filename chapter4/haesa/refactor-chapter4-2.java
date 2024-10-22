function hash(data) {
  const length = data.length;
  let hash = 0;

  for (let i = 0; i < length ; i++) {
    const characterCode = data.charCodeAt(i);
    hash = makeHash(hash, characterCode);
    
  }
}

function makeHash(hash, characterCode) {
  const newHash = (hash << 5) - hash + characterCode;
  return convertTo32BitInteger(newHash);
}

function convertTo32BitInteger(hash) {
  return hash & hash;
}