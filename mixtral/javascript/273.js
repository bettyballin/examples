<!DOCTYPE html>
<html>
<head>
  <script src="https://www.gstatic.com/firebasejs/8.2.1/firebase-app.js"></script>
  <script src="https://www.gstatic.com/firebasejs/8.2.1/firebase-auth.js"></script>
</head>
<body>
  <script>
    var firebaseConfig = {
      apiKey: "<API_KEY>",
      authDomain: "<AUTH_DOMAIN>",
      projectId: "<PROJECT_ID>",
      storageBucket: "<STORAGE_BUCKET>",
      messagingSenderId: "<MESSAGING_SENDER_ID>",
      appId: "<APP_ID>",
      measurementId: "<MEASUREMENT_ID>"
    };

    firebase.initializeApp(firebaseConfig);

    firebase.auth().onAuthStateChanged(user => {
      if (user) {
        window.location = 'https://www.camisiite.alenieto97.now.sh/home.html';
      } else {
        console.log('not logged in');
      }
    });
  </script>
</body>
</html>