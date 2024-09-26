
const validators = {
    cookiename_1: validateCookieName1,
    cookiename_2: validateCookieName2,
    // ... add more validators as needed
};

exports.validateCookies = (req, res, next) => {
    const cookieTypes = filterUnknownCookies(Object.keys(req.cookies));
    for (let cookie of cookieTypes) {
        if
