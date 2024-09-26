#include <libssh2.h>
#include <stdio.h>

int main() {
    libssh2_session *session;
    int rc;
    int state;

    // Initialize libssh2
    libssh2_session_init();

    // Create a new SSH session
    session = libssh2_session_open();

    // Connect to the SSH server
    rc = libssh2_session_connect(session, "localhost", 22);

    if (rc != 0) {
        fprintf(stderr, "Error connecting to server: %s\n", libssh2_session_last_error(session));
        libssh2_session_free(session);
        libssh2_exit();
        return 1;
    }

    // Authenticate if necessary
    state = libssh2_session_is_server_known(session);
    if (state != 0) {
        printf("SSH Server is not known\n");
        libssh2_session_free(session);
        libssh2_exit();
        return 1;
    }

    // Clean up and exit
    libssh2_session_disconnect(session, "Client disconnecting normally");
    libssh2_session_free(session);
    libssh2_exit();
    return 0;
}