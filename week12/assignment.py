def knapsack(items, max_weight):
    n = len(items)
    dp = [[0] * (max_weight + 1) for _ in range(n + 1)]

    # DP 테이블 채우기
    for i in range(1, n + 1):
        value, weight, _ = items[i - 1]
        for w in range(max_weight + 1):
            if weight <= w:
                dp[i][w] = max(dp[i - 1][w], dp[i - 1][w - weight] + value)
            else:
                dp[i][w] = dp[i - 1][w]

    # 선택된 영상 추적
    selected_items = []
    w = max_weight
    for i in range(n, 0, -1):
        if dp[i][w] != dp[i - 1][w]:
            selected_items.append(items[i - 1][2])  # 이름 추가
            w -= items[i - 1][1]

    return dp[n][max_weight], selected_items[::-1]



# 데이터 입력
n = int(input("1. 입력할 '나중에 볼 동영상' 개수를 입력해주세요: "))
items = []
for i in range(n):
    print()
    name = input(f"\t{i+1}번째 동영상의 제목: ")
    weight = input(f"\t{i+1}번째 동영상의 길이(분): ")
    value = input(f"\t{i+1}번째 동영상을 '나중에 볼 동영상'에 저장한 시점(n일 전):")
    items.append((int(value), int(weight), name))

# 영상을 볼 시간 입력
print()
max_weight = int(input("2. 하루에 '나중에 볼 동영상'을 몰아보는 데 사용할 시간을 입력해주세요(분): "))

# DP 실시
max_value, selected_items = knapsack(items, max_weight)

# 결과 출력
print("봐야할 동영상 출력:")
print(", ".join(selected_items))

