#!/bin/sh

#
# $Id: mqbroker 1840 2013-05-16 02:13:59Z shijia.wxr $
#

if [ -z "$ROCKETMQ_HOME" ] ; then
  ## resolve links - $0 may be a link to maven's home
  PRG="$0"

  # need this for relative symlinks
  while [ -h "$PRG" ] ; do
    ls=`ls -ld "$PRG"`
    link=`expr "$ls" : '.*-> \(.*\)$'`
    if expr "$link" : '/.*' > /dev/null; then
      PRG="$link"
    else
      PRG="`dirname "$PRG"`/$link"
    fi
  done

  saveddir=`pwd`

  ROCKETMQ_HOME=`dirname "$PRG"`/..

  # make it fully qualified
  ROCKETMQ_HOME=`cd "$ROCKETMQ_HOME" && pwd`

  cd "$saveddir"
fi

export ROCKETMQ_HOME

sh ${ROCKETMQ_HOME}/bin/runbroker.sh com.alibaba.rocketmq.broker.BrokerStartup $@