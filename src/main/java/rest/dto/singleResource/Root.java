package rest.dto.singleResource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@lombok.Data
@AllArgsConstructor(access = PRIVATE)
@NoArgsConstructor
@Builder
public class Root {

    public Data data;
    public Support support;
}
