Here is the JavaScript code:


function ProcessRequest(context, eventJSON) {
    const authenticationKey = context.request.params[2].toString();
    if (IsKeyValid(authenticationKey, context)) {
        context.response.write(CreateCRMEvent(eventJSON));
    } else {
        // if the caller didn't know the key we expected, then just quietly fail
        // by returning a guid.  no need to let malicious users know they failed.
        context.response.write(guid());
    }
}

function IsKeyValid(keyToAuthenticate, context) {
    try {
        // a key is valid if:
        // 1: it begins with a guid that we have in session
        // 2: it contains a timestamp that has been encrypted with our key, and is within the timeout period
        let sessionGuid = '';
        const lengthOfAGuid = 36;
        if (context.session && context.session.EVENTKEY) {
            sessionGuid = context.session.EVENTKEY.toUpperCase();
        }

        if (!keyToAuthenticate || !sessionGuid) {
            return false; // invalid because they provided no key, or we have no knowledge of issuing one
        }

        if (keyToAuthenticate.length <= lengthOfAGuid) {
            return false; // invalid because their key does not contain a valid guid + encrypted timestamp
        }

        const expectedGuid = keyToAuthenticate.substring(0, 36).toUpperCase();
        if (sessionGuid !== expectedGuid) {
            return false; // invalid because the guid they gave is not one we remember issuing
        }

        // they knew the guid we have in session.  Check the timestamp.
        let iEpochSeconds = 0.0;
        try {
            const encryptedTimeStamp = keyToAuthenticate.substring(lengthOfAGuid);
            const decryptedTimeStamp = decrypt(encryptedTimeStamp);
            if (!isNaN(parseFloat(decryptedTimeStamp))) {
                iEpochSeconds = parseFloat(decryptedTimeStamp);
            } else {
                return false; // invalid because the timestamp decrypted, but not to a valid # of seconds
            }
        } catch {
            return false; // invalid because whatever timestamp they tried to give us doesn't decrypt
        }

        // give them 30 minutes to finish.  we can tweak this later if it's a problem.
        const timeoutSeconds = 1800.0;
        const maxAllowedEpochTime = (new Date() - new Date('1970-01-01T00:00:00.000Z')) / 1000 + timeoutSeconds;
        if (iEpochSeconds > maxAllowedEpochTime) {
            return false; // invalid because their timestamp expired
        }

        // couldn't find anything wrong.  let it through.
        return true;
    } catch {
        return false; // invalid because the request was in a format we do not recognize.
    }
}

// Helper function to generate a GUID
function guid() {
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
        var r = Math.random() * 16 | 0, v = c == 'x' ? r : (r & 0x3 | 0x8);
        return v.toString(16);
    });
}

// Helper function to decrypt the timestamp
function decrypt(encryptedTimeStamp) {
    // Your decryption logic goes here
    // For example:
    return encryptedTimeStamp;
}

// Helper function to create the CRM event
function CreateCRMEvent(eventJSON) {
    // Your logic to create the CRM event goes here
    // For example:
    return eventJSON;
}