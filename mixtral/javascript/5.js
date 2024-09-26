const express = require('express');
const app = express();
const crypto = require('crypto');
const User = require('./User'); // Assuming you have a User model defined elsewhere
const bodyParser = require('body-parser');

app.use(bodyParser.json());

// creates a new user
app.post('/users', function(req, res) {
    // create new user
    var user = new User();

    crypto.randomBytes(32, function (err, buf) {
        if (err) throw err;

        const salt = buf.toString('hex');

        crypto.pbkdf2(req.body.password, salt, 25000, 512, 'sha512', 
            function (err, encodedPassword) {
                if (err) throw err;

                const hashedPassword = encodedPassword.toString('hex');

                user.salt = salt;
                user.password = hashedPassword;

                // Save the new user
                user.save(function(err) {
                    if (err) {
                        res.status(500).send({ message: 'Error creating user' });
                    } else {
                        res.send({ message: 'User created successfully' });
                    }
                });
            });
    });
});

app.listen(3000, function() {
    console.log('Server listening on port 3000');
});