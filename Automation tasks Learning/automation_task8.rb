require "rubygems"

puts "Enter string"
string = gets.chomp
array = string.split(//)
puts array.to_s
i = 1
while i.between?(1,array.size) do
  if array[i] == array[0]
     array[i] = "*"
  else
    array[i]
  end
  i += 1
end
puts array.to_s