require "rubygems"
require "date"
require "etc"

files_path = "/Users/biercoff/Dropbox/Work/mGage/Bugs screenshots/04.01.2012"
class Files_Ops
  attr_accessor :filename

  def initialize (filepath)
    @filename = filepath
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

end

folderFilesArray = Files_Ops.get_files_array(files_path)

puts Files_Ops.date_array(folderFilesArray)
puts Files_Ops.filename(folderFilesArray[0])
puts mode = File.stat(folderFilesArray[0]).mode
puts mode.to_i[8]
puts Files_Ops.get_owner_name(folderFilesArray[0])
puts Files_Ops.get_group_name(folderFilesArray[0])
puts Files_Ops.get_file_size(folderFilesArray[0])



#puts b

