echo USAGE: createDB.bat _PASSWORD FOR MYSQL ROOT_  _SQL SCRIPT_
PAUSE
mysql --user=root --password=%1 < %2
