package app.prog.controller.mapper;
import app.prog.controller.response.AuthorResponse;
import app.prog.controller.response.CreateAuthorResponse;
import app.prog.controller.response.CreateBookResponse;
import app.prog.controller.response.UpdateAuthorResponse;
import app.prog.model.AuthorEntity;
import app.prog.service.AuthorService;
import org.springframework.stereotype.Component;

@Component
public class AuthorRestMapper {
    private AuthorService service;
    public AuthorResponse toRest(AuthorEntity domain){
        return AuthorResponse.builder()
                .id(domain.getId())
                .name(domain.getName())
                .particularity(domain.getParticularity())
                .hasParticularity(domain.hasParticularity())
                .build();
    }

    public AuthorEntity toDomain(CreateAuthorResponse rest){
        return AuthorEntity.builder()
                .name(rest.getName())
                .birthDate(rest.getBirthDate())
                .particularity(rest.getParticularity())
                .build();
    }

    public AuthorEntity toUpdate(UpdateAuthorResponse rest){
        AuthorEntity toUpdate = service.findbyId(rest.getId());
            toUpdate.setName(rest.getName());
            toUpdate.setBirthDate(rest.getBirthDate());
            toUpdate.setParticularity(rest.getParticularity());
        return toUpdate;
    }
}
