var key, readout;

$('.encrypt').on('click', function(){
    if  (init()) {
        console.log('-- encrypt clicked --');
        console.log('key = ', key);
        console.log('readout = ', readout);

        // Convert the input string to a WordArray object before encryption.
        var wordArrayReadout = CryptoJS.enc.Utf8.parse(readout);

        // Encrypt and convert the result back into a string for display.
        var answer = CryptoJS.Rabbit.encrypt(wordArrayReadout, key).toString();
        console.log('answer = ', answer);
        $('.readout').val(answer);
    }
});

$('.decrypt').on('click', function(){
    if  (init()) {
        console.log('-- decrypt clicked --');
        console.log('key = ', key);
        console.log('readout = ', readout);

        // Parse the encrypted string back into a WordArray object before decryption.
        var wordArrayEncryptedReadout = CryptoJS.enc.Hex.parse(readout);

        // Decrypt and convert the result to a string for display.
        var answer = CryptoJS.Rabbit.decrypt(wordArrayEncryptedReadout, key).toString(CryptoJS.enc.Utf8);
        console.log('answer = ', answer);
        $('.readout').val(answer);
    }
});

function init(){
    key = '' + $('.key').val();
    readout = '' + $('.readout').val();
    return key && readout;
}