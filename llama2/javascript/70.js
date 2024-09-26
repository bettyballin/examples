// Set the expected nonce value (replace with your own value)
const expectedNonce = 'your_nonce_value_here';

function checkNonce(nonce) {
  // Compare the passed nonce value with the expected value
  if (nonce === expectedNonce) {
    return true;
  } else {
    return false;
  }
}

// Test the function
console.log(checkNonce('your_nonce_value_here'));  // Should print: true
console.log(checkNonce('wrong_nonce_value'));  // Should print: false