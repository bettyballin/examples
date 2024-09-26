
function isLocalhost() {
    const hostname = window.location.hostname;
    return hostname === "127.0.0.1" || hostname === "localhost";
}

console.log(isLocalhost()); // Will return true if you are on localhost

