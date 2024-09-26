let postOnly = true;

function attemptAuthentication(request, response) {
  if (postOnly && request.method !== "POST") {
    throw new Error(`Authentication method not supported: ${request.method}`);
  }
}