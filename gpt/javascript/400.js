
function getSalt() {
    var SecureRandom = java.security.SecureRandom;
    var random = new SecureRandom();
    var salt = java.lang.reflect.Array.newInstance(java.lang.Byte.TYPE, 32);
    random.nextBytes(salt);
    
    // Convert Java byte array to JavaScript array
    var saltArray = [];
    for (var i = 0; i < salt.length; i++) {
        // Convert byte to unsigned integer
        saltArray[i] = salt[i] & 0xff;
    }
    return saltArray;
}

