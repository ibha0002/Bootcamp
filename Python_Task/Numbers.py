# Program that determines pairs of numbers whos sum is equal to the first number(target number)
# In this code I haven't used functions and main function as well to keep the program simple.
# Using list as data structure, since it offers built in functions and seems most feasible.


print("Welcome to pair calculator!")
first_number = int(input("Enter the first number:"))
number_list = []  # to hold list of numbers
pairs = []  # List to hold successful pairs

# Taking input from user
while True:
    input_number = int(input("Enter the number in the list. Enter -1 to exit"))
    if input_number > 0:
        number_list.append(input_number)
    elif input_number <= 0 and input_number != -1:
        print("Enter a number greater than zero")
    elif input_number == -1:
        break

# Determining pairs of numbers whose sum is equal to the first number
i = 0  # Initial index
while i < len(number_list) - 1:
    j = i + 1
    while j < len(number_list):
        num1 = number_list[i]
        num2 = number_list[j]
        if num1 != num2:                        # Two numbers in a pair must not be the same
            if first_number == num1 + num2:     # Validating the condition
                pairs.append(num1)              # Appending numbers to the pairs list which satisfies the criteria
                pairs.append(num2)
        j += 1
    i += 1

# Removing duplicate pairs from the list, by capturing the pairs and comparing it with the other pair.

k = 0
while k <= len(pairs) - 4:  # Pick numbers until 4th last position, since we are capturing the pairs
    num1 = pairs[k]         # pairs
    num2 = pairs[k + 1]
    m = k + 2
    while m <= len(pairs) - 2:  # Go until second last index
        num3 = pairs[m]
        num4 = pairs[m + 1]
        if (num1 == num3 and num2 == num4) or (num1 == num4 and num2 == num3):  # Condition that determines duplicates
            pairs.pop(m)                                                       # Removing duplicate pairs
            pairs.pop(m)
            m -= 2                                                              # Adjusting the index
        m += 2
    k += 2

# Printing the pairs of numbers.
for index in range(0, len(pairs) - 1, 2):
    print("[" + str(pairs[index]) + "," + str(pairs[index + 1]) + "] ", end="")