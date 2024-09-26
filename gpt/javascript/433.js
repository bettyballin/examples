
const sanitizeJson = (obj) => {
  const sanitizeString = (str) => {
    return str.replace(/[^\w\s]/gi, (match) => {
      return 'codePoint#' + match.charCodeAt(0);
    });
  };

  const replacer = (key, value) => {
    if (typeof value === 'string') {
      return sanitizeString(value);
    }
    return value;
  };

  return JSON.stringify(obj, replacer);
};

// Example usage:
const dataToEncode = {
  dangerous: "<script>alert('xss');</script>"
};

const sanitizedData = sanitizeJson(dataToEncode
