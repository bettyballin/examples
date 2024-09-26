
function isUserInvite() {
  return request.auth.token.email != null &&
  resource.data != null &&
  request.auth.token.email == resource.data.user_email;
}

