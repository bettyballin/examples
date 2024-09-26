const { JWT, errors } = require('jose/dist/node/cjs');

async function validateToken(id_token, keyset) {

    try{
        const payload = await JWT.verify(id_token, keyset);
        return payload;
    } catch (err) {
        if (err instanceof errors.JWTClaimValidationFailed) {
            console.error('Invalid token claim:', err.claim);
        } else if (err instanceof errors.JWTInvalid) {
            console.error('Invalid token:', err.message);
        } else {
            console.error('Error validating token:', err.message);
        }
        return null;
    }
}

// Example usage
validateToken('your_id_token', 'your_keyset')
    .then(payload => console.log('Valid token payload:', payload))
    .catch(err => console.error('Error:', err));