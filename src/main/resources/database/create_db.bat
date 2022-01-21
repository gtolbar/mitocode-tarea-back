@echo off

SET server=localhost

SET database=postgres

SET port=5432

SET username=postgres

SET PGPASSWORD=admin

"C:\Program Files\PostgreSQL\14\bin\psql.exe" -h %server% -U %username% -d %database% -p %port% -f create_db.sql

