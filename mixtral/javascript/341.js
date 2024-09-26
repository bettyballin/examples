function base64ToUint8Array(base64String) {
  const rawData = atob(base64String);
  return new Uint8Array(rawData.split("").map((char) => char.codePointAt(0)));
}

// Test the function
const base64String = "SGVsbG8gd29ybGQh";
const uint8Array = base64ToUint8Array(base64String);
console.log(uint8Array);