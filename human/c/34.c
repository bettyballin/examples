#include <stdio.h>
#include <string.h>

int count_digits(int number) 
{
    int digits = 0;
    if (number < 0) 
        digits = 1; 

    while (number) 
    {
        number /= 10;
        digits++;
    }

    return digits;
}

char get_digit(int number, int index) 
{
    if (number == 0)
        return (char)0;

    int n_digits = count_digits(number);
    if (index > n_digits)
        return (char)-1;

    char digit = -1;
    int i;
    for (i = 0; i < (n_digits-index-1); i++)
    {
        digit = number % 10;
        number /= 10;
    }

    digit = number % 10;

    return digit;   
}

int main()
{
    printf("* Type the encoding key (numbers only): ");
    int key = 0;
    scanf("%d", &key);

    int key_digits = count_digits(key);

    char input_msg[] = "ABCABC"; 
    int input_sz = strlen(input_msg);

    int i, d = 0;   
    for (i = 0; i < input_sz; i++)
    {       
        if (d >= key_digits)
            d = 0;

        input_msg[i] += get_digit(key, d);      
        d++;
    }

    printf("* Encoded text is: %s\n", input_msg);

    return 0;
}