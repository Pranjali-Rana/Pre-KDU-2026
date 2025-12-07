# Part 2: Genre Preferences
# 10 users select their favorite movie genres. Some pick the same genre multiple times.

# Write a Python program that:

# Takes 10 strings as input (genres like "Action", "Comedy", "Drama", etc.)
# Adds them to a List (to see all selections)
# Adds them to a Set (to see unique genres)
# Creates a Dictionary with genre name as key and count as value
# Prints all three collections
# Example Input:

# Action, Comedy, Action, Drama, Horror, Action, Comedy, Drama, Thriller, Action
# Example Output:

# List: ['Action', 'Comedy', 'Action', 'Drama', 'Horror', 'Action', 'Comedy', 'Drama', 'Thriller', 'Action']

# Set: {'Action', 'Comedy', 'Drama', 'Horror', 'Thriller'}

# Dictionary: {'Action': 4, 'Comedy': 2, 'Drama': 2, 'Horror': 1, 'Thriller': 1}

# Part 2: Genre Preferences

genres = []

print("Enter 10 movie genres:")

for i in range(10):
    g = input(f"Genre {i+1}: ")
    genres.append(g)

# List (all selections)
genre_list = genres

# Set (unique)
genre_set = set(genres)

# Dictionary (count occurrences)
genre_dict = {}

for g in genres:
    if g in genre_dict:
        genre_dict[g] += 1
    else:
        genre_dict[g] = 1

print("\nList:", genre_list)
print("Set:", genre_set)
print("Dictionary:", genre_dict)
