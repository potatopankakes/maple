#!/bin/sh
mvn -Denv=devlocal -npu war:inplace tomcat:inplace
