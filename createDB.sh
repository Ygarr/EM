!#/bin/sh
echo USAGE: createDB.sh _PASSWORD FOR MYSQL ROOT_  _SQL SCRIPT_
mysql --user=root --password=$1 < $2
