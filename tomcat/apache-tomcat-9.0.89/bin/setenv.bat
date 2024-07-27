@echo off

rem ---------------------------------------------------------------------------
rem Environment Variable Prerequisites
rem 
rem     Put them into a script setenv.sh in CATALINA_BASE/bin to keep your customizations separate.
rem ---------------------------------------------------------------------------

rem set JPDA_TRANSPORT=dt_socket
set JPDA_ADDRESS=localhost:9000
set JPDA_SUSPEND=y
