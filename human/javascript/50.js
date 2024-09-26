function hasOnlyWhitelistedCharacters(string)
{
    // match all characters, which must be in the set
    var whitelist = /^[\w\s\u00C0-\uDFFF\uF900-\uFFFF]*$/;
    console.log(whitelist.test(string));
    return whitelist.test(string);
}

function hasNoBlacklistedCharacters(string)
{
    // match one character not in the set
    var blacklist = /[^\w\s\u00C0-\uDFFF\uF900-\uFFFF]/;
    console.log(blacklist.test(string));
    return ! blacklist.test(string);
}

// Test the functions
console.log(hasOnlyWhitelistedCharacters("Hello World"));
console.log(hasOnlyWhitelistedCharacters("Hello! World"));
console.log(hasNoBlacklistedCharacters("Hello World"));
console.log(hasNoBlacklistedCharacters("Hello! World"));