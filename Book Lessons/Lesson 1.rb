puts 'Привет! Как тебя зовут?'
name = gets.chomp
puts 'Очень рад знакомству ' + name + ''
puts 'What about your last name? '
lastname = gets.chomp
puts 'Really? your last name is ' + lastname + '? Mine is too!'
puts %q<What about your father's  name?>
fathersname = gets.chomp
puts 'Now that\'s awesome! So, let me get this clear - your name is ' + name + ' and your last name is '+ lastname +'.
 And father\'s name is : ' +fathersname+ " ! . Incredible"
puts 'Did you know that you name has ' +name.length.to_s+ ' symbols? And your last name has ' +lastname.length.to_s+' symbols'
puts 'and so is your father\'s name -  '+fathersname.length.to_s+ ' symbols. '
puts "If you put them together, then you\'ll get #{name.length+lastname.length+fathersname.length} symbols"
