package vgvr.stocksapp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {

    private static Long idUser;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    public static void setIdUser(Long idUser) {
        User.idUser = idUser;
    }

    public static Long getIdUser() {
        return idUser;
    }
}
