
function isActivexEnabled() {
    var supported = null;
    try {
        supported = !!new ActiveXObject("htmlfile");
    } catch (e) {
        supported = false;
    }
    return supported;
}

if (isActivexEnabled()) {
    // Proceed to create Word.Application
} else {
    // Notify user that spell check cannot be used
}

