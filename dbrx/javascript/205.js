const cookie_validators = {
  cookiename_1: (cookie) => { /* validation logic */ },
  cookiename_2: (cookie) => { /* validation logic */ }
};

const filterUnknownCookies = (cookies) => {
  return cookies.filter((cookie) => Object.keys(cookie_validators).includes(cookie));
};

exports.validateCookies = async (req, res, next) => {
  const valid_cookies = filterUnknownCookies(Object.keys(req.cookies));
  for (const cookie of valid_cookies) {
    try {
      await cookie_validators[cookie](req.cookies[cookie]);
      res.locals[cookie] = true;
    } catch (_) {}
  }
  next();
};