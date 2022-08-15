package rest.dto.singleUser;

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
    public String email;
    public String first_name;
    public String last_name;
    public String avatar;
}
