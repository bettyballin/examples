
const crypto = require('crypto');

var codes = [];
var totalCodes = 100;

function generateRandomBytes(index) {
    crypto.randomBytes(256, function(ex, buf) {
        if (ex) {
            console.error("Error generating random bytes:", ex);
            // Retry after a short
