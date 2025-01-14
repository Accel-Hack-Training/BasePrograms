# create relate cloud api user
CREATE USER 'api-agent'@'%' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON *.* TO 'api-agent'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;

# grant privileges
GRANT SELECT, INSERT, UPDATE, DELETE ON base.* TO 'api-agent'@'%';
