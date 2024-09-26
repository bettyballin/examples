console.log(isValidFilename("test.txt"));  // true
console.log(isValidFilename("test..txt")); // false
console.log(isValidFilename("test.txt",)); // SyntaxError

function isValidFilename(filename) {
  const regex = /^[a-zA-Z0-9_\\.\\-\\+\\(\\)\\[\\]\\s\\:\\;\\@\\%\\$\\#\\&\\/]+$/;
  return filename && !filename.includes('..') && regex.test(filename);
}