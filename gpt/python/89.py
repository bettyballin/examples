
import math
import os
import random
import string

# Input the number to start counting from
Starting_number = int(input("Enter the starting number: "))

# Input the number to end the count on.
Ending_number = int(input("Enter the number you want to count up to: "))

prime_numbers = []  # Initialize an empty list to store prime numbers

# Check if the starting number is positive
if Starting_number < 0:
    print(f'Invalid entry, please enter a positive number. \nWill count from {Starting_number} to 0 and begin prime number count to {Ending_number}.')

# If the ending number is not positive
if Ending_number <= 0:
    print('Invalid entry on last input \nPlease enter two positive numbers for the count to work.')

