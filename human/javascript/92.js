const express = require('express');
const crypto = require('crypto');
const app = express();

function calculateSignature(key) {
    return function(req, res, next) {
        var hash = req.header("TrialPay-HMAC-MD5"),
            hmac = crypto.createHmac("md5", key);

        req.on("data", function(data) {
            hmac.update(data);
        });

        req.on("end", function() {
            var crypted = hmac.digest("hex");

            if(crypto.timingSafeEqual(
              Buffer.from(crypted),
              Buffer.from(hash.padEnd(crypted.length))
            )) {
                // Valid request
                return res.set("Content-Type", "text/plain").send("Success!");
            } else {
                // Invalid request
                return res.status(403).set("Content-Type", "text/plain").send("Invalid TrialPay hash");
            }
        });

        req.on("error", function(err) {
            return next(err);
        });
    }
}

app.use(express.text());

app.post("/trialpay", calculateSignature("[MY MERCHANT KEY]"));

app.listen(3000, () => {
  console.log('Server listening on port 3000');
});