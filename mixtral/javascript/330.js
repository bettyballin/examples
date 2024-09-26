firebase.auth().createUserWithEmailAndPassword(email, password)
    .then((userCredential) => {
        const userId = userCredential.user.uid;

        // Write the new user's data to Firestore
        firebase.firestore().collection("users").doc(userId).set({
            email: email,
            // Add other user data here
        })
        .then(() => {
            console.log("User signed up correctly");
        })
        .catch((error) => {
            console.log("Error writing user data to Firestore");
            console.log(error);
        });
    })
    .catch((error) => {
        console.log('User did not sign up correctly');
        console.log(error);
    });