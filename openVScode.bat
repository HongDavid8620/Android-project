@echo off
CD d:
CD \
set /p DirLaravel=Enter project directory:
cd "%DirLaravel%"
code .
exit

