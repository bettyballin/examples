
cordova.plugins.firebase.auth.verifyPhoneNumber(phoneNumber, timeout).then(function(verificationId) {
    // Use verificationId to sign in or complete the verification process...
    // After successful verification
    cordova.plugins.firebase.auth.getIdToken(true).then(function
