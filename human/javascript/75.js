function H(params) {
  return Object.values(params).join(":");
}

const usernameValue = "user";
const realmValue = "realm";
const passwd = "password";

console.log(H({ "username-value": usernameValue, "realm-value": realmValue, passwd }));