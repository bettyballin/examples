function hasOnlyWhitelistedCharacters(string)
{
    var whitelist = /^\w*$/;
    console.log(whitelist.test(string));
    return whitelist.test(string);
}

function hasNoBlacklistedCharacters(string)
{
    var blacklist = /\W/;
    console.log(blacklist.test(string));
    return ! blacklist.test(string);
}

// Test the functions
console.log("Testing hasOnlyWhitelistedCharacters:");
hasOnlyWhitelistedCharacters("HelloWorld");
hasOnlyWhitelistedCharacters("Hello World");

console.log("\nTesting hasNoBlacklistedCharacters:");
hasNoBlacklistedCharacters("HelloWorld");
hasNoBlacklistedCharacters("Hello World");