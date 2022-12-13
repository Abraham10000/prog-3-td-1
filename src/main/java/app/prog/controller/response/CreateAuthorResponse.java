package app.prog.controller.response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
@Builder
public class CreateAuthorResponse {
    private String name;
    private Date birthDate;
    private String particularity;
}
