#!/usr/bin/env sh

# ----------------------------------------------------------------------------
#  Gradle startup script for UNIX
# ----------------------------------------------------------------------------

APP_HOME="`pwd -P`"
DEFAULT_JVM_OPTS=""
JAVA_EXE="java"

exec "$JAVA_EXE" $DEFAULT_JVM_OPTS -classpath "$APP_HOME/gradle/wrapper/gradle-wrapper.jar" org.gradle.wrapper.GradleWrapperMain "$@"
