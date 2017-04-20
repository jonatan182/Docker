FROM mysql:5.5.48
	
COPY restore.sh /restore.sh
RUN chmod 755 /restore.sh

ENTRYPOINT ["/entrypoint.sh"]

EXPOSE 3306
CMD ["mysqld"]