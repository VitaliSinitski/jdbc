package vitali.homeWork.lesson05.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor

@MyTable("Person")
public class Person {
    @PrimaryKey
    @MyColumn("id")
    private int id;
    @MyColumn("name")
    private String name;
    @MyColumn("surname")
    private String surname;
}
