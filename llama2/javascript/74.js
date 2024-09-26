// Define the Cookie class
class Cookie {
  static update(cookie, options) {
    // Parse the cookie string
    const cookieArray = cookie.split(';');
    const cookieName = cookieArray[0].split('=')[0];
    const cookieValue = cookieArray[0].split('=')[1];

    // Create a new cookie string with the updated options
    let updatedCookie = `${cookieName}=${cookieValue};`;

    // Add the secure option
    if (options.secure) {
      updatedCookie += ' Secure;';
    }

    // Add other options if needed

    return updatedCookie;
  }
}

// Get the current cookie
const cookie = document.cookie;

// Update the cookie with the secure option
const updatedCookie = Cookie.update(cookie, { secure: true });

// Update the document cookie
document.cookie = updatedCookie;