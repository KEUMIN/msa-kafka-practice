# 마이크로서비스 아키텍처 예제 프로젝트

이 프로젝트는 Spring Boot와 Spring Cloud를 사용한 간단한 마이크로서비스 아키텍처 예제입니다. 주문 생성과 알림 처리를 통해 마이크로서비스 간의 통신을 구현했습니다.

## 아키텍처 개요

이 시스템은 다음 컴포넌트로 구성되어 있습니다:

1. Eureka Server: 서비스 디스커버리
2. API Gateway: 요청 라우팅
3. Order Service: 주문 처리
4. Notification Service: 알림 처리
5. Kafka: 비동기 메시징

## 작동 원리

1. 시스템 시작
   - Eureka Server가 시작되어 서비스 등록을 준비합니다.
   - 각 서비스(API Gateway, Order Service, Notification Service)가 시작되어 Eureka Server에 자신을 등록합니다.

2. 클라이언트 요청 처리
   - 클라이언트가 API Gateway로 주문 생성 요청을 보냅니다.
   - API Gateway는 요청을 Order Service로 라우팅합니다.
   - Order Service는 주문을 처리하고 Kafka로 이벤트를 발행합니다.

3. 비동기 알림 처리
   - Notification Service는 Kafka에서 주문 생성 이벤트를 구독합니다.
   - 새 주문 이벤트를 받으면 알림 처리 로직을 실행합니다.

## 주요 기술 스택

- Spring Boot
- Spring Cloud Netflix (Eureka)
- Spring Cloud Gateway
- Apache Kafka
- Docker (Kafka 실행용)

## 시작하기

1. Kafka 실행:
    docker-compose up -d
   
3. 각 서비스 실행 (순서대로):
- Eureka Server
- Order Service
- Notification Service
- API Gateway

3. API 테스트:
- POST 요청을 `http://localhost:8080/orders`로 보내 주문 생성
- 요청 본문 예시:
  ```json
  {
    "userId": 1,
    "product": "Example Product",
    "quantity": 2
  }
  ```

## 향후 개선 사항

- 보안 기능 추가 (예: OAuth2, JWT)
- 데이터베이스 연동
- 서킷 브레이커 패턴 구현
- 분산 로깅 및 모니터링 도구 통합
