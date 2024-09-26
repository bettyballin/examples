admin.auth().setCustomUserClaims(clientUserId, {role: 'client'});
admin.auth().setCustomUserClaims(serverUserId, {role: 'server'});