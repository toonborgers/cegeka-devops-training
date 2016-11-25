#!/usr/bin/env bash

docker run \
    -p 8888:8888 \
    -v $(which docker):/usr/bin/docker \
    -v /var/run/docker.sock:/var/run/docker.sock \
    --group-add=$(stat -c %g /var/run/docker.sock) \
    --name jenkins-devops-training \
    -d \
    jenkins-tools-training:1