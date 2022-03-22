package org.exemple.service;

import org.exemple.mobel.TodoMobel;
import org.exemple.mobel.TodoRequest;
import org.exemple.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoService todoService;

    @Test
    void add() {
        when(this.todoRepository.save(any(TodoMobel.class))).then(AdditionalAnswers.returnsFirstArg());

        TodoRequest expected = new TodoRequest();
        expected.setTitle("Test Title");

        TodoMobel actual = this.todoService.add(expected);

        assertEquals(expected.getTitle(), actual.getTitle());
    }

    @Test
    void searchbyId() {
        TodoMobel entity = new TodoMobel();
        entity.setId(123L);
        entity.setTitle("TITLE");
        entity.setOrder(0L);
        entity.setCompleted(false);
        Optional<TodoMobel> optional = Optional.of(entity);
        given(this.todoRepository.findById(anyLong())).willReturn(optional);

        TodoMobel actual = this.todoService.searchbyId(123L);
        TodoMobel exprcted = optional.get();

        assertEquals(exprcted.getId(), actual.getId());
        assertEquals(exprcted.getTitle(), actual.getTitle());
        assertEquals(exprcted.getOrder(), actual.getOrder());
        assertEquals(exprcted.getCompleted(), actual.getCompleted());
    }

    @Test
    public void searchByIdFailed(){
        given(this.todoRepository.findById(anyLong())).willReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, () -> {
            this.todoService.searchbyId(123L);
        });
    }
}