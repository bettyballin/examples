#include <libssh2.h>
#include <libssh2_publickey.h>
#include <stdio.h>

int main() {
    libssh2_session *session;
    libssh2_channel *channel;
    int state, rc;

    // Initialize libssh2
    libssh2_session_init();

    // Create a new SSH session
    session = libssh2_session_open();

    // Connect to the SSH server
    state = libssh2_session_connect(session, "localhost", 22);
    if (state != LIBSSH2_ERROR_NONE) {
        printf("Error connecting: %s\n", libssh2_session_last_error(session));
        return 1;
    }

    // Authenticate with the SSH server
    rc = libssh2_userauth_password(session, "username", "password");
    if (rc != LIBSSH2_AUTH_SUCCESS) {
        printf("Authentication failed.\n");
        // Handle authentication failure
    } else {
        state = libssh2_session_is_server_known(session);
        if (state != LIBSSH2_SERVER_KNOWN_OK) {
            printf("SSH Server is not known\n");
        }
    }

    // Shutdown the SSH session
    libssh2_session_disconnect(session, "Client disconnecting normally");

    // Free the SSH session
    libssh2_session_free(session);

    return 0;
}