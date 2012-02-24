require "rubygems"

list = Array[1,2,3,4,5,6,7,8]
half = list.size/2
part1 = []
part2 = []
part1 << list[0..half-1]
part2 << list[half..list.size]
puts part1.to_s
puts "\n"
puts part2.to_s