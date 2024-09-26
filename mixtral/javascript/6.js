// Authenticate a user
app.post('/login', async function(req, res) {
    User.findOne({ email: req.body.email }, async (err, foundUser) => {
        if (!foundUser) {
            return res.status(401).send({ message: 'User not found' });
        }
        if (err) {
            return res.status(500).send({ message: 'Internal Server Error' });
        }
        // Rest of your authentication logic...
    });
});