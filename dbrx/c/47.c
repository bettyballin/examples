#include <csignal>
#include <cstdlib>

void handle_signal(int sig) {
    // Clear decrypted contents on the heap here
    std::exit(EXIT_FAILURE);
}

int main() {
    struct sigaction sa;
    sa.sa_handler = &handle_signal;
    sa.sa_flags = 0;

    if (sigemptyset(&sa.sa_mask) == -1 ||
        sigaction(SIGINT, &sa, NULL) == -1 ||
        sigaction(SIGHUP, &sa, NULL) == -1 ||
        sigaction(SIGTERM, &sa, NULL) == -1)
    {
        return EXIT_FAILURE;
    }

    // Rest of your program here

    return EXIT_SUCCESS;
}