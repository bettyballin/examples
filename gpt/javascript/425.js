
const admin = require('firebase-admin');
admin.initializeApp();

exports.recursiveDelete = functions
    .runWith({
        timeoutSeconds: 540,
        memory: '2GB'
    })
    .https.onCall(async (data, context) => {
        // authenticate user
        if (!context.auth) {
            throw new functions.https.HttpsError('unauthenticated
