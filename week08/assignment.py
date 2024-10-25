import json
from collections import Counter

# JSON 파일 경로
input_file = 'team_data.json'  

# JSON 파일에서 데이터를 로드
with open(input_file, 'r', encoding='utf-8') as file:
    data = json.load(file)

# 모든 가능한 시간을 하나의 리스트로 저장
all_times = []
for member in data['team_members']:
    all_times.extend(member['available_times'])

# 모든 시간을 카운트하여 가장 많이 겹치는 시간을 찾음
time_counts = Counter(all_times)
max_count = max(time_counts.values()) if time_counts else 0

# 최적의 시간을 찾고 해당 시간에 참석 가능한 멤버들을 확인
optimal_times = [time for time, count in time_counts.items() if count == max_count]
if max_count > 1:
    for time in optimal_times:
        attending_members = [member['name'] for member in data['team_members'] if time in member['available_times']]
        print(f"최적의 회의 시간: {time} (참석 가능 멤버: {', '.join(attending_members)})")
else:
    print("모든 멤버가 참석할 수 있는 공통 시간이 없습니다. 일정을 다시 조정하세요!")