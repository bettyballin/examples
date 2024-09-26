function dynamicTruncationFn(hmacValue) {
  const offset = hmacValue.charCodeAt(hmacValue.length - 1) & 0xf;
  return (
    ((hmacValue.charCodeAt(offset) & 0x7f) << 24) |
    ((hmacValue.charCodeAt(offset + 1) & 0xff) << 16) |
    ((hmacValue.charCodeAt(offset + 2) & 0xff) << 8) |
    (hmacValue.charCodeAt(offset + 3) & 0xff)
  );
}

// Call the function with a test value
const hmacValue = "0123456789abcdef";
console.log(dynamicTruncationFn(hmacValue));