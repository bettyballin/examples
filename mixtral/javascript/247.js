function generateRandomString() {
    const randomBuffer = new Uint32Array(4);
    window.crypto.getRandomValues(randomBuffer);

    let result = '';

    for (let i = 0; i < randomBuffer.length - 1; ++i)
        result += randomBuffer[i].toString(36).substring(2, 9);

    return result + randomBuffer[randomBuffer.length-1].toString(36).slice(-7);
}

console.log(generateRandomString());