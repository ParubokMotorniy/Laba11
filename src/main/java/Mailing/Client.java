package Mailing;

import lombok.Getter;
import lombok.Setter;

public class Client
{
    @Getter
    private int id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private int age;

    @Getter
    @Setter
    private Gender gender;

    @Getter
    @Setter
    private String email;

    public Client (String name, String email, int age, Gender gender)
    {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.id = IDManager.GetInstance().AssignID();
        this.email = email;
    }
}
