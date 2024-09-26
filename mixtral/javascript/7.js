var encodedUsername = "${pageContext.request.userPrincipal.name}";
encodedUsername = encodeURIComponent(encodedUsername);

// To display the username
document.write(decodeURIComponent(encodedUsername));