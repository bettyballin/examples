
const bcrypt = require('bcrypt');
const saltRounds = 10;

async function createUser(username, password) {
    try {
        // Generate a salt and hash the password
        const hashedPassword = await bcrypt.hash(password, saltRounds);

        // Store the hashed password in the MongoDB database
        const user = {
            username: username,
            password: hashedPassword
        };
        // Assuming you have a MongoDB collection named 'users'
        await usersCollection.insertOne(user);
        console.log('
