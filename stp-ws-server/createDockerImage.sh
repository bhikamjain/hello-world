#!/bin/bash

docker build -t ubs-hack-occhi-stp .
docker tag  817620470296 rlit/ubs-hack-occhi-stp:latest
docker login
docker push rlit/ubs-hack-occhi-stp

#docker pull rlit/ubs-interview
