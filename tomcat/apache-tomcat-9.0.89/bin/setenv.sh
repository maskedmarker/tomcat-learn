#!/bin/sh

# ---------------------------------------------------------------------------
# Environment Variable Prerequisites
#
#   Put them into a script setenv.sh in CATALINA_BASE/bin to keep your customizations separate.
#
#   CATALINA_OPTS   (Optional) Java runtime options used when the "start",
#                   "run" or "debug" command is executed.
#                   Include here and [not in] JAVA_OPTS all options, that should
#                   only be used by Tomcat itself, not by the stop process,
#                   the version command etc.
#                   Examples are heap size, GC logging, JMX ports etc.
#
#   JAVA_OPTS       (Optional) Java runtime options used when [any] command
#                   is executed.
#                   Include here and not in CATALINA_OPTS all options, that
#                   should be used by Tomcat and also by the stop process,
#                   the version command etc.
#                   Most options should go into CATALINA_OPTS.
#
#   JPDA_TRANSPORT  (Optional) JPDA transport used when the "jpda start"
#                   command is executed. The default is "dt_socket".
#
#   JPDA_ADDRESS    (Optional) Java runtime options used when the "jpda start"
#                   command is executed. The default is localhost:8000.
#
#   JPDA_SUSPEND    (Optional) Java runtime options used when the "jpda start"
#                   command is executed. Specifies whether JVM should suspend
#                   execution immediately after startup. Default is "n".
# ---------------------------------------------------------------------------  

# witch jpda cmd parameter, below are jpda default value, check catalina.sh for detail
JPDA_TRANSPORT="dt_socket"
JPDA_ADDRESS="localhost:9000"
JPDA_SUSPEND="y"
# JPDA_OPTS="-agentlib:jdwp=transport=$JPDA_TRANSPORT,address=$JPDA_ADDRESS,server=y,suspend=$JPDA_SUSPEND"


