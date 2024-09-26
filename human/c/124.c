#include <libssh2.h>
#include <libssh2_publickey.h>
#include <stdio.h>

int main() {
    ssh_session my_ssh_session;
    int rc;

    // Initialize the SSH session
    my_ssh_session = ssh_new();

    if (my_ssh_session == NULL) {
        fprintf(stderr, "Error creating SSH session\n");
        exit(-1);
    }

    // Connect to localhost
    rc = ssh_connect(my_ssh_session);

    if (rc != SSH_OK) {
        fprintf(stderr, "Error connecting to localhost: %s\n",
                ssh_get_error(my_ssh_session));
        ssh_free(my_ssh_session);
        exit(-1);
    }

    // Clean up
    ssh_disconnect(my_ssh_session, "Client disconnecting normally");
    ssh_free(my_ssh_session);

    return 0;
}