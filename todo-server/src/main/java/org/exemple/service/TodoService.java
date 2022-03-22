package org.exemple.service;

import lombok.AllArgsConstructor;
import org.exemple.mobel.TodoMobel;
import org.exemple.mobel.TodoRequest;
import org.exemple.repository.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    //1 todo 리스트 목록에 아이템 추가
    //2. todo 리스트 목록 중 특정 아이템 조회
    //3. todo 리스트 전체 목록을 조회
    //4. todo 리스트 리스트 목록 중 특정 아이템을 수정
    //5. todo 리스트 목록 중 특정 아이템을 삭제
    //6. todo 리스트 전체 목록을 삭제

    public TodoMobel add(TodoRequest request){
        TodoMobel todoMobel = new TodoMobel();
        todoMobel.setTitle(request.getTitle());
        todoMobel.setOrder(request.getOrder());
        todoMobel.setCompleted(request.getCompleted());
        return this.todoRepository.save(todoMobel);
    }

    public TodoMobel searchbyId(Long id){
        return this.todoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<TodoMobel> searchAll(){
        return this.todoRepository.findAll();
    }

    public TodoMobel updatebyId(Long id, TodoRequest request){
        TodoMobel todoMobel = this.searchbyId(id);
        if(request.getTitle() != null){
            todoMobel.setTitle(request.getTitle());
        }
        if(request.getOrder() != null){
            todoMobel.setOrder(request.getOrder());
        }
        if(request.getCompleted() != null){
            todoMobel.setCompleted(request.getCompleted());
        }

        return this.todoRepository.save(todoMobel);
    }

    public void deleteById(Long id){
        this.todoRepository.deleteById(id);
    }

    public void deleteAll(){
        this.todoRepository.deleteAll();
    }


}
