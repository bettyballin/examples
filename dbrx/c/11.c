#include <stdio.h>
#include <string.h>

int main() {
    char firstName[11], surName[21], job[16];
    int ret;

    printf("Enter first name: ");
    ret = scanf("%10s", firstName);
    if (ret != 1) {
        /* Handle error */
        return 1;
    }

    /* Clear input buffer before using fgets() */
    while ((getchar()) != '\n');

    printf("Enter surname: ");
    fgets(surName, sizeof(surName), stdin);

    /* Remove newline character from the end of surName */
    surName[strcspn(surName, "\n")] = 0;

    printf("Enter job: ");
    ret = scanf("%15s", job);
    if (ret != 1) {
        /* Handle error */
        return 1;
    }

    /* Clear input buffer before using fgets() */
    while ((getchar()) != '\n');

    /* Remove newline character from the end of firstName and job if needed */
    firstName[strcspn(firstName, "\n")] = 0;
    job[strcspn(job, "\n")] = 0;

    printf("First name: %s\n", firstName);
    printf("Surname: %s\n", surName);
    printf("Job: %s\n", job);

    return 0;
}