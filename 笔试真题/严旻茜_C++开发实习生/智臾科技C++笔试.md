# 智臾科技C++笔试

## 1. 分配任务

```python
import heapq


def max_profit(n, m, r, tasks, schedules):
    tasks.sort(key=lambda x: (-x[1], x[0]))  # Sort tasks by profit (descending) and deadline
    schedules.sort(key=lambda x: -x[2])  # Sort schedules by work capacity (descending)

    max_profit = 0
    task_idx = 0
    available_tasks = []

    for l, r, w in schedules:
        while task_idx < m and tasks[task_idx][0] <= r:
            heapq.heappush(available_tasks, (-tasks[task_idx][1], tasks[task_idx][0]))
            task_idx += 1

        while available_tasks and w > 0:
            profit, deadline = heapq.heappop(available_tasks)
            if deadline >= l:
                max_profit -= profit
                w -= 1

    return max_profit


# Example usage
n, m, r = map(int, input().split())

tasks = []
for _ in range(m):
    d, g = map(int, input().split())
    tasks.append((d, g))

schedules = []
for _ in range(r):
    l, r, w = map(int, input().split())
    schedules.append((l, r, w))

result = max_profit(n, m, r, tasks, schedules)
print(result)
```

**时间复杂度分析：**

O((m + r) * log(m + r)).主要计算任务和调度的排序。

## 2. 超级计算机

```c++
#include <iostream>
#include <cmath>

using namespace std;

struct TimeResult {
    int time;
    int state;  
};
// 计算任务的总耗时
TimeResult calculateTime(int r, int c, int t) {
    int computeTime = ceil(static_cast<double>(r) / (2 * t)) + ceil(static_cast<double>(c) / t);
    int ioTime = ceil(static_cast<double>(r) / t) + ceil(static_cast<double>(c) / (2 * t));
    if (computeTime < ioTime) {
        return {computeTime, 0};  
    } else {
        return {ioTime, 1};       
    }
}

// 判断在时间T内是否能完成所有任务
bool canCompleteAllTasks(int n, int m, int T, int* r, int* c, int t) {
    int lastState;
    int totalTime = 0;
    int switchCount = 0;
    
    //第一个任务
    TimeResult result = calculateTime(r[0], c[0], t);
    lastState = result.state;
    totalTime += result.time;
    
    for (int i = 1; i < n; ++i) {
        TimeResult result = calculateTime(r[i], c[i], t);
        int taskTime = result.time;
        if(lastState != result.state){
            switchCount++;
            if (switchCount > m) {
                return false;
            }
        }
        lastState = result.state;
        totalTime += taskTime;
        if(totalTime > T){
            return false;
        }
    }

    return true;
}

// 二分查找最小处理能力
int binarySearch(int n, int m, int T, int* r, int* c) {
    int left = 1, right = T;
    int result = T;

    while (left <= right) {
        int mid = (left + right) / 2;
        if (canCompleteAllTasks(n, m, T, r, c, mid)) {
            result = mid;
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }

    return result;
}

int main() {
    int n, m, T;
    cin >> n >> m >> T;

    int r[n], c[n];
    for (int i = 0; i < n; ++i) {
        cin >> r[i] >> c[i];
    }

    int result = binarySearch(n, m, T, r, c);
    cout << result << endl;

    return 0;
}
```

**时间复杂度分析：**

对于二分查找算法，时间复杂度主要由二分查找的迭代次数决定。在这个问题中，二分查找的时间复杂度为 O(log T)。

在每次迭代中，我们调用 `canCompleteAllTasks` 函数来判断给定的处理能力 t 是否足够完成所有任务。这个函数的时间复杂度是 O(n)，其中 n 是任务的数量。因为我们最多迭代 log T 次，所以总体时间复杂度为 O(n log T)。

因此，整体算法的时间复杂度为 O(n log T)。在实际应用中，这个算法对于规模较小的问题是可以接受的。

## 3. Mrank

```c++
#include <iostream>
#include <vector>

std::vector<int> numbers;

int mrank(int num) {
    int rank = 0;
    for (int n : numbers) {
        if (n < num) {
            rank++;
        }
    }
    numbers.push_back(num);
    return rank;
}

int main() {
    int num;
    while (true) {
        std::cout << "Enter a number (or 'q' to quit): ";
        if (!(std::cin >> num)) {
            break;
        }
        int rank = mrank(num);
        std::cout << rank << std::endl;
    }
    return 0;
}

```

**时间复杂度分析：**

在主循环中，每个输入元素都会执行插入和查找操作。因此，总体的时间复杂度可以表示为 O(N log N)，其中 N 是输入元素的总数量。