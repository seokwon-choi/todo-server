package org.exemple.mobel;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TodoResponse {
    private Long id;
    private String title;
    private Long order;
    private Boolean completed;
    private String url;

    public TodoResponse(TodoMobel todoMobel){
        this.id = todoMobel.getId();
        this.title = todoMobel.getTitle();
        this.order = todoMobel.getOrder();
        this.completed = todoMobel.getCompleted();

        this.url = "http://localhost:8080/" + this.id;
    }
}
