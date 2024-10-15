import random
import math
import time

scores = [random.randint(0, 100) for _ in range(1000000)]

start = time.time()

total_sum = 0 # 1
for score in scores: # 2n
    total_sum += score

mean = total_sum / len(scores) # 3


squared_diffs_sum = 0 # 1
for score in scores: # 4n
    squared_diffs_sum += (score - mean) ** 2

variance = squared_diffs_sum / (len(scores) - 1) # 4
std_dev = math.sqrt(variance) # 2


print(f"Score Mean: {mean}") # 1
print(f"Score Standard Deviation: {std_dev}") # 1

end = time.time()

print(f"total time : {end - start}")

# T(n) = 6n + 13