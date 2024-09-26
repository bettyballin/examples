
// fetchWrapper.js
const fetchWrapper = async (url, options) => {
  const response = await fetch(url, options);
  if (response.status === 401) {
    // Handle logout and redirection to the login page here
    logoutUser(); // This should clear any stored authentication tokens or user data
    window.location.href = '/login'; // Redirect to the login page
  }
  return response;
};

export default fetchWrapper;

