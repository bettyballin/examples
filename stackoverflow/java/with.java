// Assuming the existence of a CryptoException class with a getReason method
// and a CryptoException.ILLEGAL_USE constant, the following code would be a
// valid refactoring for successful compilation:

// Import or define the CryptoException class as appropriate for your project

try {
    // . . .
} catch (CryptoException e) {
    if (e.getReason() == CryptoException.ILLEGAL_USE) {
        // SEND CERTAIN APDU
    }
}