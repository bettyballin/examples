
function hasOnlyWhitelistedCharacters(string) {
    var whitelist = RegExp("^[\\w]+$"); // Match only if all characters are alphanumeric or underscore
    console.log(whitelist.test(string));
    return whitelist.test(string);
}

