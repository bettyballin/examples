function warnUser() {
  console.log("Warning: User has been warned!");
}

GM_openSQL_Connection = function() {
  warnUser();
};

// Call the function to test it
GM_openSQL_Connection();