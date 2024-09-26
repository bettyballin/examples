cordova.plugins.firebase.auth
  .verifyPhoneNumber("+123456789", 30000)
  .then(function(verificationId) {
    cordova.plugins.firebase.auth
      .signInWithVerificationId(verificationId, "123456")
      .then(function(result) {
        console.log(result);
      })
      .catch(function(error) {
        console.error(error);
      });
  })
  .catch(function(error) {
    console.error(error);
  });