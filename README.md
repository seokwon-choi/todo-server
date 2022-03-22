# todo-server

## ToDo Application server 요구사항
###
|method|endpoint|기능|request|response|
|:---:|:---:|:---:|:---:|:---:|
|POST|/|todo 아이템 추가|{</br>"title": "자료구조 공부하기"</br>}|{</br>"id": 17,</br>"title": "자료구조 공부하기",</br>"order": 0,</br>"completed": false,</br>"url": "http://localhost:8080/17"</br>}|
|GET|/|전체 todo 리스트 조회|-|[</br>{</br>"id": 1,</br>"title": "자바 기초 공부하기",</br>"order": 0,</br>"completed": false,</br>"url”: "http://localhost:8080/1"</br>},</br>{</br>"id": 2,</br>"title": "알고리즘 공부하기",</br>"order": 0,</br>"completed": false,</br>"url": "http://localhost:8080/2"</br>}, …</br>]|
|GET|/{:id}|todo 아이템 조회|-|{</br>"id": 17,</br>"title": "자료구조 공부하기",</br>"order": 0,</br>"completed": false,</br>"url": "http://localhost:8080/17"</br>}|
|PATCH|/{:id}|todo 아이템 수정|{</br>"title": "반복문 공부하기"</br>}|{</br>"id": 1,</br>"title": "반복문 공부하기",</br>"order": 0,</br>"completed": false,</br>"url": "http://localhost:8080/1"</br>}|
|DELETE|/|전체 todo 리스트 삭제|-|200|
|DELETE|/{:id}|todo 아이템 삭제|-|200|
