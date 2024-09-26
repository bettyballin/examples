var key = "your_secret_key"; // replace with your secret key
var readout = "";

$('.encrypt').on('click', function() {
    if (init()) {
        console.log("-- encrypt clicked --");
        var ciphertext = CryptoJS.Rabbit.encrypt(readout, key);

        // Convert the WordArray to a string
        var answer = ciphertext.toString();

        $('.readout').val(answer);
    }
});

$('.decrypt').on('click', function() {
    if (init()) {
        console.log("-- decrypt clicked --");

        // Convert the string back to a WordArray
        var ciphertext = CryptoJS.enc.Hex.parse(readout);

        var answer = CryptoJS.Rabbit.decrypt(ciphertext, key).toString();

        $('.readout').val(answer);
    }
});

// assuming you have an init function defined somewhere
function init() {
    // your initialization code here
    return true;
}