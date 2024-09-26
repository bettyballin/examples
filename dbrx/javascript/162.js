function generateRandomString() {
    const array = new Uint32Array(1);
    crypto.getRandomValues(array);

    // Convert the random number into base 36 and remove '0.'
    let randomNumber = array[0].toString(36).substring(2, 15);

    if (randomNumber.length < 13) {
        return generateRandomString();
    }

    return randomNumber;
}

console.log(generateRandomString());