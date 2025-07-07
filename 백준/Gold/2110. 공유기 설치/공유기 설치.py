import sys

def bs(positions, C, dist):
    """
    positions: 정렬된 집 좌표 리스트
    C: 설치할 공유기 수
    dist: 최소 간격(dist) 이상으로 공유기를 설치할 수 있는지 여부 반환
    """
    count = 1          # 첫 집에는 무조건 하나 설치
    last = positions[0]
    for x in positions[1:]:
        if x - last >= dist:
            count += 1
            last = x
            if count >= C:
                return True
    return False

def main():
    N, C = map(int, sys.stdin.readline().split())
    positions = [int(sys.stdin.readline()) for _ in range(N)]
    positions.sort()

    # 이진 탐색 범위: 최소 1, 최대 (끝과 시작 집 좌표 차이)
    left, right = 1, positions[-1] - positions[0]
    answer = 0

    while left <= right:
        mid = (left + right) // 2
        if bs(positions, C, mid):
            answer = mid       # mid 간격으로 설치 가능하므로 더 큰 간격을 시도
            left = mid + 1
        else:
            right = mid - 1    # mid 간격으로 설치 불가능 → 간격 줄이기

    print(answer)


if __name__ == "__main__":
    main()