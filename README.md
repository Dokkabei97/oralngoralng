# 올랑올랑

---

## Stack

- Kotlin / Spring Boot
- Go / Gin
- TypeScript / Next.js
- Dart / Flutter (삭제 이유 Kotlin 공통 모듈로 변경)
- Elasticsearch / Logstash || Filebeat / Kibana
- GraphQL
- Kafka
- gRPC
- MySQL
- Redis
- Minio
- Grafana / Prometheus / Influxdb
- Docker / Kubernetes (Docker Desktop Single Kube)

로컬 포트 표

| 서비스            | 포트(Local) / 포트 (server) | 비고      |
|----------------|-------------------------|---------|
| user           | 8080 / 8080             | 백엔드     |
| order          | 8081 / 8080             | 백엔드     |
| pay            | 8082 / 8080             | 백엔드     |
| review         | 8083 / 8080             | 백엔드     |
| admin          | 8090 / 8080             | 백엔드     |
| pay-grpc       | 8090 / 8080             | 백엔드     |
| admin-front    | 3000 / 3000             | 프론트     |
| user-front     | x                       | 프론트     |
| mysql          | 3306~3310  / 3306       | db      |
| elasticsearch  | 9200~9300 / 9200 ~ 9300 | 검색엔진    |
| kibana         | 5601 / 5601             | 검색엔진    |
| logstash       | 5600, 9600 / 5600, 9600 | 검색엔진    |
| filebeat       | 미정 / 미정                 | 검색엔진    |
| minio          | 9001 / 9101~9104        | 저장소     |
| grafana        | 9090 / 3000             | 모니터링    |
| prometheus     | 9000 / 9000             | 모니터링    |
| influxdb       | 9086 / 8086             | 모니터링    |
| kafka          | 9092 / 9092             | 이벤트 브로커 |
| redis          | 6379~6381               | 캐시db    |
| redis-sentinel | 26379~26381             | 캐시db    |
