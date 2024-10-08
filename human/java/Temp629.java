public class Temp629 {
    public static void main(String[] args) {
        // Also, if some aspect of the certificate chain was unacceptable (e.g.,
        // it was not signed by a known, trusted CA), the server MAY at its
        // discretion either continue the handshake (considering the client
        // unauthenticated) or send a fatal alert.

        // This gives some flexibility regarding what to do when a unacceptable certificate is sent. 
        // The JSSE chooses to send a fatal alert. (`setWantAuth` could in principle carry on with 
        // invalid certificates, but not treat the peer as authenticated, as if no client certificate 
        // was sent, but this isn't the case.)

        // Previous versions of the TLS spec said 
        // "*If client authentication is required by the server for the handshake to continue, 
        // it may respond with a fatal handshake failure alert.*". This is the difference between 
        // need or want as implemented in the JSSE: using "need", the server responds with a fatal
        // handshake failure, whereas using "want", the server carries on with the connection, 
        // but doesn't treat it as authenticated.
    }
}