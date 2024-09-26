// Node.js doesn't support setting environment variables directly like in shell commands.
// However, you can achieve the same result using the following approach:

process.env.MONGO_DB_USERNAME = 'foo';
process.env.MONGO_DB_PASSWORD = 'bar';