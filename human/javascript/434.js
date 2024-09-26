const firebaseConfig = {
  // Your Firebase configuration
};

const db = firebase.initializeApp(firebaseConfig).database();

const modulId = "yourModulId";

db.ref("moduls/" + modulId).on("value", (data) => {
  const writeRule = "!data.exists() && newData.exists()";
  const newData = { some: "new data" };

  if (eval(writeRule)) {
    db.ref("moduls/" + modulId).set(newData);
  }
});