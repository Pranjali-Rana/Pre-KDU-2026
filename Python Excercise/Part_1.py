# Part 1: Password Validator
# A user creates an account by entering their password twice. Check if they match.

# Write a Python program that:

# Takes two strings as input (password and confirmation)
# Prints the length of the first string
# Prints the length of the second string
# Prints if the lengths match
# Prints if the two strings are the same
# Example:

# Input: "movie@2026" and "movie@2026"
# Output:
# Length 1: 10
# Length 2: 10
# Lengths match: True
# Strings match: True
# Part 1: Password Validator

password = input("Enter password: ")
confirm_password = input("Confirm password: ")

# Lengths
len1 = len(password)
len2 = len(confirm_password)

print("Length 1:", len1)
print("Length 2:", len2)

# Compare lengths
print("Lengths match:", len1 == len2)

# Compare strings
print("Strings match:", password == confirm_password)