function generateCsrfToken() {
  return Math.random().toString(36).substr(2) + Math.random().toString(36).substr(2);
}

function addScore(gType, amount) {
  var xhr = new XMLHttpRequest();
  xhr.open('POST', 'http://localhost/TM/backend/score.backend.php', true);
  xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

  const csrfToken = generateCsrfToken();

  xhr.onload = function() {
    console.log('score request sent: ' + xhr.responseText);
  };

  xhr.send(`score=${amount}&gType=${gType}&csrfToken=${csrfToken}`);
}