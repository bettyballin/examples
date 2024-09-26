const express = require('express');
const admin = require('firebase-admin');

admin.initializeApp();

const router = express.Router();

router.post('/sessionLogin', (req, res) => {
    // Get the ID token passed and the CSRF token.
    const idToken = req.body.idToken.toString();
    // const csrfToken = req.body.csrfToken.toString();
    // // Guard against CSRF attacks.
    // if (csrfToken !== req.cookies.csrfToken) {
    //     res.status(401).send('UNAUTHORIZED REQUEST!');
    //     return;
    // }
    // Set session expiration to 5 days.
    const expiresIn = 60 * 60 * 24 * 5 * 1000;
    // Create the session cookie. This will also verify the ID token in the process.
    // The session cookie will have the same claims as the ID token.
    // To only allow session cookie setting on recent sign-in, auth_time in ID token
    // can be checked to ensure user was recently signed in before creating a session cookie.
    const auth = admin.auth();
    auth.verifyIdToken(idToken).then(value => {
        console.log("Token verified")
        return auth.createSessionCookie(idToken, {expiresIn})
            .then((sessionCookie) => {
                // Set cookie policy for session cookie.
                const options = {maxAge: expiresIn, httpOnly: true, secure: true};
                res.cookie('session', sessionCookie, options);
                res.end(JSON.stringify({status: 'success'}));
            }).catch((error) => {
                console.error(error);
                res.status(401).send('UNAUTHORIZED REQUEST!');
            });
    }).catch(reason => {
        console.error("Unable to verify token");
        console.error(reason);
        res.status(401).send('INVALID TOKEN!');
    });
});

const app = express();
app.use(express.json());
app.use(router);
const port = 3000;
app.listen(port, () => {
  console.log(`Server listening on port ${port}`);
});