function validateUrl(url) {
    const parsedUrl = new URL(url);
    if (parsedUrl.port !== '' && parsedUrl.port !== '123') {
        return false;
    }
    if (parsedUrl.hostname === 'ajax.googleapis.com' && parsedUrl.port !== '') {
        return false;
    }
    return true;
}

console.log(validateUrl('https://ajax.googleapis.com:123'));  // false
console.log(validateUrl('https://ajax.googleapis.com'));  // true
console.log(validateUrl('http://example.com/free/stuff/file.js'));  // false
console.log(validateUrl('http://example.com:123/free/stuff/file.js'));  // true