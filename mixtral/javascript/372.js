function base64urlDecode(str) {
  str = str.replace(/-/g, '+').replace(/_/g, '/');
  return Uint8Array.from(atob(str), c => c.charCodeAt(0));
}

// Test the function
console.log(base64urlDecode("SGVsbG8gd29ybGQh"));