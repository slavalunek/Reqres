package rest.dto.singleResource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@lombok.Data
@AllArgsConstructor(access = PRIVATE)
@NoArgsConstructor
@Builder
public class Data {

    public int id;
    public String name;
    public int year;
    public String color;
    public String pantone_value;
}
