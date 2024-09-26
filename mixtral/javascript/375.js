import { ref, set, push, child, update, remove, getDatabase, onValue } from "firebase/database";

const database = getDatabase();

// Write to RTDB
const userId = "some-user-id";
const userData = { name: "John Doe", email: "john.doe@example.com" };
set(ref(database, 'users/' + userId), userData);

// Read data
const path = "/path";
onValue(ref(database, path), (snapshot) => {
  const value = snapshot.val();
  console.log(value);
});