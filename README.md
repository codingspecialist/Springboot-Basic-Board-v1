# 스프링부트 게시판 만들기

### 의존성
```txt
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-mustache'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	compileOnly 'org.projectlombok:lombok'
	developmentOnly 'org.springframework.boot:spring-boot-devtools'
	runtimeOnly 'org.mariadb.jdbc:mariadb-java-client'
	annotationProcessor 'org.projectlombok:lombok'
```

### 핵심
- JPA 라이브러리를 사용은 하지만 그 기능을 사용하지는 않을 예정 (DB 연결에 용도로만 사용)
- 직접 Query를 작성해서 게시판을 만들 예정
- 직접 테이블도 생성할 예정
- ORM을 사용안하겠다는 뜻
- 서비스 안만들 예정
- EntityManager 사용할 예정 (예전에 PrepareStatement와 비슷한 것)

### 테이블 생성하기
```sql
CREATE TABLE board (
  id INT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(100),
  content LONGTEXT,
  nickname VARCHAR(20)
);
```

### 직접 EntityManager로 select 하려면 힘듬
```java
   // 1. 쿼리 작성
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM board ORDER BY id DESC");

        // 2. 쿼리 준비
        Query query = em.createNativeQuery(sb.toString());

        // 3. 쿼리 실행
        List<?> results = query.getResultList();
        List<Board> boards = results.stream()
                .map(objArr -> {
                    Object[] rs = (Object[]) objArr;
                    Integer id = (Integer) rs[0];
                    String title = (String) rs[1];
                    String content = (String) rs[2];
                    String nickname = (String) rs[3];

                    Board board = new Board(id, title, content, nickname);
                    return board;
                }).collect(Collectors.toList());

        System.out.println(boards.size()); // 1
        System.out.println(boards.get(0).getNickname()); // 메타코딩

```