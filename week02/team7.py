import random

# 1. 랜덤으로 3차원 좌표 100만개 생성 (범위: 150x150x150)
points = [(random.uniform(0, 150), random.uniform(0, 150), random.uniform(0, 150)) for _ in range(1_000_000)]

volume = 50 * 50 * 50
step = 50

count = [[[0 for _ in range(100 // step)] for _ in range(100 // step)] for _ in range(100 // step)]
density = [[[0 for _ in range(100 // step)] for _ in range(100 // step)] for _ in range(100 // step)]

for i in range(100//step):
    for j in range(100//step):
        for k in range(100//step):
            # 2. 50x50x50 사이즈의 영역을 탐색하여 점의 개수 카운트
            count[i][j][k] = sum(1 for x, y, z in points if i * step <= x <= i * step + 50 and j * step <= y <= j * step + 50 and k * step <= z <= k * step + 50)
            # 3. 50x50x50 영역의 밀도 계산
            print(f"Density of points in 50x50x50 region from ({i*step}, {j*step}, {k*step}): {count[i][j][k] / volume}")