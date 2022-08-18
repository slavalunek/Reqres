package rest.dto.clients.getModals;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor(access = PRIVATE)
@NoArgsConstructor
@Builder
public class Counts {

    public int cases;
    public int suites;
    public int milestones;
    public Runs runs;
    public Defects defects;
}
