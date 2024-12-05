gifts = [
    {"name": "운동화", "price": 45000, "category": "운동용품"},
    {"name": "스마트워치", "price": 120000, "category": "전자기기"},
    {"name": "요가매트", "price": 30000, "category": "운동용품"},
    {"name": "책상", "price": 80000, "category": "가구"},
    {"name": "노트북", "price": 1500000, "category": "전자기기"},
    {"name": "이어폰", "price": 25000, "category": "전자기기"},
    {"name": "스케이트보드", "price": 70000, "category": "운동용품"},
    {"name": "러닝머신", "price": 300000, "category": "운동용품"},
    {"name": "키보드", "price": 50000, "category": "전자기기"},
    {"name": "헤드셋", "price": 40000, "category": "전자기기"},
    {"name": "커피머신", "price": 90000, "category": "가전제품"},
    {"name": "공기청정기", "price": 200000, "category": "가전제품"},
    {"name": "배낭", "price": 55000, "category": "패션"},
    {"name": "축구공", "price": 30000, "category": "운동용품"},
    {"name": "미술도구 세트", "price": 35000, "category": "예술"},
    {"name": "드론", "price": 500000, "category": "전자기기"},
    {"name": "조명", "price": 45000, "category": "가구"},
    {"name": "손목 보호대", "price": 15000, "category": "운동용품"},
    {"name": "에코백", "price": 20000, "category": "패션"},
    {"name": "기타", "price": 120000, "category": "악기"}
]

# 입력
budget_in = int(input("예산을 입력해주세요: "))
category_in = input("관심사를 입력해주세요: ")
priority_in = input("우선순위를 입력해주세요(budget|category): ")

# 처리
candidate = [] # 선물 후보
money = 0 # 후보 금액 합계
for gift in gifts:
    # 조건 만족 여부 검사
    name = gift["name"]
    price = gift["price"]
    category = gift["category"]
    if priority_in == "category": # 우선순위가 카테고리 일 때
        if category != category_in: # 우선순위가 맞지 않으면 패스
            continue
    # 예산 확인
    money += price
    if money >= budget_in: # 예산 초관인 경우
        break # 탐색 끝
    # 후보에 추가
    candidate.append(gift)

# 출력
print("추천 선물 목록:")
for candi in candidate:
    print(candi)