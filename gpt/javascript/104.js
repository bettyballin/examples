
$('.encrypt').on('click', function(){
    if (init()) {
        console.log('-- encrypt clicked --');
        console.log('key = ', key);
        console.log('readout = ', readout);
        var encrypted = CryptoJS.Rabbit.encrypt(readout, key);
        var answer = encrypted.toString(); // This is already a string (Base64)
        console.log('answer = ',answer);
        $('.readout').val(answer);
    }
});

$('.decrypt').on('click', function(){
    if (init()) {
        console.log('-- decrypt clicked --');
        console.log('key = ', key);
        console.log('readout = ', readout);
        var decrypted = CryptoJS.Rabbit.decrypt(readout, key);
        var answer = decrypted.toString(CryptoJS
