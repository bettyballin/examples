import { useState } from "react";
import {
  createUserWithEmailAndPassword,
  getAuth,
  signInWithEmailAndPassword
} from "firebase/auth";

export const ConnectionPage = () => {
  // the values of the inputs in the HTML content
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  // the function executed when the user clicks the register button
  const submit = async (e) => {
    e.preventDefault();

    try {
      await getAuth().signOut(); // Sign out current user

      const { user } = await createUserWithEmailAndPassword(
        getAuth(),
        email,
        password
      );

      console.log("User created successfully:", user);

      // Log in the new user immediately after creation
      const newUserCredentials = await signInWithEmailAndPassword(
        getAuth(),
        email,
        password
      );
    } catch (e) {
      console.error("An error has occurred during register look:");
      console.error(e.toString());
    }
  };

  return (
    <form onSubmit={submit}>
      <input
        type="email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
        placeholder="Email"
      />
      <input
        type="password"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
        placeholder="Password"
      />
      <button type="submit">Register</button>
    </form>
  );
};