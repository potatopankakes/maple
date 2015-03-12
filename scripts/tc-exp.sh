#!/bin/sh
mvn -Denv=devlocal -npu war:exploded tomcat:redeploy
