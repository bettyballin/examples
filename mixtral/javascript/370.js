function getSalts(length) {
    var result = [];

    for (var i=0; i<length; ++i){
        // Generate random number between 1 and 65535
        let rndNum = Math.floor((Math.random() * 256));

        // Convert to hexadecimal
        result[i] = ("0" + (rndNum & 0xFF).toString(16)).slice(-2);
    }

    return result;
}

var salt32Bytes = getSalts(32).join("");
console.log(salt32Bytes);