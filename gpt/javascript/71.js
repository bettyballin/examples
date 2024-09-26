
crypto.pbkdf2(req.body.password, user.salt, 25000, 512, 'sha256', function(err, encodedPassword) {
    // the rest of your code
});

