var ref = firebase.database().ref('units');

// Make sure you're logged in
firebase.auth().onAuthStateChanged(function (user) {
  if (!user) return;

  // Get the user UID
  var uid = user.uid;

  ref.child("1").once('value', function (snapshot) {
    console.log(snapshot.val());

    snapshot.forEach((dataSnapshot) => {
      const dataKey = dataSnapshot.key;

      // Check if the current authenticated user has access to this unit
      ref.child(`units/${dataKey}`).once('value', function (unitDataSnapshot) {
        console.log(unitDataSnapshot);

        var emailFromUnit = unitDataSnapshot.val().userEmail;

        // Get the authenticated user's email
        firebase
          .database()
          .ref(`users/${uid}/email`)
          .once('value', function (authUserEmail) {
            console.log(authUserEmail);

            if (!unitDataSnapshot || !authUserEmail) return;

            // Compare the emails
            var isAllowed = emailFromUnit === authUserEmail.val();

            if (isAllowed) {
              console.log("Access granted");

              // Do something with this unit data

            } else {
              console.error(
                "You don't have access to view the details of this unit."
              );

              return;

            }
          });
      }).catch((err) =>
        console.log("Error fetching user data:", err)
      );
    });
  });
});