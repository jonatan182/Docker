#!/bin/bash
sleep 10s
ls -ltrh /home
cd /home

mysql -h"$MYSQL_PORT_3306_TCP_ADDR" -P"$MYSQL_PORT_3306_TCP_PORT" -uroot -p"$MYSQL_ENV_MYSQL_ROOT_PASSWORD" -e "CREATE USER 'mradmin'@'localhost' IDENTIFIED BY 'mradminpassword'"
mysql -h"$MYSQL_PORT_3306_TCP_ADDR" -P"$MYSQL_PORT_3306_TCP_PORT" -uroot -p"$MYSQL_ENV_MYSQL_ROOT_PASSWORD" -e "GRANT ALL PRIVILEGES ON *.* TO 'mradmin'@'localhost'"

for sqlfile in /home/*.sql
do
	echo "Restoring backup from - $sqlfile"
		mysql -h"$MYSQL_PORT_3306_TCP_ADDR" -P"$MYSQL_PORT_3306_TCP_PORT" -uroot -p"$MYSQL_ENV_MYSQL_ROOT_PASSWORD" --default-character-set=utf8 --comments < /$sqlfile
done
