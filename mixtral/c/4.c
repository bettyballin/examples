#include <stdio.h>
#include <stdlib.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <unistd.h>

static int is_secure(const char *name, uid_t trusted_uid, gid_t trusted_gid) {
    struct stat st;

    if (stat(name, &st) != 0) {
        perror("can't stat() file");
        return 0;
    }

    /* writable by other or group: unsure */
    if ((st.st_mode & S_IWOTH) || (st.st_mode & S_IWGRP)) {
        return 0;
    }

    /* not owned by trusted user/group and not owned by effective user/group: unsure */
    if ((trusted_uid && st.st_uid != trusted_uid) || (trusted_gid && st.st_gid != trusted_gid)) {
        return 0;
    }

    return 1;
}

int main(int argc, char *argv[]) {
    if (argc != 4) {
        printf("Usage: %s <filename> <trusted_uid> <trusted_gid>\n", argv[0]);
        return 1;
    }

    const char *name = argv[1];
    uid_t trusted_uid = atoi(argv[2]);
    gid_t trusted_gid = atoi(argv[3]);

    int secure = is_secure(name, trusted_uid, trusted_gid);

    if (secure) {
        printf("File is secure.\n");
    } else {
        printf("File is not secure.\n");
    }

    return 0;
}