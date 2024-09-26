const cookieName = 'yourCookieName'; // replace with your cookie name

const Cookie = {
  get: (name) => {
    const cookies = document.cookie.split(';');
    for (let i = 0; i < cookies.length; i++) {
      const cookie = cookies[i].trim();
      if (cookie.startsWith(name + '=')) {
        const value = cookie.substring(name.length + 1);
        return { value, secure: cookie.includes(' Secure') };
      }
    }
    return null;
  },
  delete: (name) => {
    document.cookie = `${name}=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;`;
  }
};

const cookie = Cookie.get(cookieName);
if (cookie && cookie.secure) {
  console.log('Cookie has secure flag set, proceeding with deletion');
  Cookie.delete(cookieName);
} else {
  console.log('Cookie does not have secure flag set, will not delete');
}