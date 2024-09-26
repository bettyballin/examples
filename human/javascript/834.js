try {
    res.locals[cookie] = validateCookie[cookie](req.cookies[cookie]);
} catch(e) {
    console.error(`Error validating cookie: ${e.message}`);
    // You can also add additional error handling or logging here
    res.status(401).send('Invalid cookie');
}