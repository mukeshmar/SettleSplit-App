package live.mukeshtechlab.settlesplitapp.dtos.userDto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserRequestDto {
    private String name;
    private String phoneNumber;
    private String password;
}
