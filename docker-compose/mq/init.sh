#!/bin/bash

echo "RabbitMQ 클러스터 연결 및 미러링 시작"

echo "RabbitMQ 종료"
rabbitmqctl stop_app

echo "RabbitMQ 클러스터 연결"
rabbitmqctl join_cluster rabbit@rabbit01

sleep 2

echo "RabbitMQ 시작"
rabbitmqctl start_app

sleep 2

echo "RabbitMQ 미러링"
rabbitmqctl set_policy ha-all "ha." '{"ha-mode":"all"}'
