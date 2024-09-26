
firebase.database().ref('/moduls/' + moduleId).once('value', snapshot => {
  if (snapshot.exists()) {
    const modul = snapshot.val();
    // Do something with the modul
  } else {
    // Modul not found, handle the error
  }
});

