function verify() {
    const pk = { n: 323, e: 17 }; // sample public key
    const key = new RSAKey();
    key.setPublic(pk.n, pk.e);
}

class RSAKey {
    setPublic(n, e) {
        this.n = n;
        this.e = e;
    }
}

const rsaKey = new RSAKey();
verify();