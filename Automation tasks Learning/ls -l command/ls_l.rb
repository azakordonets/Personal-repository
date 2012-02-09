require "rubygems"
require "date"
require "etc"

#files_path = "/Users/biercoff/Dropbox/Work/mGage/Bugs screenshots/04.01.2012"
class Files_Ops
  attr_accessor :filepath

  def initialize (filepath)
    @filepath = filepath
  end

  def self.drop_array(array) #delete first two invisible files "." and ".."
  array.drop(2)
  end

  def self.get_files_array(file) # take all files from the directory - doesn't take into account sub directories so far'
  files_array = Dir.entries(file)
  files_array = drop_array(files_array)
  files_array.map!{|x| x = "#{file}""/#{x}"} # addes full path to the file, otherwise atime method doesn't want to work'
  end

  def self.convert_month(number)    # converts month from Integer into a word
  month = Date::MONTHNAMES[number].to_s
  month[0..2]
  end

  def self.strip (name)
    name.lstrip!
    name.rstrip!
    name
  end

  def self.octal_to_letters (number)  # transfer file permission from octal to letters form (human readable)
      case number
           when "6"
      human_read = "rw-"
           when "3"
      human_read = "-wx"
           when "1"
      human_read = "--x"
           when "2"
      human_read = "-w-"
           when "4"
      human_read = "r--"
           end
      human_read
  end

   def self.determine_file_type (type)  # determines file or directory type and adds correspond symbol into the end of file permission line
      case type
           when "file"
      human_read = "-"
           when "directory"
      human_read = "d"
           when "pipe"
      human_read = "p"
           when "socket"
      human_read = "s"
           when "link"
      human_read = "l"
           end
      human_read
    end


def self.permission_from_dec_to_octal (permission_id) # transform permission_id from decimal into letters form
  human_array = []
  octal = permission_id.to_s 8
  array = octal.to_s.split('')
  final_array = array[-3,3]
   i = 0
  while i.between?(0,2)
  human_array << octal_to_letters(final_array[i])
    i += 1
  end
  human_array.to_s
end

  def self.date_array(files_array) # creates an array of time stamps for each file
   files_array.flatten!
   date_array = []
   x = 0
   day = strip(File.atime(files_array[x]).day.to_s)
   month = convert_month(File.atime(files_array[x]).month)
   hour = strip("#{File.atime(files_array[x]).hour}:")
   min = strip(File.atime(files_array[x]).min.to_s)
   file_date = month.ljust(4) + day.ljust(2) + hour.rjust(4) + min
   date_array.push(file_date)
   date_array
  end

  def self.filename (file)
   File.basename(file)
  end

  def self.get_owner_name(filename)
   user_id = File.stat(filename).uid
   owner_name = Etc.getpwuid(user_id).name
  end

  def self.get_group_name(filename)
   user_id = File.stat(filename).gid
   owner_name = Etc.getgrgid(user_id).name
  end

  def self.get_file_size(filename)
   size = File.stat(filename).size
  end

  def self.number_of_links(filename)
  number_of_links =  File.stat(filename).nlink
  number_of_links.to_s
  end

  def show_result
  folderFilesArray = Files_Ops.get_files_array(@filepath)
  number_of_files_in_dir = Dir.open(@filepath).collect.length-2
  count = 0
    while count.between?(0,number_of_files_in_dir-1)
      date = Files_Ops.date_array(folderFilesArray).to_s
      filename =  Files_Ops.filename(folderFilesArray[count]).to_s
      owner_name = Files_Ops.get_owner_name(folderFilesArray[count]).to_s
      group_name =  Files_Ops.get_group_name(folderFilesArray[count]).to_s
      file_size = Files_Ops.get_file_size(folderFilesArray[count]).to_s
      permission =  "#{Files_Ops.determine_file_type(File.stat(folderFilesArray[count]).ftype)}#{Files_Ops.permission_from_dec_to_octal(File.stat(folderFilesArray[count]).mode)}"
      number_of_links =  Files_Ops.number_of_links(folderFilesArray[count])
      puts "#{permission} #{number_of_links} #{owner_name} #{group_name} #{file_size} #{date} #{filename} "
      count += 1
    end
  end
end


puts "Hello, this program imitates unix ls -l command. Enter ls -l"
location = gets.chomp
while location != "exit"
if location == "ls -l"
result = Files_Ops.new("/Users/biercoff/Dropbox/Work/mGage/Bugs screenshots/04.01.2012")
result.show_result
puts "Enter ls -l. To finish program type 'exit' "
location =  gets.chomp
else
puts "Enter ls -l. To finish program type 'exit' "
location = gets.chomp
end
end




