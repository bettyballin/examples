
function hexStringToUint8Array(hexString) {
    if (hexString.length % 2 !== 0) {
        throw "Invalid hexString";
    }
    var arrayBuffer = new Uint8Array(hexString.length / 2);
    for (var i = 0; i < hexString.length; i += 
