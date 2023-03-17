def merge_sort(arr, temp_arr, left, right):
    inv_count = 0
    
    if left < right:
        mid = (left + right) // 2
        inv_count += merge_sort(arr, temp_arr, left, mid)
        inv_count += merge_sort(arr, temp_arr, mid + 1, right)
        inv_count += merge(arr, temp_arr, left, mid, right)
    
    return inv_count

def merge(arr, temp_arr, left, mid, right):
    inv_count = 0
    i = left
    j = mid + 1
    k = left

    while i <= mid and j <= right:
        if arr[i] <= arr[j]:
            temp_arr[k] = arr[i]
            i += 1
        else:
            temp_arr[k] = arr[j]
            inv_count += (mid - i + 1)
            j += 1
        k += 1

    while i <= mid:
        temp_arr[k] = arr[i]
        i += 1
        k += 1

    while j <= right:
        temp_arr[k] = arr[j]
        j += 1
        k += 1

    for i in range(left, right + 1):
        arr[i] = temp_arr[i]

    return inv_count

def can_convert_to_permutation(N, perm):
    temp_arr = [0] * N
    inversions = merge_sort(perm, temp_arr, 0, N - 1)
    return inversions % 2 == 0

def main():
    while True:
        N = int(input())
        if N == 0:
            break
        perm = list(map(int, input().split()))
        if can_convert_to_permutation(N, perm):
            print("Permutaci lze prevest.")
        else:
            print("Matfyzacci maji smulu.")

if __name__ == "__main__":
    main()
