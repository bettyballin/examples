const cookieNames = ['cookiename_1', 'cookiename_2'];

function filterUnknownCookies(cookies) {
    return cookies.filter(cookie => cookieNames.includes(cookie));
}

function validateCookiecookiename_1(cookieValue) {
    // your validation logic for cookiename_1
    return true;
}

function validateCookiecookiename_2(cookieValue) {
    // your validation logic for cookiename_2
    return true;
}

exports.validateCookies = (req, res, next) => {
    const cookieTypes = filterUnknownCookies(Object.keys(req.cookies));
    for (let cookie of cookieTypes) {
        const funcName = `validateCookie${cookie}`;
        const func = new Function('return ' + funcName + '(\'' + req.cookies[cookie] + '\')');
        res.locals[cookie] = func();
    }
    next();
}