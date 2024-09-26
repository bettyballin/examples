const recaptcha = grecaptcha.render('recaptcha-container', {
  siteKey: 'YOUR_SITE_KEY',
  size: 'invisible',
  callback: function(token) {
    fetch('/verify', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        token: token
      })
    });
  }
});

const form = document.querySelector('form');
form.addEventListener('submit', (e) => {
  e.preventDefault();
  const newToken = grecaptcha.getResponse(recaptcha);
  fetch('/verify', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({
      token: newToken
    })
  });
});