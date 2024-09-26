(function() {
    var aes = {encrypt: function(val, key) {
        if (key.indexOf('whatever') !== -1) {
            console.log("Key contains 'whatever'");
        } else {
            console.log("Key does not contain 'whatever'");
        }
    }};

    aes.encrypt("some value", "my key whatever");
})();