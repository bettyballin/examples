const createUserRoles = async (user) => {
  //on login the user will be added to editors collection with default value of reviewer
  console.log("hello from createeee");
  // This is RTDB syntax for a ref
  // const editorsRef = firebase.database().ref("editors");
  // Try this instead
  const editorsRef = firebase.firestore().collection("editors");

  const editor = {
    email: user.email,
    role: "reviewer",
    lastSession: Date.now(),
  };

  // This is how you add an item to RTDB
  // editorsRef.push(editor);
  // This is the Firestore way to create a new record with a random, unique document id
  await editorsRef.add(editor);
};

// Call the function to make it executable
createUserRoles({ email: "example@example.com" });