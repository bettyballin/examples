
ssh_session session;
int verbosity = SSH_LOG_PROTOCOL;
int port = 22;
ssh_known_hosts_e state;

// ssh_init(); // Not needed, remove this line

session = ssh_new();
if (session == NULL) {
    printf("Failed to create SSH session\n");
    return NULL;
}

ssh_options_set(session, SSH_OPTIONS_HOST, "111.111.111.111");
ssh_options_set(session, SSH_OPTIONS_USER, "user");
ssh_options_set(session, SSH_OPTIONS_LOG_VERBOSITY,
