# Part 3: Top Watched Movies
# A CSV file contains movie titles watched by users. Find the top 3 most watched movies.

# Write a Python program that:

# Reads a CSV file with comma-separated movie titles
# Counts how many times each movie appears
# Prints the top 3 movies with their watch counts
# Sample CSV file (watchlist.csv):

# Inception, Avatar, Inception, Titanic, Interstellar, Inception, Avatar, Titanic, Interstellar, Inception, Avatar, Interstellar, Inception, Avatar, Inception
# Hint: Use open() to read the file, split(",") to separate titles, and a dictionary to count.

# Read file
with open("watchlist.csv", "r") as file:
    data = file.read()

# Split by comma
movies = data.split(",")

# Count occurrences
movie_count = {}

for movie in movies:
    movie = movie.strip()  # remove spaces
    if movie in movie_count:
        movie_count[movie] += 1
    else:
        movie_count[movie] = 1

# Sort by count (descending)
sorted_movies = sorted(movie_count.items(), key=lambda x: x[1], reverse=True)

# Print top 3
print("Top 3 most watched movies:")
for movie, count in sorted_movies[:3]:
    print(movie, ":", count)
