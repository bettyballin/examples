(function() {
    if (!window.location.hasOwnProperty("origin")) {
        window.location.origin = window.location.protocol + "//" + window.location.host;
    }
})();