Promise.reject({ code: 'TEST_ERROR', message: 'Test error message' })
  .catch(function(error) {
    // Handle Errors here.
    var errorCode = error.code;
    var errorMessage = error.message;

    console.log('User did not sign up correctly');
    console.log(errorCode);
    console.log(errorMessage);
  });