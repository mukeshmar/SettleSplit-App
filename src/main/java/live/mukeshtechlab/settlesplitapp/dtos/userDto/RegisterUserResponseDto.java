package live.mukeshtechlab.settlesplitapp.dtos.userDto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserResponseDto {
    private String name;
    private String phoneNumber;

    @Override
    public String toString() {
        return "RegisterUserResponseDto{\n" +
                "name= " + name + "," + "\n" +
                "phoneNumber= " + phoneNumber + "\n" +
                '}';
    }
}
