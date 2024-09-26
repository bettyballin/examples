function checkSecret(secret, guess) {
    for (let i = 0; i < 32; i++) {
        if (secret[i] != guess[i]) return false;
    }
    return true;
}

// Test the function
let secret = Array(32).fill(1);
let guess = Array(32).fill(1);
console.log(checkSecret(secret, guess));  // Expected output: true

let wrongGuess = Array(32).fill(1);
wrongGuess[0] = 0;
console.log(checkSecret(secret, wrongGuess));  // Expected output: false