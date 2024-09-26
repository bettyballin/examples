function recordPageView(url) {
    if (!window.location.origin || window.location.origin !== 'http://example.com') {
        return; // or throw an error etc.
    }
    // rest of the function
    console.log(`Page view recorded for ${url}`);
}

// Call the function
recordPageView('http://example.com/path/to/page');