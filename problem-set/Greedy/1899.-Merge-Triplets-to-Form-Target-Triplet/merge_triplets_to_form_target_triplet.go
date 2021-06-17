package main

func mergeTriplets(triplets [][]int, target []int) bool {
	var length = len(triplets)
	if length == 0 {
		return false
	}
	if length == 1 {
		return triplets[0][0] == target[0] &&
			triplets[0][1] == target[1] &&
			triplets[0][2] == target[2]
	}
	var init = [3]int{0, 0, 0}
	for i := 0; i < length; i++ {
		if triplets[i][0] > target[0] || triplets[i][1] > target[1] || triplets[i][2] > target[2] {
			continue
		}
		if init[0] < triplets[i][0] {
			init[0] = triplets[i][0]
		}
		if init[1] < triplets[i][1] {
			init[1] = triplets[i][1]
		}
		if init[2] < triplets[i][2] {
			init[2] = triplets[i][2]
		}
		if init[0] == target[0] && init[1] == target[1] && init[2] == target[2] {
			return true
		}
	}
	return false
}
