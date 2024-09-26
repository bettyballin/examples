function organizationPrivateData(organizationId) {
  // Mock data
  const data = {
    1: {
      readTokens: ['token1', 'token2']
    }
  };

  return data[organizationId];
}

function isReadTokenValid (organizationId, token) {
  return token in organizationPrivateData(organizationId).readTokens;
}

// Test the function
console.log(isReadTokenValid(1, 'token1')); // true
console.log(isReadTokenValid(1, 'token3')); // false