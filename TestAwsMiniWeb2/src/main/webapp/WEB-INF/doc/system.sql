CREATE USER edu IDENTIFIED by edu12 account unlock
default tablespace users;

grant RESOURCE, CONNECT
to edu;

