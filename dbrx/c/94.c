I can make the code executable for you, but please note that there are some issues with the code that need to be addressed. Here is the modified code:


#include <stdio.h>
#include <ctype.h>

void quit();
void again();
void final_print();
void main2();

struct Employee {
    char name[100];
} emp[5];

void quit()
{
    char ans[5];

    printf("ARE YOU SURE YOU WANT TO QUIT THE WIZARD? Y OR N\n");
    if (scanf("%4s", ans) != 1 || tolower((unsigned char) ans[0]) != 'y') {
        main2();
    } else {
        final_print();
        printf("\n---THANK YOU FOR USING OUR PORTAL---\n");
    }
}

void again()
{
    char ans1[5];

    printf("SEARCH AGAIN USING ID AND PASSWORD? Y OR N\n");
    if (scanf("%4s", ans1) != 1 || tolower((unsigned char) ans1[0]) != 'y') {
        quit();
    } else {
        main2(); // FOR RE-LOGIN PROCESS
    }
}

void final_print()
{
    printf("----------------FINAL STATEMENT OF LEAVE OF EACH EMPLOYEE------------------------\n");
    int i;
    for (i = 0; i < 5; i++) {
        printf("NAME  : %s\n", emp[i].name);
    }
}

void main2()
{
    // Add your implementation here
    printf("Add your implementation here\n");
}

int main()
{
    // Initialize emp array
    for (int i = 0; i < 5; i++) {
        sprintf(emp[i].name, "Employee %d", i);
    }

    main2();

    return 0;
}


Please note that I had to make some changes to the code to make it compile and run. I added a `struct Employee` to hold the employee data, and a `main2()` function to replace the missing implementation. I also added some initialization code in the `main()` function to populate the `emp` array. You will need to modify the `main2()` function to implement the actual logic for your program.