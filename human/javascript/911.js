const admin = require('firebase-admin');
const express = require('express');
const cookieParser = require('cookie-parser');
const flash = require('connect-flash');

const app = express();

app.use(cookieParser());
app.use(flash());

exports.authenticate = (req, res, next) => {
    const sessionCookie = req.cookies.session || '';
    // Verify the session cookie. In this case an additional check is added to detect
    // if the user's Firebase session was revoked, user deleted/disabled, etc.
    return admin
        .auth()
        .verifySessionCookie(sessionCookie, true /** checkRevoked */)
        .then((decodedClaims) => {
            req.user = decodedClaims;
            next();
        })
        .catch((error) => {
            console.error(error);
            // Session cookie is unavailable or invalid. Force user to login.
            req.flash("message", [{
                status: false,
                message: "Invalid session, please login again!"
            }])
            res.redirect('/user/login');
        });
};