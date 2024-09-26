
function trimNonAscii(str) {
  return str.replace(/[^\x20-\x7E]+/g, '');
}

