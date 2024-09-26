const validators = {
  'cookieName_1': validateCookie1,
  'cookieName_2': validateCookie2
};

const validateCookie1 = (cookie) => {
  // implement validation logic for cookieName_1
  return cookie;
};

const validateCookie2 = (cookie) => {
  // implement validation logic for cookieName_2
  return cookie;
};

const filterUnknownCookies = (cookieArr) =>
  cookieArr.filter((name) => Object.keys(validators).includes(name));

exports.validateCookies = (req, res, next) => {
  const cookieTypes = filterUnknownCookies(Object.keys(req.cookies));

  for (let type of cookieTypes) {
    if (!validators[type]) {
      // Handle unknown cookies
      continue;
    }

    try {
      res.locals[type] = validators[type](req.cookies[type]);
    } catch (error) {
      console.log(`Error while processing cookie ${type}: ${error}`);
    }
  }

  next();
};