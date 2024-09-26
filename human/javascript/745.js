class Authentication {
    constructor(storageKey) {
        this.tokenResponse = null;
        this.tokenClaims = null;
        this.tokenHasExpired = false;
        this.accessToken = null;
        this.storageKey = storageKey;
        this.localStorage = window.localStorage;
    }

    destroyUserCredentials() {
        this.tokenResponse = null;
        this.tokenClaims = null;
        this.tokenHasExpired = true;
        this.accessToken = null;
        this.localStorage.removeItem(this.storageKey);
    }
}

// Usage
const auth = new Authentication('user_credentials');
auth.destroyUserCredentials();