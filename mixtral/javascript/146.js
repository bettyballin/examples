(async () => {
  const phoneNumber = '+1234567890'; // replace with actual phone number
  const data = {
    timestamp: Date.now(),
    // add other data properties as needed
  };

  const previousVerification = await firebase
    .database()
    .ref(`verifications/${phoneNumber}`)
    .once('value');

  if (previousVerification &&
      data.timestamp <=
        previousVerification.val().timestamp + 60 * 1000
     ) {
       throw new Error("Too soon to request a verification code.");
  }

  await firebase
   .database()
   .ref(`verifications/${phoneNumber}`)
   .set(data);
})();